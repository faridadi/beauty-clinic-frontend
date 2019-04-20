package com.example.dryulia.mainscreen.home.konsultasi;

import android.Manifest;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.Settings;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.CardView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.common.Priority;
import com.androidnetworking.error.ANError;
import com.androidnetworking.interfaces.JSONObjectRequestListener;
import com.bumptech.glide.Glide;
import com.example.dryulia.R;
import com.example.dryulia.auth.LoginActivity;
import com.example.dryulia.database.DatabaseHelper;
import com.example.dryulia.helper.ConnectivityHelper;
import com.example.dryulia.model.Konsul;
import com.example.dryulia.model.User;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;

import com.google.zxing.common.BitMatrix;
import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;
import com.journeyapps.barcodescanner.BarcodeEncoder;
import com.karumi.dexter.Dexter;
import com.karumi.dexter.MultiplePermissionsReport;
import com.karumi.dexter.PermissionToken;
import com.karumi.dexter.listener.DexterError;
import com.karumi.dexter.listener.PermissionRequestErrorListener;
import com.karumi.dexter.listener.multi.MultiplePermissionsListener;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.File;
import java.util.List;

public class BookingFragment extends Fragment {

    private View view;
    Button btnCancel, btnNext;
    ImageView barcodeImage, imgAnamnesa;
    TextView barcodeText;
    Dialog myDialog;
    CardView a, kondisiUmum;
    DatabaseHelper db;
    String url;
    String appkey;
    String token;
    String fullurl;
    String tmp;
    User user;

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
        //memilih data untuk dimasukkan di modal dialog
        imgAnamnesa = view.findViewById(R.id.booking_anamnesa);
        kondisiUmum = view.findViewById(R.id.cv_booking_kondisi_umum);

        url = "http://192.168.100.98/klinik_kecantikan/core/consultation/order";
        appkey = "2nqcKDagPLlTk9ibHOQUIG0l5bSKsloZ6JSjrshFcV8xYLGRixtuEKVGlIBGv04LRpnQrOcxvYg";
        token = "6FST6Pz39hPeTtHIYvDEGuMAbLWpuFoQ3uLbw3nLUTIjDJcz53nnmEjepGtGaY9V1PLfbY2q0TY";
        fullurl = "";

