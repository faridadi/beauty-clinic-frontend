package com.example.dryulia.mainscreen.home.konsultasi.kondisiUmum;

import android.Manifest;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.os.StrictMode;
import android.provider.MediaStore;
import android.provider.Settings;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.CardView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.dryulia.R;
import com.example.dryulia.mainscreen.home.konsultasi.KonsultasiFragment;
import com.karumi.dexter.Dexter;
import com.karumi.dexter.MultiplePermissionsReport;
import com.karumi.dexter.PermissionToken;
import com.karumi.dexter.listener.DexterError;
import com.karumi.dexter.listener.PermissionRequestErrorListener;
import com.karumi.dexter.listener.multi.MultiplePermissionsListener;

import java.io.File;
import java.util.List;

public class KondisiUmumFragment extends Fragment {

    private View view;
    Button btnSimpan, reTake, btnBack;
    CardView depan, kiri, kanan;
    ImageView motherImage;
    ImageView depanImage;//1
    ImageView kiriImage; //2
    ImageView kananImage;//3
    TextView wajah;
    int tmp2 = 0;

    int tmp = 0;
    private static KondisiUmumFragment kondisiUmumFragment;
    private static final int CAMERA_REQUEST = 1888;
    private static final int MY_CAMERA_PERMISSION_CODE = 100;
    private static final int MY_READ_PERMISSION_CODE = 50;
    private static final int MY_WRITE_PERMISSION_CODE = 60;
    public static KondisiUmumFragment getInstance() {
        return kondisiUmumFragment;
    }
    private  Uri imageUri = null;

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
        wajah = view.findViewById(R.id.wajah_posisi);
        btnSimpan = view.findViewById(R.id.btn_simpan_kondisiUmum);
        depan = view.findViewById(R.id.bagian_depan);
        kiri = view.findViewById(R.id.bagian_kiri);
        kanan = view.findViewById(R.id.bagian_kanan);
        kiriImage = view.findViewById(R.id.img_kiri);
        kananImage = view.findViewById(R.id.img_kanan);
        depanImage = view.findViewById(R.id.img_depan);
        motherImage = view.findViewById(R.id.mother_image);
        reTake = view.findViewById(R.id.retake);
        btnBack = view.findViewById(R.id.btn_kembali_kondisiUmum);
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                KonsultasiFragment.getInstance().setStep(0);
            }
        });
        if (KonsultasiFragment.getInstance().getsKonsul() != null) {
            if (KonsultasiFragment.getInstance().getsKonsul().getKiri() != null) {
                Glide.with(getActivity()).load(KonsultasiFragment.getInstance().getsKonsul().getKiri()).into(kiriImage);
                Glide.with(getActivity()).load(KonsultasiFragment.getInstance().getsKonsul().getKiri()).into(motherImage);
                reTake.setVisibility(View.VISIBLE);
                wajah.setText("Kiri");
            }
            if (KonsultasiFragment.getInstance().getsKonsul().getKanan() != null) {
                Glide.with(getActivity()).load(KonsultasiFragment.getInstance().getsKonsul().getKanan()).into(kananImage);
                Glide.with(getActivity()).load(KonsultasiFragment.getInstance().getsKonsul().getKanan()).into(motherImage);
                reTake.setVisibility(View.VISIBLE);
                wajah.setText("Kanan");
            }
            if (KonsultasiFragment.getInstance().getsKonsul().getDepan() != null) {
                Glide.with(getActivity()).load(KonsultasiFragment.getInstance().getsKonsul().getDepan()).into(depanImage);
                Glide.with(getActivity()).load(KonsultasiFragment.getInstance().getsKonsul().getDepan()).into(motherImage);
                reTake.setVisibility(View.VISIBLE);
                wajah.setText("Depan");
            }
        }

        reTake.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.M)
            @Override
            public void onClick(View v) {
                hasPermission();
                if (checkPermission()) {
                    takePicture(tmp2);
                }else {
                    motherImage.setImageDrawable(depanImage.getDrawable());
                }
            }
        });

        depan.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.M)
            @Override
            public void onClick(View v) {
                tmp2 = 1;
                hasPermission();
                if (depanImage.getDrawable() == null){
                    if (checkPermission()) {
                        takePicture(1);
                    }
                }else{
                    motherImage.setImageDrawable(depanImage.getDrawable());

                }
            }
        });

        kiri.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.M)
            @Override
            public void onClick(View v) {
                tmp2 = 2;
                hasPermission();
                if (kiriImage.getDrawable() == null){
                    if (checkPermission()) {
                        takePicture(2);
                    }
                }else{
                    motherImage.setImageDrawable(kiriImage.getDrawable());
                }
            }

        });

        kanan.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.M)
            @Override
            public void onClick(View v) {
                tmp2 = 3;
                hasPermission();
                if (kananImage.getDrawable() == null){
                    if (checkPermission()) {
                        takePicture(3);
                    }
                }else{
                    motherImage.setImageDrawable(kananImage.getDrawable());
                }
            }
        });

        btnSimpan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                KonsultasiFragment.getInstance().setStep(2);
            }
        });
    }

    //fungsi mengambil foto
    private void takePicture(int image){
        //1 depan, 2 kiri. 3 kanan
        tmp = image;
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        File photo = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES),
                String.valueOf(System.currentTimeMillis()) + ".jpg");
        intent.putExtra(MediaStore.EXTRA_OUTPUT,
                Uri.fromFile(photo));
        intent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
        StrictMode.VmPolicy.Builder builder = new StrictMode.VmPolicy.Builder();
        StrictMode.setVmPolicy(builder.build());
        imageUri = Uri.fromFile(photo);
        startActivityForResult(intent, CAMERA_REQUEST);
    }

    //fungsi cek permission
    public void hasPermission() {
        final boolean cek = false;
        Dexter.withActivity(getActivity())
                .withPermissions(
                        Manifest.permission.CAMERA,
                        Manifest.permission.WRITE_EXTERNAL_STORAGE,
                        Manifest.permission.READ_EXTERNAL_STORAGE
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

    //fungsi untuk popup permission
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

    @RequiresApi(api = Build.VERSION_CODES.M)
    private boolean checkPermission(){
        if (ContextCompat.checkSelfPermission(getContext(),Manifest.permission.READ_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
            getActivity().requestPermissions(new String[]{Manifest.permission.READ_EXTERNAL_STORAGE}, MY_READ_PERMISSION_CODE);
            return false;
        }
        if (ContextCompat.checkSelfPermission(getContext(),Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
            getActivity().requestPermissions(new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, MY_WRITE_PERMISSION_CODE);
            return false;
        }
        if (ContextCompat.checkSelfPermission(getContext(),Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED) {
            getActivity().requestPermissions(new String[]{Manifest.permission.CAMERA}, MY_CAMERA_PERMISSION_CODE);
            return false;
        }
        return true;
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == MY_CAMERA_PERMISSION_CODE) {
            if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                Toast.makeText(getContext(), "camera permission denied", Toast.LENGTH_LONG).show();
            } else {
                Toast.makeText(getContext(), "camera permission denied", Toast.LENGTH_LONG).show();
            }
        }else if (requestCode == MY_READ_PERMISSION_CODE){
            if (grantResults[0] == PackageManager.PERMISSION_GRANTED){
                Toast.makeText(getContext(), "READ DATA BERHASIL", Toast.LENGTH_SHORT).show();
            }else {
                Toast.makeText(getContext(), "READ DATA ERROR", Toast.LENGTH_SHORT).show();
            }
        }else if (requestCode == MY_WRITE_PERMISSION_CODE){
            if (grantResults[0] == PackageManager.PERMISSION_GRANTED){
                Toast.makeText(getContext(), "WRITE DATA BERHASIL", Toast.LENGTH_SHORT).show();
            }else {
                Toast.makeText(getContext(), "WRITE DATA ERROR", Toast.LENGTH_SHORT).show();
            }
        }
    }

    //check the device has
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == CAMERA_REQUEST) {
            if (resultCode == Activity.RESULT_OK) {
                Uri selectedImage = imageUri;
                try {
                    //1 depan, 2 kiri, 3 kanan
                    switch (tmp){
                        case 1://depan
                            Toast.makeText(getActivity(), ""+selectedImage.getEncodedPath().toString(), Toast.LENGTH_SHORT).show();
                            KonsultasiFragment.getInstance().getsKonsul().setDepan(selectedImage.getEncodedPath().toString());
                            wajah.setText("Depan");
                            Glide.with(getActivity()).load(imageUri).into(depanImage);
                            Glide.with(getActivity()).load(imageUri).into(motherImage);
                            reTake.setVisibility(View.VISIBLE);
                            Toast.makeText(getActivity(), "Foto Depan", Toast.LENGTH_SHORT).show();
                            break;
                        case 2 : //kiri
                            KonsultasiFragment.getInstance().getsKonsul().setKiri(selectedImage.getEncodedPath().toString());
                            Glide.with(getActivity()).load(imageUri).into(kiriImage);
                            Glide.with(getActivity()).load(imageUri).into(motherImage);
                            reTake.setVisibility(View.VISIBLE);
                            Toast.makeText(getContext(), "Foto Kiri", Toast.LENGTH_SHORT).show();
                            break;
                        case 3 ://kanan
                            KonsultasiFragment.getInstance().getsKonsul().setKanan(selectedImage.getEncodedPath().toString());
                            Glide.with(getActivity()).load(imageUri).into(kananImage);
                            Glide.with(getActivity()).load(imageUri).into(motherImage);
                            reTake.setVisibility(View.VISIBLE);
                            Log.d("coba ", KonsultasiFragment.getInstance().getsKonsul().getKanan());
                            Toast.makeText(getActivity(), "Doto Kanan", Toast.LENGTH_SHORT).show();
                            break;
                        default :
                             Toast.makeText(getActivity(), "error", Toast.LENGTH_SHORT).show();
                             break;
                    }
                } catch (Exception e) {
                    Log.e("onActivityResult", e.toString());
                }
            }
            else {
                Log.d("foto", "gagal boss");
            }
        }
    }
}

