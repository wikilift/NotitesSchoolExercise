package com.wikilift.uf1_practico.data.local;

import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

import com.wikilift.uf1_practico.core.helpers.Helpers;
import com.wikilift.uf1_practico.data.model.TaskDto;

import java.util.ArrayList;

public class DatabaseApp extends SQLiteOpenHelper {

    private final String nameOfDb = "taskApp";
    private SQLiteDatabase db;

    public DatabaseApp(Context context) {
        super(context, "app_db", null, 2);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE taskapp (id INTEGER PRIMARY KEY ,description TEXT,date TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE  IF EXISTS taskapp");

    }

    public void insert(TaskDto t) {
        db = this.getReadableDatabase();
        db.execSQL("INSERT INTO taskapp (description,date) VALUES('" + t.getDescription() + "','" + t.getDate() + "')");
        db.close();
        Log.d(Helpers.TAG, "Inserted values");
    }

    public int getCount() {
        db = this.getReadableDatabase();
        int count = (int) DatabaseUtils.queryNumEntries(db, "taskApp");
        db.close();
        return count;
    }

    public void deleteAll() {
        db = this.getWritableDatabase();
        db.execSQL("DELETE FROM taskapp");
        db.close();
    }

    public void deleteSingle(TaskDto t) {
        try {

            db = this.getWritableDatabase();
            db.execSQL("DELETE FROM taskapp WHERE id="+t.getId());
        } catch (Exception e) {
            Log.d(Helpers.TAG, "Error during delete " + e);
        } finally {
            db.close();
        }


    }

    public ArrayList<TaskDto> getAll() {
        ArrayList<TaskDto> result = new ArrayList<>();
        db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM " + nameOfDb + " ORDER BY ID", null);


        cursor.moveToFirst();
         while (!cursor.isAfterLast()) {
            try {
                int id = cursor.getInt((int) cursor.getColumnIndex("id"));

                String description = cursor.getString(cursor.getColumnIndexOrThrow("description"));
                String date = cursor.getString(cursor.getColumnIndexOrThrow("date"));

                result.add(new TaskDto(id,description, date));
                cursor.moveToNext();

            } catch (Exception e) {
                Log.d(Helpers.TAG, "Error while serializing objects " + e);
            } finally {
                db.close();
            }
            }

        return result;
        }


    }


