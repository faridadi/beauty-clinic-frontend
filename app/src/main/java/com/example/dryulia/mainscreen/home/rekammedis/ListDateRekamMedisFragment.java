package com.example.dryulia.mainscreen.home.rekammedis;

import android.annotation.SuppressLint;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.dryulia.R;
import com.example.dryulia.mainscreen.home.treatment.TreatmentAdapter;
import com.example.dryulia.mainscreen.home.treatment.TreatmentData;
import com.example.dryulia.mainscreen.home.treatment.TreatmentModel;

import java.util.ArrayList;


public class ListDateRekamMedisFragment extends Fragment {
    private RecyclerView listDateRecyclerView;
    //private RecyclerView.Adapter produkAdapter;
    private ListDateRekamMedisAdapter adapter;
    private ArrayList<ListDateRekamMedisModel> treatments = new ArrayList<>();
    private View view;



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return view =  inflater.inflate(R.layout.fragment_list_date_rekam_medis, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        listDateRecyclerView = view.findViewById(R.id.rv_listdate_rekam_medis);
        listDateRecyclerView.setHasFixedSize(true);
        treatments.addAll(ListDateRekamMedisData.getListData());
        listDateRecyclerView.setLayoutManager(new LinearLayoutManager(
                getActivity()
        ));
        // Log.d("produk", products.toString());
        adapter = new ListDateRekamMedisAdapter(treatments, R.layout.item_list_date_rekam_medis, getActivity());
        listDateRecyclerView.setAdapter(adapter);

    }
}
