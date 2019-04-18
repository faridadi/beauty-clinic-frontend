package com.example.dryulia.mainscreen.home;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.dryulia.R;
import com.example.dryulia.mainscreen.MainScreenActivity;
import com.example.dryulia.mainscreen.home.konsultasi.KonsultasiFragment;
import com.example.dryulia.mainscreen.home.produk.ProdukFragment;
import com.example.dryulia.mainscreen.home.treatment.TreatmentFragment;
import com.synnapps.carouselview.CarouselView;
import com.synnapps.carouselview.ImageListener;


public class HomeFragment extends Fragment {

    CarouselView carouselView;

    private View view;
    CardView cvKonsultasi, cvTreatment, cvProduk, cvMedicalAdvice,cvBill, cvRekamMedis;
    private android.app.Fragment selectedFragment;
    private static MainScreenActivity mainScreenActivity;
    public static int selectedMenuId;
    private Fragment konsultasiFragment;
    private Fragment treatmentFragment;
    private Fragment produkFragment;


    public HomeFragment() {

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final int[] sampleImages = {R.drawable.img_promo, R.drawable.img_diskon_1, R.drawable.img_diskon_2, R.drawable.img_diskon_3};

        view = inflater.inflate(R.layout.fragment_home, container, false);

        carouselView = view.findViewById(R.id.carouselView);
        carouselView.setPageCount(sampleImages.length);
        cvKonsultasi = view.findViewById(R.id.cv_konsultasi);
        cvTreatment = view.findViewById(R.id.cv_treatment);
        cvProduk = view.findViewById(R.id.cv_produk);
        cvMedicalAdvice = view.findViewById(R.id.cv_medical_advice);
        cvBill = view.findViewById(R.id.cv_bill);
        cvRekamMedis = view.findViewById(R.id.cv_rekamMedis);

        ImageListener imageListener = new ImageListener() {
            @Override
            public void setImageForPosition(int position, ImageView imageView) {
                imageView.setImageResource(sampleImages[position]);
            }
        };
        carouselView.setImageListener(imageListener);

        konsultasiFragment = new KonsultasiFragment();
        treatmentFragment = new TreatmentFragment();
        produkFragment = new ProdukFragment();

        cvKonsultasi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), "Anda Memilih Konsultasi", Toast.LENGTH_SHORT).show();
                FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.content, konsultasiFragment).commit();
            }
        });

        cvTreatment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), "Anda Memilih Treatment", Toast.LENGTH_SHORT).show();

                FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.content, treatmentFragment).commit();
            }
        });

        cvProduk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), "Anda Memilih Produk", Toast.LENGTH_SHORT).show();
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

    @Override
    public void onStart() {
        super.onStart();
    }

    @Override
    public void onResume() {
        super.onResume();
    }
}

