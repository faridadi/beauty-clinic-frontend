package com.example.dryulia.mainscreen.home.produk;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.dryulia.R;
import com.example.dryulia.mainscreen.MainScreenActivity;

import java.util.ArrayList;


public class ProdukFragment extends Fragment {

    //product
    private RecyclerView produkRecyclerView;
    private RecyclerView.Adapter produkAdapter;
    private ArrayList<ProdukModel> products = new ArrayList<>();
    private View view;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_produk, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        this.initProduct();
        produkRecyclerView = view.findViewById(R.id.rv_produk);
        produkRecyclerView.setLayoutManager(new LinearLayoutManager(
                getActivity()
        ));

        produkRecyclerView.setHasFixedSize(true);
        produkAdapter = new ProdukAdapter(products);
        produkRecyclerView.setAdapter(produkAdapter);
    }

    private void initProduct(){
        products.add(new ProdukModel());
        products.add(new ProdukModel());
        products.add(new ProdukModel());
        products.add(new ProdukModel());
        products.add(new ProdukModel());
        products.add(new ProdukModel());
        products.add(new ProdukModel());
        products.add(new ProdukModel());
        products.add(new ProdukModel());
        products.add(new ProdukModel());

    }

}
