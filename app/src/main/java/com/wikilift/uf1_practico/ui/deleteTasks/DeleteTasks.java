package com.wikilift.uf1_practico.ui.deleteTasks;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavOptions;
import androidx.navigation.Navigation;

import android.view.View;

import com.wikilift.uf1_practico.MainActivity;
import com.wikilift.uf1_practico.R;
import com.wikilift.uf1_practico.core.helpers.Helpers;
import com.wikilift.uf1_practico.databinding.FragmentDeleteTasksBinding;
import com.wikilift.uf1_practico.domain.TaskRepoImpl;
import com.wikilift.uf1_practico.presentation.TaskViewModel;
import com.wikilift.uf1_practico.presentation.TaskViewModelFactory;


public class DeleteTasks extends Fragment {

    private FragmentDeleteTasksBinding binding;
    private TaskViewModel viewModel;
    public DeleteTasks() {
        super(R.layout.fragment_delete_tasks);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        binding = FragmentDeleteTasksBinding.bind(view);
        //dependencies injection
        viewModel = new ViewModelProvider(
                this,
                new TaskViewModelFactory(
                        this.requireActivity()
                                .getApplication() ,
                        new TaskRepoImpl(
                                MainActivity.masterDB)
                )
        ).get(TaskViewModel.class);

        listeners();

    }

    private void listeners() {
        binding.buttonBack.setOnClickListener(e->{
            Navigation.findNavController(requireView()).navigate(R.id.action_deleteTasks_to_landingLayout);
        });
        binding.buttonDelete.setOnClickListener(e->{
            viewModel.deleteAll();
            Helpers.makeSnack(binding.buttonDelete,getResources().getString(R.string.allDeleted),requireContext());
            Navigation.findNavController(requireView()).navigate(R.id.action_deleteTasks_to_landingLayout);
        });
    }


}