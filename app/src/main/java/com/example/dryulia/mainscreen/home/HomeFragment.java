package com.example.dryulia.mainscreen.home;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.dryulia.R;
import com.example.dryulia.mainscreen.MainScreenActivity;
import com.example.dryulia.mainscreen.home.konsultasi.KonsultasiFragment;
import com.example.dryulia.mainscreen.home.produk.ProdukFragment;
import com.example.dryulia.mainscreen.home.treatment.TreatmentFragment;


public class HomeFragment extends Fragment {

        private View view;
        CardView cvKonsultasi, cvTreatment, cvProduk, cvMedicalAdvice,cvBill, cvRekamMedis;
    private android.app.Fragment selectedFragment;
    private static MainScreenActivity mainScreenActivity;
    public static int selectedMenuId;





    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_home, container, false);
        cvKonsultasi = view.findViewById(R.id.cv_konsultasi);
        cvTreatment = view.findViewById(R.id.cv_treatment);
        cvProduk = view.findViewById(R.id.cv_produk);
        cvMedicalAdvice = view.findViewById(R.id.cv_medical_advice);
        cvBill = view.findViewById(R.id.cv_bill);
        cvRekamMedis = view.findViewById(R.id.cv_rekamMedis);



        cvKonsultasi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), "Anda Memilih Konsultasi", Toast.LENGTH_SHORT).show();

                /*MainScreenActivity.getInstance().setPage(0);

                FragmentTransaction fr = getFragmentManager().beginTransaction();
                fr.replace(R.id.con, new PilihLayananFragment());
                fr.commit();*/

                Fragment konsultasiFragment = new KonsultasiFragment();
                FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.content, konsultasiFragment).commit();


            }
        });

        cvTreatment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), "Anda Memilih Treatment", Toast.LENGTH_SHORT).show();

                Fragment treatmentFragment = new TreatmentFragment();
                FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.content, treatmentFragment).commit();
            }
        });

        cvProduk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), "Anda Memilih Produk", Toast.LENGTH_SHORT).show();
                Fragment produkFragment = new ProdukFragment();
                FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.content, produkFragment).commit();
            }
        });

        cvMedicalAdvice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), "Anda Memilih Medical Advice", Toast.LENGTH_SHORT).show();
            }
        });

        cvBill.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), "Anda Memilih Bill", Toast.LENGTH_SHORT).show();
            }
        });

        cvRekamMedis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), "Anda Memilih Rekam Medis ", Toast.LENGTH_SHORT).show();
            }
        });



        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        

        
        


        }

    }

