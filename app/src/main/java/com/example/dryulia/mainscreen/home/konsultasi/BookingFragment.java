package com.example.dryulia.mainscreen.home.konsultasi;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.CardView;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import android.support.v4.app.Fragment;
import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.error.ANError;
import com.androidnetworking.interfaces.JSONObjectRequestListener;
import com.example.dryulia.R;
import com.example.dryulia.database.DatabaseHelper;
import com.example.dryulia.model.Konsul;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.client.android.Intents;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;
import com.journeyapps.barcodescanner.BarcodeEncoder;

import org.json.JSONObject;

public class BookingFragment extends Fragment {

    private View view;
    Button btnCancel, btnNext;
    ImageView barcodeImage, imgAnamnesa;
    TextView barcodeText;
    Dialog myDialog;
    CardView a, kondisiUmum;
    DatabaseHelper db;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_booking, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        AndroidNetworking.initialize(getContext());
        db = new DatabaseHelper(getActivity());
        barcodeImage = view.findViewById(R.id.img_barcode);
        barcodeText = view.findViewById(R.id.booking_code);
        btnNext = view.findViewById(R.id.btn_booking_next);
        btnCancel = view.findViewById(R.id.btn_booking_cancel);

        imgAnamnesa = view.findViewById(R.id.booking_anamnesa);
        kondisiUmum = view.findViewById(R.id.cv_booking_kondisi_umum);

        //Show dialog untuk kondisi
        kondisiUmum.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showKondisiUmumDialog();

            }
        });
        //show anamnesa
        a = view.findViewById(R.id.a);
        a.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showAnamnesaDialog();
            }
        });



        //cek data konsul di database jika tidak ada koneksi atau offline
        if (db.cekKonsul()){
            Konsul ko = db.getKonsul();
            Bitmap bitmap = generateBarcode(ko.getBarcode(),200,200);
            barcodeImage.setImageBitmap(bitmap);
            barcodeText.setText(ko.getBarcode());
            barcodeText.setVisibility(View.VISIBLE);
            btnCancel.setVisibility(View.INVISIBLE);
        }

        //Tombol save akhir
        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //cek data di temporary dan database konsultasi
                if (!TextUtils.isEmpty(KonsultasiFragment.getInstance().getsBarcode())||db.cekKonsul()){
                    Bitmap bitmap = generateBarcode(KonsultasiFragment.getInstance().getsBarcode(),200,200);
                    barcodeImage.setImageBitmap(bitmap);
                    barcodeText.setText(KonsultasiFragment.getInstance().getsBarcode());
                    barcodeText.setVisibility(View.VISIBLE);
                    btnCancel.setVisibility(View.INVISIBLE);
                    Log.d("Barcode", "Barcode sudah di add");
                }else{// user melakukan save data ke server
                    AndroidNetworking.get("https://api.myjson.com/bins/158wds")
                            .build().getAsJSONObject(new JSONObjectRequestListener() {
                        @Override
                        public void onResponse(JSONObject response) {//mendapat data dari server berupa barcode yang akan disimpan dalam database
                            Log.d("json", response.toString());
                            String text=response.toString(); // Whatever you need to encode in the QR code
                            //get data barcode from server, save to local database, save new data konsul to database
                            db.deleteAllKonsul();
                            //data didapat dari getInstance
                            db.insertKonsul(new Konsul("Keluhan","area","lama","riwayatobat", "riwayatPerawatan", "date", "depan", "kiri", "kanan", text));
                            try {
                                //generate barcode from text
                                Bitmap bitmap = generateBarcode(text,200,200);
                                if (bitmap==null){
                                    Log.d("Barcode", "Error generate Barcode");
                                    return;
                                }
                                KonsultasiFragment.getInstance().setsBarcode(text);
                                barcodeImage.setImageBitmap(bitmap);
                                barcodeText.setText(text);
                                barcodeText.setVisibility(View.VISIBLE);
                                btnCancel.setVisibility(View.INVISIBLE);
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }
                        @Override
                        public void onError(ANError anError) {
                            Log.d("error", anError.toString());
                        }
                    });
                }
            }
        });

        //tombol untuk ke
        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                db.deleteAllKonsul();
                KonsultasiFragment.getInstance().setStep(1);
            }
        });

    }

    private Bitmap generateBarcode(String url, int width, int height){
        MultiFormatWriter multiFormatWriter = new MultiFormatWriter();
        try {
            BitMatrix bitMatrix = multiFormatWriter.encode(url, BarcodeFormat.QR_CODE,width,height);
            BarcodeEncoder barcodeEncoder = new BarcodeEncoder();
            Bitmap bitmap = barcodeEncoder.createBitmap(bitMatrix);
            return bitmap;
        } catch (WriterException e) {
            e.printStackTrace();
            return null;
        }
    }

    private void showAnamnesaDialog() {
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
    private void showKondisiUmumDialog() {
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
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        IntentResult result = IntentIntegrator.parseActivityResult(requestCode, resultCode, data);
        if(result != null) {
            if(result.getContents() == null) {
                Toast.makeText(getActivity(), "Cancelled", Toast.LENGTH_LONG).show();
            } else {
                Toast.makeText(getActivity(), "Scanned: " + result.getContents(), Toast.LENGTH_LONG).show();
            }
        } else {
            super.onActivityResult(requestCode, resultCode, data);
        }
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