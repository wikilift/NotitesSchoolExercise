package com.wikilift.uf1_practico.data.model;


import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;


public class TaskDto implements Serializable {

    private int id;

    private String description;

    private String date;


    public TaskDto(String description) {
        this.description = description;
        Locale locale= new Locale("es","ES");
        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yy",locale);
        date = sdf.format(new Date());
    }
    public TaskDto(int id,String description,String date) {
        this.description = description;
        this.date=date;
        this.id=id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }


}
