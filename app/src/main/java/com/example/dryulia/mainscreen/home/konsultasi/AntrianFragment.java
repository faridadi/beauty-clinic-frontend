package com.example.dryulia.mainscreen.home.konsultasi;

import android.app.Dialog;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.dryulia.R;
import com.example.dryulia.database.DatabaseHelper;
import com.example.dryulia.model.Antri;


public class AntrianFragment extends Fragment {
    CardView anamnesa, kondisiUmum;
    TextView status, antrian;
    DatabaseHelper db;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {

        }

        }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_antrian, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        anamnesa = view.findViewById(R.id.cv_antrian_anamnesa);
        kondisiUmum = view.findViewById(R.id.cv_antrian_kondisi_umum);
        antrian = view.findViewById(R.id.antrian_digit);
        status = view.findViewById(R.id.booking_status_code);
        db = new DatabaseHelper(getActivity());
        if (db.cekAntri()){
            Antri antri =  db.getAntri();
            status.setText(antri.getStatus());
            antrian.setText(antri.getQuee_text());
            anamnesa.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    showDialogAnamnes();
                }
            });
            kondisiUmum.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    showDialogAKondisiUmum();
                }
            });
        }else{

        }
    }

    private void showDialogAnamnes() {
        final Dialog dialog = new Dialog(getActivity());
        dialog.setCancelable(true);
        View view  = getActivity().getLayoutInflater().inflate(R.layout.popup_anamnesa, null);
        dialog.setContentView(view);
        final ImageView exit = view.findViewById(R.id.img_popup_anamnesa_exit);
        exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });
        dialog.show();
    }

    private void showDialogAKondisiUmum() {
        final Dialog dialog = new Dialog(getActivity());
        dialog.setCancelable(true);

        View view  = getActivity().getLayoutInflater().inflate(R.layout.popup_kondisi_umum, null);
        dialog.setContentView(view);

        final ImageView exit = view.findViewById(R.id.img_popup_kondisiumum_exit);

        exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });
        dialog.show();
    }

    @Override
    public void onStart() {
        super.onStart();
    }

    @Override
    public void onResume() {
        super.onResume();
    }
}

