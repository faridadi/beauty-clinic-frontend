package com.example.dryulia.mainscreen.home.konsultasi.kondisiUmum;

import android.content.Context;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.dryulia.R;
import com.example.dryulia.mainscreen.home.konsultasi.KonsultasiFragment;

public class KondisiUmumFragment extends Fragment {

    private View view;
    Button btnSimpan;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_kondisi_umum, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        btnSimpan = view.findViewById(R.id.btn_simpan_kondisiUmum);

        btnSimpan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                KonsultasiFragment.getInstance().setStep(2);
            }
        });

    }
    //check the device has camera
    private boolean checkCameraHardware(Context context){
        if(context.getPackageManager().hasSystemFeature(PackageManager.FEATURE_CAMERA)){
            //the device has camera
            return true;
        }else {
            return false;
        }
    }
}