package com.example.dryulia.mainscreen.home.produk;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.dryulia.R;
import com.example.dryulia.mainscreen.MainScreenActivity;

import java.util.ArrayList;

public class ProdukAdapter extends RecyclerView.Adapter<ProdukAdapter.ProdukItemViewHolder> {
    private Context context;
    private ArrayList<ProdukModel> produkModelArrayList;
    private View view;
    private int jumlahProduk;

    static final String STATE_JUMLAH_PRODUK = "Jumlah Produk";

    public ProdukAdapter(Context context) {
        this.context = context;
    }

    public ProdukAdapter(ArrayList<ProdukModel> produkModelList, int item_produk, FragmentActivity activity) {
        this.produkModelArrayList = produkModelList;
    }

    @NonNull
    @Override
    public ProdukItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_produk, parent, false);

        return new ProdukItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ProdukItemViewHolder produkItemViewHolder, int position) {
        final ProdukModel produkModel = produkModelArrayList.get(position);
        Glide.with(MainScreenActivity.getInstance())
                .load(produkModel.getImage_url())
                .apply(new RequestOptions().override(300, 200))
                .into(produkItemViewHolder.imgPhoto);

        produkItemViewHolder.judulProduk.setText(produkModel.getNamaProduk());
        produkItemViewHolder.detailProduk.setText(produkModel.getDetailProduk());
        produkItemViewHolder.hargaProduk.setText("" + produkModel.getHargaProduk());
        produkItemViewHolder.jumlahProduk.setText("" + produkModel.getJumlahOrder());

        produkItemViewHolder.icPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                jumlahProduk++;
                produkItemViewHolder.jumlahProduk.setText(String.valueOf(jumlahProduk));

            }
        });

        produkItemViewHolder.icMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                jumlahProduk--;
                if (jumlahProduk >= 1){
                    produkItemViewHolder.jumlahProduk.setText(String.valueOf(jumlahProduk));
                }else{
                    produkItemViewHolder.jumlahProduk.setText("1");
                }

            }
        });


    }

    @Override
    public int getItemCount() {
        return produkModelArrayList.size();
    }

    public class ProdukItemViewHolder extends RecyclerView.ViewHolder {
        ImageView imgPhoto, icPlus, icMinus;
        TextView judulProduk, detailProduk, hargaProduk, jumlahProduk;


        public ProdukItemViewHolder(@NonNull View itemView) {
            super(itemView);
            imgPhoto = itemView.findViewById(R.id.iv_produk);
            judulProduk = itemView.findViewById(R.id.tv_namaProduk);
            detailProduk = itemView.findViewById(R.id.tv_detailProduk);
            hargaProduk = itemView.findViewById(R.id.tv_hargaProduk);
            jumlahProduk = itemView.findViewById(R.id.tv_jumlahProduk);
            icMinus = itemView.findViewById(R.id.ic_produk_minus);
            icPlus = itemView.findViewById(R.id.ic_produk_add);
        }
    }




    }
