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
import com.example.dryulia.mainscreen.home.konsultasi.kondisiUmum.KondisiUmumFragment;
import com.shuhart.stepview.StepView;

import java.util.ArrayList;
import java.util.Calendar;

public class KonsultasiFragment extends Fragment {
    //Pilih Layanan Fragment
    private String sKeluhan, sAreaKeluhan, sLamaKeluhan, sRiwayatCream, sRiwayatPerawatan, sTanggalKonsultasi;
    private Calendar sCalendar;

    public Calendar getsCalendar() {
        return sCalendar;
    }

    public void setsCalendar(Calendar sCalendar) {
        this.sCalendar = sCalendar;
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
        instance = this;
        initStepList();
        stepView = view.findViewById(R.id.step_view);
        stepView.setSteps(stepList);
        Fragment pilihlayananFragment = new PilihLayananFragment();
        FragmentTransaction transaction = getChildFragmentManager().beginTransaction();
        transaction.replace(R.id.content_konsultasi, pilihlayananFragment).commit();
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
            Fragment pilihlayananFragment = new PilihLayananFragment();
            transaction.replace(R.id.content_konsultasi, pilihlayananFragment).commit();
        }else if(step == 1){
            Fragment kondisiUmumFragment = new KondisiUmumFragment();
            transaction.replace(R.id.content_konsultasi, kondisiUmumFragment).commit();
        }else if(step == 2){
            Fragment bookingFragment = new BookingFragment();
            transaction.replace(R.id.content_konsultasi, bookingFragment).commit();
        }else if(step == 3){
            Fragment antrianFragment = new AntrianFragment();
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

    public String getsKeluhan() {
        return sKeluhan;
    }

    public void setsKeluhan(String sKeluhan) {
        this.sKeluhan = sKeluhan;
    }

    public String getsAreaKeluhan() {
        return sAreaKeluhan;
    }

    public void setsAreaKeluhan(String sAreaKeluhan) {
        this.sAreaKeluhan = sAreaKeluhan;
    }

    public String getsLamaKeluhan() {
        return sLamaKeluhan;
    }

    public void setsLamaKeluhan(String sLamaKeluhan) {
        this.sLamaKeluhan = sLamaKeluhan;
    }

    public String getsRiwayatCream() {
        return sRiwayatCream;
    }

    public void setsRiwayatCream(String sRiwayatCream) {
        this.sRiwayatCream = sRiwayatCream;
    }

    public String getsRiwayatPerawatan() {
        return sRiwayatPerawatan;
    }

    public void setsRiwayatPerawatan(String sRiwayatPerawatan) {
        this.sRiwayatPerawatan = sRiwayatPerawatan;
    }

    public String getsTanggalKonsultasi() {
        return sTanggalKonsultasi;
    }

    public void setsTanggalKonsultasi(String sTanggalKonsultasi) {
        this.sTanggalKonsultasi = sTanggalKonsultasi;
    }
}
