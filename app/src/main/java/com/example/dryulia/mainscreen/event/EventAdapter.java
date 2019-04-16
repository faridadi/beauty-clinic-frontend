package com.example.dryulia.mainscreen.event;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import com.example.dryulia.mainscreen.home.treatment.TreatmentAdapter;
import com.example.dryulia.mainscreen.home.treatment.TreatmentModel;

import java.util.ArrayList;

public class EventAdapter extends RecyclerView.Adapter<EventAdapter.EventItemViewHolder> {
    private Context context;
    private ArrayList<TreatmentModel> treatmentModelArrayList;
    private View view;



    @NonNull
    @Override
    public EventItemViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull EventItemViewHolder eventItemViewHolder, int i) {

    }


    @Override
    public int getItemCount() {
        return 0;
    }

    public class EventItemViewHolder extends RecyclerView.ViewHolder {
        public EventItemViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
