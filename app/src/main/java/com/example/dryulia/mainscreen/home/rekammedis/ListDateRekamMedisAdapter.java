package com.example.dryulia.mainscreen.home.rekammedis;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.dryulia.R;
import com.example.dryulia.mainscreen.home.treatment.TreatmentAdapter;
import com.example.dryulia.mainscreen.home.treatment.TreatmentModel;

import java.util.ArrayList;

public class ListDateRekamMedisAdapter extends RecyclerView.Adapter<ListDateRekamMedisAdapter.ListDateItemViewHolder> {
    private Context context;
    private ArrayList<ListDateRekamMedisModel> listDateRekamMedisModels;
    private View view;


    public ListDateRekamMedisAdapter(ArrayList<ListDateRekamMedisModel> listDateRekamMedisModels, int item_listDate, FragmentActivity activity) {
        this.context = context;
        this.listDateRekamMedisModels = listDateRekamMedisModels;
        this.view = view;
    }

    @NonNull
    @Override
    public ListDateItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list_date_rekam_medis, parent, false);
        return new ListDateRekamMedisAdapter.ListDateItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ListDateItemViewHolder listDateItemViewHolder, int position) {
        final ListDateRekamMedisModel listDateRekamMedisModel = listDateRekamMedisModels.get(position);
        listDateItemViewHolder.tvDate.setText(listDateRekamMedisModel.getTanggal());
    }

    @Override
    public int getItemCount() {
        return listDateRekamMedisModels.size();
    }

    public class ListDateItemViewHolder extends RecyclerView.ViewHolder {
        TextView tvDate;
        public ListDateItemViewHolder(@NonNull View itemView) {
            super(itemView);
            tvDate = itemView.findViewById(R.id.tv_tanggal_rekam_medis);
        }
    }
}
