package com.example.dryulia.mainscreen.home.treatment;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.dryulia.R;
import com.example.dryulia.mainscreen.MainScreenActivity;
import com.example.dryulia.mainscreen.home.produk.ProdukAdapter;
import com.example.dryulia.mainscreen.home.produk.ProdukModel;

import java.util.ArrayList;

public class TreatmentAdapter extends RecyclerView.Adapter<TreatmentAdapter.TreatmentItemViewHolder>{
    private Context context;
    private ArrayList<TreatmentModel> treatmentModelArrayList;
    private View view;


    public TreatmentAdapter(Context context) {
        this.context = context;
    }

   /* public TreatmentAdapter(ArrayList<TreatmentModel> treatmentModelArrayList) {
        this.treatmentModelArrayList = treatmentModelArrayList;
    }*/

    public TreatmentAdapter(ArrayList<TreatmentModel> treatmentModelArrayList, int item_treatment, FragmentActivity activity) {
        this.context = context;
        this.treatmentModelArrayList = treatmentModelArrayList;
        this.view = view;
    }

    @NonNull
    @Override
    public TreatmentItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_treatment, parent, false);

        return new TreatmentAdapter.TreatmentItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final TreatmentItemViewHolder treatmentItemViewHolder, int position) {
        final TreatmentModel treatmentModel = treatmentModelArrayList.get(position);
        Glide.with(MainScreenActivity.getInstance())
                .load(treatmentModel.getImage_url())
                .apply(new RequestOptions().override(300, 200))
                .into(treatmentItemViewHolder.imgPhoto);
        final boolean[] showFirst = new boolean[1];
        treatmentItemViewHolder.judulTreatment.setText(treatmentModel.getNamaTreatment());
        treatmentItemViewHolder.detailTreatment.setText(treatmentModel.getDetailTreatment());
        treatmentItemViewHolder.hargaTreatment.setText(String.valueOf(treatmentModel.getHargaTreatment()));
        treatmentItemViewHolder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("posisi", treatmentModel.getIndex()+"" );
                if (showFirst[0] == false){
                    treatmentItemViewHolder.imgStatus.setImageResource(R.drawable.ic_treatment_true);
                    showFirst[0] = true;
                }else{
                    treatmentItemViewHolder.imgStatus.setImageResource(R.drawable.ic_treatment_false);
                    showFirst[0] = false;
                }

            }
        });
    }

    @Override
    public int getItemCount() {
        return treatmentModelArrayList.size();
    }

    public class TreatmentItemViewHolder extends RecyclerView.ViewHolder {
        ImageView imgPhoto, imgStatus;
        TextView judulTreatment, detailTreatment, hargaTreatment;
        CardView cardView;
        public TreatmentItemViewHolder(@NonNull View itemView) {
            super(itemView);
            imgPhoto = itemView.findViewById(R.id.iv_treatment);
            judulTreatment = itemView.findViewById(R.id.tv_treatment_judul);
            detailTreatment = itemView.findViewById(R.id.tv_treatment_keterangan);
            hargaTreatment = itemView.findViewById(R.id.tv_harga_treatment);
            imgStatus = itemView.findViewById(R.id.iv_treatment_status);
            cardView = itemView.findViewById(R.id.cv_treatment);
        }
    }
}