        barcodeText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                db.deleteAllKonsul();
                Toast.makeText(getActivity(), "Konsul database clear", Toast.LENGTH_SHORT).show();
            }
        });

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
        if (db.cekUser()){
            user = db.getUser();
            token = user.getToken_acc();
            fullurl = url+"?appkey="+appkey+"&token="+token;
        }

        //cek data konsul di database jika tidak ada koneksi atau offline
        if (db.cekKonsul()){
            Konsul ko = db.getKonsul();
            Bitmap bitmap = generateBarcode(ko.getBarcode(),200,200);
            barcodeImage.setImageBitmap(bitmap);
            barcodeText.setText(ko.getBarcode());
            barcodeText.setVisibility(View.VISIBLE);
            btnCancel.setVisibility(View.INVISIBLE);
            btnNext.setVisibility(View.INVISIBLE);
        }

        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //cek koneksi
                if (!ConnectivityHelper.isConnectedToNetwork(getActivity())){
                    Toast.makeText(getActivity(), "Anda belum terhubung dengan internet", Toast.LENGTH_SHORT).show();
                    return;
                }

                AlertDialog.Builder alertdialog = new AlertDialog.Builder(getContext());
                alertdialog.setMessage("Apabila anda klik ya maka akan muncul barcode untuk di scan di CS. " +
                        "Booking antrian sekarang? ");
                alertdialog.setTitle("Konfirmasi Booking Antrian");
                alertdialog.setPositiveButton("Ya", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        //cek data di temporary dan database konsultasi
                        if (db.cekKonsul()){
                            Konsul ko = db.getKonsul();
                            Bitmap bitmap = generateBarcode(ko.getBarcode(),200,200);
                            barcodeImage.setImageBitmap(bitmap);
                            barcodeText.setText(ko.getBarcode());
                            barcodeText.setVisibility(View.VISIBLE);
                            btnCancel.setVisibility(View.INVISIBLE);
                            Log.d("Barcode", "Barcode sudah di add");
                        }else{// user melakukan save data ke server
                            Log.d("user Id" , user.getIdUser().toString());
                            Log.d("User name" , user.getName().toString());
                            AndroidNetworking.upload(fullurl)
                                    .setPriority(Priority.MEDIUM)
                                    .addMultipartParameter("customer_id",user.getIdUser())
                                    .addMultipartParameter("customer_name", user.getName())
                                    .addMultipartParameter("complaint", KonsultasiFragment.getInstance().getsKonsul().getKeluhan())
                                    .addMultipartParameter("complaint_area", KonsultasiFragment.getInstance().getsKonsul().getArea())
                                    .addMultipartParameter("long_complaint", KonsultasiFragment.getInstance().getsKonsul().getLama())
                                    .addMultipartParameter("history_cream", KonsultasiFragment.getInstance().getsKonsul().getRiwayatobat())
                                    .addMultipartParameter("history_treatment", KonsultasiFragment.getInstance().getsKonsul().getRiwayatPerawatan())
                                    .addMultipartParameter("consul_date", KonsultasiFragment.getInstance().getsKonsul().getDate())
                                    .addMultipartFile("face_pict", new File(KonsultasiFragment.getInstance().getsKonsul().getDepan()))
                                    .addMultipartFile("left_face_pict", new File(KonsultasiFragment.getInstance().getsKonsul().getKiri()))
                                    .addMultipartFile("right_face_pict", new File(KonsultasiFragment.getInstance().getsKonsul().getKanan()))
                                    .build()
                                    .getAsJSONObject(new JSONObjectRequestListener() {
                                @Override
                                public void onResponse(JSONObject response) {//mendapat data dari server berupa barcode yang akan disimpan dalam database
                                    String respons ="", barcode = "", tanggal = "";
                                    try{
                                        respons = response.getString("response");
                                        if (respons.equals("success")){
                                            JSONObject data = response.getJSONObject("data");
                                            barcode = data.getString("booking_code");
                                            tanggal = data.getString("consul_date");
                                            Toast.makeText(getActivity(), "Berhasil upload", Toast.LENGTH_SHORT).show();
                                        }else {
                                            Toast.makeText(getActivity(), "Gagal upload", Toast.LENGTH_SHORT).show();
                                            return;
                                        }
                                    } catch (JSONException e) {
                                        e.printStackTrace();
                                        Toast.makeText(getActivity(), "gagal parsing", Toast.LENGTH_SHORT).show();
                                        return;
                                    }

                                    if (respons.equals("success")){
                                        //seleksi kondisi response json dari server
                                        Log.d("json", response.toString());// Whatever you need to encode in the QR code
                                        //get data barcode from server, save to local database, save new data konsul to database
                                        try {
                                            //generate barcode from text
                                            Bitmap bitmap = generateBarcode(barcode,300,300);
                                            if (bitmap==null){
                                                Log.d("Barcode", "Error generate Barcode");
                                                return;
                                            }
                                            KonsultasiFragment.getInstance().getsKonsul().setBarcode(barcode);
                                            barcodeImage.setImageBitmap(bitmap);
                                            barcodeText.setText(barcode);
                                            barcodeText.setVisibility(View.VISIBLE);
                                            btnCancel.setVisibility(View.INVISIBLE);
                                            btnNext.setVisibility(View.INVISIBLE);
                                            db.deleteAllKonsul();
                                            //data didapat dari getInstance
                                            db.insertKonsul(new Konsul(
                                                    KonsultasiFragment.getInstance().getsKonsul().getKeluhan(),
                                                    KonsultasiFragment.getInstance().getsKonsul().getArea(),
                                                    KonsultasiFragment.getInstance().getsKonsul().getLama(),
                                                    KonsultasiFragment.getInstance().getsKonsul().getRiwayatobat(),
                                                    KonsultasiFragment.getInstance().getsKonsul().getRiwayatPerawatan(),
                                                    KonsultasiFragment.getInstance().getsKonsul().getDate(),
                                                    KonsultasiFragment.getInstance().getsKonsul().getDepan(),
                                                    KonsultasiFragment.getInstance().getsKonsul().getKiri(),
                                                    KonsultasiFragment.getInstance().getsKonsul().getKanan(),
                                                    barcode));
                                        } catch (Exception e) {
                                            e.printStackTrace();
                                        }
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

                alertdialog.setNegativeButton("Tidak", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
                AlertDialog alertDialog2  = alertdialog.create();
                alertDialog2.show();
            }
        });

        //tombol untuk ke
        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                KonsultasiFragment.getInstance().setStep(0);
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

    private Konsul checkDataShow(){
        Konsul konsul;
        if (db.cekKonsul()){
            konsul = db.getKonsul();
        }else{
            konsul = KonsultasiFragment.getInstance().getsKonsul();
        }
        return konsul;
    }

    private void showAnamnesaDialog() {
        Konsul konsul =checkDataShow();
        final Dialog dialog = new Dialog(getActivity());
        dialog.setCancelable(true);
        View view  = getActivity().getLayoutInflater().inflate(R.layout.popup_anamnesa, null);
        dialog.setContentView(view);
        final ImageView exit = view.findViewById(R.id.img_popup_anamnesa_exit);
        final TextView keluhan = view.findViewById(R.id.tv_popup_keluhan);
        final TextView area = view.findViewById(R.id.tv_popup_area_keluhan);
        final TextView lama = view.findViewById(R.id.tv_popup_lama_keluhan);
        final TextView riwayatCream = view.findViewById(R.id.tv_popup_riwayat_cream);
        final TextView riwayatPerawtan = view.findViewById(R.id.tv_popup_riwayat_perawatan);
        keluhan.setText(konsul.getKeluhan());
        area.setText(konsul.getArea());
        lama.setText(konsul.getLama());
        riwayatCream.setText(konsul.getRiwayatobat());
        riwayatPerawtan.setText(konsul.getRiwayatPerawatan());
        exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               dialog.dismiss();
            }
        });
        dialog.show();
    }
    private void showKondisiUmumDialog() {
        Konsul konsul =checkDataShow();
        final Dialog dialog = new Dialog(getActivity());
        dialog.setCancelable(true);
        View view  = getActivity().getLayoutInflater().inflate(R.layout.popup_kondisi_umum, null);
        dialog.setContentView(view);
        final ImageView exit = view.findViewById(R.id.img_popup_kondisiumum_exit);
        final ImageView depan = view.findViewById(R.id.img__popup_kondisi_umum_wajah_depan);
        final ImageView kiri = view.findViewById(R.id.img__popup_kondisi_umum_wajah_kiri);
        final ImageView kanan = view.findViewById(R.id.img__popup_kondisi_umum_wajah_kanan);
        Glide.with(getActivity()).load(konsul.getDepan()).into(depan);
        Glide.with(getActivity()).load(konsul.getKiri()).into(kiri);
        Glide.with(getActivity()).load(konsul.getKanan()).into(kanan);

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

    public void hasPermission() {
        final boolean cek = false;
        Dexter.withActivity(getActivity())
                .withPermissions(
                        Manifest.permission.CAMERA,
                        Manifest.permission.WRITE_EXTERNAL_STORAGE,
                        Manifest.permission.READ_EXTERNAL_STORAGE,
                        Manifest.permission.INTERNET,
                        Manifest.permission.ACCESS_WIFI_STATE,
                        Manifest.permission.ACCESS_NETWORK_STATE
                ).withListener(new MultiplePermissionsListener() {
            @Override
            public void onPermissionsChecked(MultiplePermissionsReport report) {
                if (report.areAllPermissionsGranted()) {
                    Toast.makeText(getActivity(), "All permissions are granted!", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (report.isAnyPermissionPermanentlyDenied()) {
                    openSettingsDialog();// show alert dialog box
                }
            }
            @Override
            public void onPermissionRationaleShouldBeShown(List permissions, PermissionToken token) {
                token.continuePermissionRequest();
            }
        }).
                withErrorListener(new PermissionRequestErrorListener() {
                    @Override
                    public void onError(DexterError error) {
                        Toast.makeText(getContext(), "Error!! ", Toast.LENGTH_SHORT).show();
                    }
                })
                .onSameThread()
                .check();
    }
    public void openSettingsDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle("Permissions Required");
        builder.setMessage("Permission is required for using this app. Please enable them in app settings.");
        builder.setPositiveButton("Go to SETTINGS", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
                showsettings();
            }
        });
    }

    //fungsi untuk mengatur permission di setting
    public void showsettings() {
        Intent intent = new Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS);
        Uri uri = Uri.fromParts("package", getActivity().getPackageName(), null);
        intent.setData(uri);
        startActivityForResult(intent, 101);
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