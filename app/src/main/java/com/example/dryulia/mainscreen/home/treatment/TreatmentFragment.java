package com.example.dryulia.mainscreen.home.treatment;

import android.content.Context;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

import com.example.dryulia.R;
import com.example.dryulia.mainscreen.MainScreenActivity;
import com.example.dryulia.mainscreen.home.produk.ProdukAdapter;
import com.example.dryulia.mainscreen.home.produk.ProdukData;
import com.example.dryulia.mainscreen.home.produk.ProdukModel;

import java.util.ArrayList;


public class TreatmentFragment extends Fragment {
    //product
    private RecyclerView treatmentRecyclerView;
    //private RecyclerView.Adapter produkAdapter;
    private TreatmentAdapter adapter;
    private ArrayList<TreatmentModel> treatments = new ArrayList<>();
    private View view;



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return view = inflater.inflate(R.layout.fragment_treatment, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        treatmentRecyclerView = view.findViewById(R.id.rv_treatment);
        treatmentRecyclerView.setHasFixedSize(true);
        treatments.addAll(TreatmentData.getListData());
        treatmentRecyclerView.setLayoutManager(new LinearLayoutManager(
                getActivity()
        ));
       // Log.d("produk", products.toString());
        adapter = new TreatmentAdapter(treatments, R.layout.item_treatment, getActivity());
        treatmentRecyclerView.setAdapter(adapter);


    }
}
