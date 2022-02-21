package com.wikilift.uf1_practico.ui.landingLayout.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import com.wikilift.uf1_practico.R;
import com.wikilift.uf1_practico.data.model.TaskDto;
import com.wikilift.uf1_practico.databinding.TaskItemRowBinding;
import com.wikilift.uf1_practico.ui.landingLayout.LandingLayoutDirections;
import com.wikilift.uf1_practico.ui.sheetDetails.SheetDetails;
import com.wikilift.uf1_practico.ui.sheetDetails.SheetDetailsArgs;
import com.wikilift.uf1_practico.ui.sheetDetails.SheetDetailsDirections;

import java.util.ArrayList;

public class ListAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> implements View.OnClickListener {
    private final Context context;
    private  final ArrayList<TaskDto> list;



    public ListAdapter(Context context, ArrayList<TaskDto> list) {
        this.context = context;
        this.list = list;
    }



    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        return new ViewHolder(LayoutInflater.from(context).inflate(R.layout.task_item_row, parent, false), viewType);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ((ViewHolder) holder).bind(position);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    @Override
    public void onClick(View v) {

    }


    public  class ViewHolder extends RecyclerView.ViewHolder  {


        private final TaskItemRowBinding binding;

        public ViewHolder(final View itemView, int position) {
            super(itemView);

            binding = TaskItemRowBinding.bind(itemView);

        }

        void bind(int position) {
            binding.taskLayout.setOnClickListener(e->{
                TaskDto travelDto=list.get(position);
                 LandingLayoutDirections.ActionLandingLayoutToSheetDetails z= LandingLayoutDirections.actionLandingLayoutToSheetDetails(travelDto);
                Navigation.findNavController(itemView).navigate(z);
            });
            binding.taskName.setText(list.get(position).getDescription());
            binding.date.setText(list.get(position).getDate());
        }


    }



}