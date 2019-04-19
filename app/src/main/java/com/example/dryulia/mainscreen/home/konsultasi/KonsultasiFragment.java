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
import com.example.dryulia.model.Konsul;
import com.shuhart.stepview.StepView;

import java.util.ArrayList;
import java.util.Calendar;

public class KonsultasiFragment extends Fragment {
    //Pilih Layanan Fragment
    private String sKeluhan, sAreaKeluhan, sLamaKeluhan, sRiwayatCream, sRiwayatPerawatan, sTanggalKonsultasi, depan, kiri, kanan, barcode;
    private Calendar sCalendar;
    private Konsul konsul;

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

    private Fragment pilihlayananFragment;
    private Fragment kondisiUmumFragment;
    private Fragment bookingFragment;
    private Fragment antrianFragment;

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
            transaction.replace(R.id.content_konsultasi, pilihlayananFragment).commit();
        }else if(step == 1){
            transaction.replace(R.id.content_konsultasi, kondisiUmumFragment).commit();
        }else if(step == 2){
            transaction.replace(R.id.content_konsultasi, bookingFragment).commit();
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

    public void setsDepan(String depan) {
        this.depan = depan;
    }

    public String getsDepan() {
        return depan;
    }

    public void setsKiri(String kiri) {
        this.kiri = kiri;
    }

    public String getsKiri() {
        return kiri;
    }
    public void setsKanan(String kanan) {
        this.kanan = kanan;
    }

    public String getsKanan() {
        return kanan;
    }

    public String getsBarcode() {
        return barcode;
    }

    public void setsBarcode(String barcode) {
        this.barcode = barcode;
    }
    public Konsul getsKonsul() {
        return konsul;
    }

    public void setsKonsul(Konsul konsul) {
        this.konsul = konsul;
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
