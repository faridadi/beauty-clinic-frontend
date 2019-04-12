package com.example.dryulia.mainscreen.home.produk;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.dryulia.R;

import java.util.ArrayList;

public class ProdukAdapter extends RecyclerView.Adapter<ProdukAdapter.ProdukItemViewHolder> {
    private ArrayList<ProdukModel> produkModelArrayList;
    private View view;

    public ProdukAdapter(ArrayList<ProdukModel> produkModel) {
        this.produkModelArrayList = produkModel;
    }

    @NonNull
    @Override
    public ProdukItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_produk,parent,false);

        return new ProdukItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ProdukItemViewHolder holder, int position) {
        ProdukModel produkModel = produkModelArrayList.get(position);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Ubah warna dan tambahkan produk yang dipilih ke DB

            }
        });
    }

    @Override
    public int getItemCount() {
        return produkModelArrayList.size();
    }

    public class ProdukItemViewHolder extends RecyclerView.ViewHolder {
        public final View view;

        public ProdukItemViewHolder(@NonNull View view) {
            super(view);
            this.view = view;
        }
    }
}
