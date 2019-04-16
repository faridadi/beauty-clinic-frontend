package com.example.dryulia.mainscreen.home.produk;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.dryulia.R;
import com.example.dryulia.mainscreen.MainScreenActivity;

import java.util.ArrayList;


public class ProdukFragment extends Fragment {

    //product
    private RecyclerView produkRecyclerView;
    //private RecyclerView.Adapter produkAdapter;
    private ProdukAdapter adapter;
    private ArrayList<ProdukModel> products = new ArrayList<>();
    private View view;
    private ImageView image;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return view = inflater.inflate(R.layout.fragment_produk, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        produkRecyclerView = view.findViewById(R.id.rv_produk);
        image = view.findViewById(R.id.aaa);
        produkRecyclerView.setHasFixedSize(true);
        products.addAll(ProdukData.getListData());
        produkRecyclerView.setLayoutManager(new LinearLayoutManager(
                getActivity()
        ));
        Log.d("produk", products.toString());
        adapter = new ProdukAdapter(products, R.layout.item_produk, getActivity());
        produkRecyclerView.setAdapter(adapter);
        image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainScreenActivity.getInstance(), "Asiaapp", Toast.LENGTH_SHORT).show();
            }
        });



    }


}
























