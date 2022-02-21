package com.wikilift.uf1_practico.domain;

import androidx.lifecycle.LiveData;

import com.wikilift.uf1_practico.data.model.TaskDto;

import java.util.ArrayList;

public interface TaskRepo {
    ArrayList<TaskDto>getAll();
     void insert(TaskDto t);
     void deleteAll();
     void deleteSingle(TaskDto t);
}
