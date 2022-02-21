package com.wikilift.uf1_practico.presentation;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.wikilift.uf1_practico.domain.TaskRepo;
import com.wikilift.uf1_practico.domain.TaskRepoImpl;


public class TaskViewModelFactory implements ViewModelProvider.Factory {
    private Application mApplication;
    private  TaskRepo taskRepo;


    public TaskViewModelFactory(Application application,TaskRepo param) {
        mApplication = application;
        taskRepo = param;
    }


    @Override
    public <T extends ViewModel> T create(Class<T> modelClass) {
        return (T) new TaskViewModel(mApplication, taskRepo);
    }
}
