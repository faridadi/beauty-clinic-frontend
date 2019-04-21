package com.example.dryulia.mainscreen.home.konsultasi;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.dryulia.R;
import com.example.dryulia.database.DatabaseHelper;
import com.example.dryulia.mainscreen.home.konsultasi.kondisiUmum.KondisiUmumFragment;
import com.example.dryulia.model.Konsul;
import com.shuhart.stepview.StepView;

import java.util.ArrayList;
import java.util.Calendar;

public class KonsultasiFragment extends Fragment {
    //Pilih Layanan Fragment
    //private String sKeluhan, sAreaKeluhan, sLamaKeluhan, sRiwayatCream, sRiwayatPerawatan, sTanggalKonsultasi, depan, kiri, kanan, barcode;

    private Konsul konsul = new Konsul();
    public Konsul getsKonsul() {
        return konsul;
    }
    public void setsKonsul(Konsul konsul) {
        this.konsul = konsul;
    }
    private StepView stepView;
    private ArrayList<String> stepList = new ArrayList<>();
    public StepView getStepView() {
        return stepView;
    }

    private static KonsultasiFragment instance;
    public static KonsultasiFragment getInstance(){
        return instance;
    }

    private Fragment pilihlayananFragment;
    private Fragment kondisiUmumFragment;
    private Fragment bookingFragment;
    private Fragment antrianFragment;
    private DatabaseHelper db;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_konsultasi, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        pilihlayananFragment = new PilihLayananFragment();
        kondisiUmumFragment = new KondisiUmumFragment();
        bookingFragment = new BookingFragment();
        antrianFragment = new AntrianFragment();
        instance = this;
        initStepList();
        stepView = view.findViewById(R.id.step_view);
        stepView.setSteps(stepList);
        //Fragment pilihlayananFragment = new PilihLayananFragment();
        db = new DatabaseHelper(getContext());
        FragmentTransaction transaction = getChildFragmentManager().beginTransaction();
        //cek apakah sudah konsult apa belum
        if (db.cekAntri()){
            setStep(3);
            return;
        }
        if (db.cekKonsul()){
            setStep(2);
            return;
        }else {
            transaction.replace(R.id.content_konsultasi, pilihlayananFragment).commit();
        }
        stepView.setOnStepClickListener(new StepView.OnStepClickListener() {
            @Override
            public void onStepClick(int step) {
                setStep(step);
            }
        });
    }

    public void setStep(int step){
        Log.d("step", step  + "");
        FragmentTransaction transaction = getChildFragmentManager().beginTransaction();
        if (step == 0){
            transaction.replace(R.id.content_konsultasi, pilihlayananFragment,"layanan").addToBackStack("layanan").commit();
        }else if(step == 1){
            transaction.replace(R.id.content_konsultasi, kondisiUmumFragment, "kondisi").addToBackStack("kondisi").commit();
        }else if(step == 2){
            transaction.replace(R.id.content_konsultasi, bookingFragment, "booking").commit();
        }else if(step == 3){
            transaction.replace(R.id.content_konsultasi, antrianFragment).commit();
        }
        stepView.go(step, true);
    }

    public void initStepList(){
        stepList.add("Pilih Layanan");
        stepList.add("Kondisi Umum");
        stepList.add("Booking");
        stepList.add("Antrean");
    }
    @Override
    public void onResume() {
        super.onResume();
    }

    @Override
    public void onStart() {
        super.onStart();
    }
}
