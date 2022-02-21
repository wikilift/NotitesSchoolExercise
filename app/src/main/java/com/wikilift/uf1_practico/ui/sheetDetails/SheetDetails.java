package com.wikilift.uf1_practico.ui.sheetDetails;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;


import android.view.View;

import com.wikilift.uf1_practico.MainActivity;
import com.wikilift.uf1_practico.R;
import com.wikilift.uf1_practico.core.helpers.Helpers;
import com.wikilift.uf1_practico.data.model.TaskDto;

import com.wikilift.uf1_practico.databinding.FragmentSheetDetailsBinding;
import com.wikilift.uf1_practico.domain.TaskRepoImpl;
import com.wikilift.uf1_practico.presentation.TaskViewModel;
import com.wikilift.uf1_practico.presentation.TaskViewModelFactory;


public class SheetDetails extends Fragment {

   private FragmentSheetDetailsBinding binding;
   private TaskDto travelDto;
   private TaskViewModel viewModel;

    public SheetDetails() {
       super(R.layout.fragment_sheet_details);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        binding= FragmentSheetDetailsBinding.bind(view);
        travelDto= SheetDetailsArgs.fromBundle(getArguments()).getTravelDto();
        //viewModel instance
        viewModel = new ViewModelProvider(
                this,
                new TaskViewModelFactory(
                        this.requireActivity()
                                .getApplication() ,
                        new TaskRepoImpl(
                                MainActivity.masterDB)
                )
        ).get(TaskViewModel.class);


        setView();
        setListeners();
    }

    private void setListeners() {
        binding.buttonDelete.setOnClickListener(e->{
            viewModel.deleteSingle(travelDto);
            Helpers.makeSnack(binding.buttonDelete,getResources().getString(R.string.singleDelete),requireContext());

            Navigation.findNavController(e).navigate(R.id.action_sheetDetails_to_landingLayout);
        });

        binding.buttonBack.setOnClickListener(e->{
            Navigation.findNavController(e).navigate(R.id.action_sheetDetails_to_landingLayout);
        });
    }

    private void setView() {
        binding.taskDate.setText(travelDto.getDate());
        binding.txtDescription.setText(travelDto.getDescription());
    }
}