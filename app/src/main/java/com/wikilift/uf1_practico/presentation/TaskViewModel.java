package com.wikilift.uf1_practico.presentation;

import android.app.Application;
import android.content.Context;

import androidx.annotation.NonNull;
import androidx.arch.core.util.Function;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Transformations;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.wikilift.uf1_practico.data.model.TaskDto;
import com.wikilift.uf1_practico.domain.TaskRepo;

import java.util.ArrayList;
import java.util.List;

public class TaskViewModel extends ViewModel {
    private final TaskRepo taskRepo;
    private LiveData<TaskDto> liveData;

   public TaskViewModel(Application context,TaskRepo repo){
       taskRepo = repo;
   }


   public ArrayList<TaskDto>getAll(){return taskRepo.getAll();}

    public void insert(TaskDto t){
       taskRepo.insert(t);
    }
    public void deleteAll(){
       taskRepo.deleteAll();
    }
    public void deleteSingle(TaskDto t){
       taskRepo.deleteSingle(t);
    }

}

