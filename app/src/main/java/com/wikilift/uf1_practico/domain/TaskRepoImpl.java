package com.wikilift.uf1_practico.domain;

import android.util.Log;

import com.wikilift.uf1_practico.core.helpers.Helpers;
import com.wikilift.uf1_practico.data.local.DatabaseApp;
import com.wikilift.uf1_practico.data.model.TaskDto;

import java.util.ArrayList;

public class TaskRepoImpl implements TaskRepo {

    public DatabaseApp masterDB;

    public TaskRepoImpl(DatabaseApp masterDB) {
        this.masterDB = masterDB;
    }

    @Override
    public ArrayList<TaskDto> getAll() {return masterDB.getAll();}

    @Override
    public void insert(TaskDto t) {
        masterDB.insert(t);
    }

    @Override
    public void deleteAll() {
        masterDB.deleteAll();
    }

    @Override
    public void deleteSingle(TaskDto t) {
        masterDB.deleteSingle(t);
    }
}
