package com.wikilift.uf1_practico.ui.landingLayout;

import android.content.Context;
import android.os.Build;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;

import android.util.Log;
import android.view.View;

import com.wikilift.uf1_practico.MainActivity;
import com.wikilift.uf1_practico.R;
import com.wikilift.uf1_practico.core.helpers.Helpers;
import com.wikilift.uf1_practico.data.local.DatabaseApp;
import com.wikilift.uf1_practico.data.model.TaskDto;
import com.wikilift.uf1_practico.databinding.FragmentLandingLayoutBinding;
import com.wikilift.uf1_practico.domain.TaskRepo;
import com.wikilift.uf1_practico.domain.TaskRepoImpl;
import com.wikilift.uf1_practico.presentation.TaskViewModel;
import com.wikilift.uf1_practico.presentation.TaskViewModelFactory;
import com.wikilift.uf1_practico.ui.landingLayout.adapter.ListAdapter;



import java.util.ArrayList;


public class LandingLayout extends Fragment {

    private FragmentLandingLayoutBinding binding;

    private TaskViewModel viewModel;
    private ArrayList<TaskDto> taskList;
    private ListAdapter adapter;

    public LandingLayout() {

        super(R.layout.fragment_landing_layout);
    }


    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        binding=FragmentLandingLayoutBinding.bind(view);
        MainActivity.toolbar.setVisibility(View.VISIBLE);

        //inject dependencies
        viewModel = new ViewModelProvider(
                this,
                new TaskViewModelFactory(
                        this.requireActivity()
                                .getApplication() ,
                        new TaskRepoImpl(
                                MainActivity.masterDB)
                )
        ).get(TaskViewModel.class);


        fillRecycler();
        setAdapter();
        listeners();


    }

    private void listeners() {
        binding.buttonCreate.setOnClickListener(e->{
            Navigation.findNavController(requireView()).navigate(R.id.action_landingLayout_to_createNewNote);
        });

    }

    private void fillRecycler() {
        taskList=viewModel.getAll();
    }

    private void setAdapter() {
        adapter= new ListAdapter(requireContext(),taskList);
        binding.rvTasks.setAdapter(adapter);
        if(taskList.size()>0)Helpers.show(binding.rvTasks);


    }




}