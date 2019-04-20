package com.example.dryulia.mainscreen.home.konsultasi;

import android.app.DatePickerDialog;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.dryulia.R;
import com.example.dryulia.model.Konsul;

import java.util.Calendar;

public class PilihLayananFragment extends Fragment {

    EditText edtKeluhan, edtAreaKeluhan, edtLamaKeluhan, edtRiwayatCream, edtRiwayatPerawatan;
    private View view;
    private Button btnSimpan;
    private ImageView imgTanggal;
    private TextView tvTanggal;
    Calendar c;
    DatePickerDialog dpd;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Log.i("makan","makan");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_pilih_layanan, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {

        btnSimpan = view.findViewById(R.id.btn_simpan_pilihLayanan);
        edtKeluhan = view.findViewById(R.id.edt_keluhan);
        edtAreaKeluhan = view.findViewById(R.id.edt_area_keluhan);
        edtLamaKeluhan = view.findViewById(R.id.edt_lama_keluhan);
        edtRiwayatCream = view.findViewById(R.id.edt_riwayat_cream);
        edtRiwayatPerawatan = view.findViewById(R.id.edt_riwayat_perawatan);
        btnSimpan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                KonsultasiFragment.getInstance().getsKonsul().setKeluhan(edtKeluhan.getText().toString());
                KonsultasiFragment.getInstance().getsKonsul().setArea(edtAreaKeluhan.getText().toString());
                KonsultasiFragment.getInstance().getsKonsul().setLama(edtLamaKeluhan.getText().toString());
                KonsultasiFragment.getInstance().getsKonsul().setRiwayatobat(edtRiwayatCream.getText().toString());
                KonsultasiFragment.getInstance().getsKonsul().setRiwayatPerawatan(edtRiwayatPerawatan.getText().toString());
                KonsultasiFragment.getInstance().getsKonsul().setDate("tanggal");
                //set data intance untuk interface data antar fragment konusltasi
                KonsultasiFragment.getInstance().setStep(1);
            }
        });
        imgTanggal = view.findViewById(R.id.ic_calendar);
        tvTanggal = view.findViewById(R.id.tv_tanggal_konsultasi);

        imgTanggal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                c = Calendar.getInstance();
                int day = c.get(Calendar.DAY_OF_MONTH);
                int month = c.get(Calendar.MONTH);
                int year = c.get(Calendar.YEAR);

                dpd = new DatePickerDialog(getActivity(), new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int mYear, int mMonth, int mDay) {
                        tvTanggal.setText(mDay + "/"+(mMonth+1)+"/"+mYear);
                    }
                },day, month, year);
                dpd.show();
            }
        });
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
