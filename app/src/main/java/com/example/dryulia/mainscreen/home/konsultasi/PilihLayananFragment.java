package com.example.dryulia.mainscreen.home.konsultasi;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.dryulia.R;
import com.example.dryulia.model.Konsul;

import java.text.DateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class PilihLayananFragment extends Fragment {

    EditText edtKeluhan, edtAreaKeluhan, edtLamaKeluhan, edtRiwayatCream, edtRiwayatPerawatan;
    private View view;
    private Button btnSimpan;
    private ImageView imgTanggal;
    private TextView tvTanggal;
    Calendar c;
    DatePickerDialog dpd;
    boolean date = false;

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
        date = false;
        btnSimpan = view.findViewById(R.id.btn_simpan_pilihLayanan);
        edtKeluhan = view.findViewById(R.id.edt_keluhan);
        edtAreaKeluhan = view.findViewById(R.id.edt_area_keluhan);
        edtLamaKeluhan = view.findViewById(R.id.edt_lama_keluhan);
        edtRiwayatCream = view.findViewById(R.id.edt_riwayat_cream);
        edtRiwayatPerawatan = view.findViewById(R.id.edt_riwayat_perawatan);
        btnSimpan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (chekForm()){
                    KonsultasiFragment.getInstance().getsKonsul().setKeluhan(edtKeluhan.getText().toString());
                    KonsultasiFragment.getInstance().getsKonsul().setArea(edtAreaKeluhan.getText().toString());
                    KonsultasiFragment.getInstance().getsKonsul().setLama(edtLamaKeluhan.getText().toString());
                    KonsultasiFragment.getInstance().getsKonsul().setRiwayatobat(edtRiwayatCream.getText().toString());
                    KonsultasiFragment.getInstance().getsKonsul().setRiwayatPerawatan(edtRiwayatPerawatan.getText().toString());
                    KonsultasiFragment.getInstance().getsKonsul().setDate(tvTanggal.getText().toString());
                    KonsultasiFragment.getInstance().setStep(1);
                }else {
                    Toast.makeText(getActivity(), "Data kosong silahkan diisi dulu", Toast.LENGTH_SHORT).show();
                }
            }
        });
        imgTanggal = view.findViewById(R.id.ic_calendar);
        tvTanggal = view.findViewById(R.id.tv_tanggal_konsultasi);

        imgTanggal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Calendar calendar = Calendar.getInstance();
                int year = calendar.get(Calendar.YEAR);
                int month = calendar.get(Calendar.MONTH);
                final int day = calendar.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog dpd = new DatePickerDialog(getActivity(), new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        if ((month+1)<10){
                            tvTanggal.setText(year+"-0"+(month+1)+"-"+day);
                        }else {
                            tvTanggal.setText(year+"-"+(month+1)+"-"+day);
                        }
                        date = true;
                    }
                }, year, month, day);
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
    private boolean isEmpty(EditText text){
        CharSequence str = text.getText().toString();
        return TextUtils.isEmpty(str);
    }
    private boolean chekForm(){
        if (isEmpty(edtKeluhan)){
            return false;
        }if (isEmpty(edtAreaKeluhan)){
            return false;
        }if(isEmpty(edtLamaKeluhan)){
            return false;
        }if (isEmpty(edtRiwayatCream)){
            return false;
        }if (isEmpty(edtRiwayatPerawatan)){
            return false;
        }if (!date){
            return false;
        }
        return true;
    }
}


