package com.wikilift.uf1_practico.ui.createNewNote;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;

import android.os.Handler;
import android.view.View;

import com.wikilift.uf1_practico.MainActivity;
import com.wikilift.uf1_practico.R;
import com.wikilift.uf1_practico.core.helpers.Helpers;
import com.wikilift.uf1_practico.data.model.TaskDto;
import com.wikilift.uf1_practico.databinding.FragmentCreateNewNoteBinding;
import com.wikilift.uf1_practico.domain.TaskRepoImpl;
import com.wikilift.uf1_practico.presentation.TaskViewModel;
import com.wikilift.uf1_practico.presentation.TaskViewModelFactory;


public class CreateNewNote extends Fragment {

    private FragmentCreateNewNoteBinding binding;
    private TaskViewModel viewModel;

    public CreateNewNote() {
        super(R.layout.fragment_create_new_note);

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        binding = FragmentCreateNewNoteBinding.bind(view);

        //dependency inject
        viewModel = new ViewModelProvider(
                this,
                new TaskViewModelFactory(
                        this.requireActivity()
                                .getApplication(),
                        new TaskRepoImpl(
                                MainActivity.masterDB)
                )
        ).get(TaskViewModel.class);
        setListeners();
    }

    private void setListeners() {

        binding.buttonBack.setOnClickListener(e -> {
            Navigation.findNavController(e).navigate(R.id.action_createNewNote_to_landingLayout);


        });

        binding.buttonCreate.setOnClickListener(e -> {
            if (binding.input.getText().toString().isEmpty()) {
                Helpers.makeSnack(binding.input, getResources().getString(R.string.alert),requireContext());
            } else {
                viewModel.insert(new TaskDto(binding.input.getText().toString()));

                Navigation.findNavController(e).navigate(R.id.action_createNewNote_to_landingLayout);
                Helpers.makeSnack(binding.input, getResources().getString(R.string.addedDone),requireContext());
            }
        });

    }
}