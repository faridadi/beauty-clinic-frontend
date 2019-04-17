package com.example.dryulia.mainscreen.home.konsultasi.kondisiUmum;

import android.Manifest;
import android.app.Activity;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.CardView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.dryulia.R;
import com.example.dryulia.mainscreen.MainScreenActivity;
import com.example.dryulia.mainscreen.home.konsultasi.KonsultasiFragment;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.util.Objects;

public class KondisiUmumFragment extends Fragment {

    private View view;
    Button btnSimpan;
    CardView depan, kiri, kanan;
    ImageView motherImage;
    private static KondisiUmumFragment kondisiUmumFragment;
    private static final int CAMERA_REQUEST = 1888;
    private ImageView imageView;
    private static final int MY_CAMERA_PERMISSION_CODE = 100;

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
        btnSimpan = view.findViewById(R.id.btn_simpan_kondisiUmum);
        depan = view.findViewById(R.id.bagian_depan);
        kiri = view.findViewById(R.id.bagian_kiri);
        kanan = view.findViewById(R.id.bagian_kanan);
        motherImage = view.findViewById(R.id.mother_image);


        depan.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.M)
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                File photo = new File(Environment.getExternalStorageDirectory(),  "Pic.jpg");
                intent.putExtra(MediaStore.EXTRA_OUTPUT,
                        Uri.fromFile(photo));
                imageUri = Uri.fromFile(photo);
                startActivityForResult(intent, MY_CAMERA_PERMISSION_CODE);

                //if (Objects.requireNonNull(getContext()).checkSelfPermission(Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED) {
                //    requestPermissions(new String[]{Manifest.permission.CAMERA}, MY_CAMERA_PERMISSION_CODE);
                //} else {
               //     Intent cameraIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                 //   startActivityForResult(cameraIntent, MY_CAMERA_PERMISSION_CODE);
                //}
            }

        });

        btnSimpan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                KonsultasiFragment.getInstance().setStep(2);
            }
        });

    }


    //check the device has camera
    private boolean checkCameraHardware(Context context) {
        if (context.getPackageManager().hasSystemFeature(PackageManager.FEATURE_CAMERA)) {
            //the device has camera
            return true;
        } else {
            return false;
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == MY_CAMERA_PERMISSION_CODE) {
            if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                Toast.makeText(getContext(), "camera permission granted", Toast.LENGTH_LONG).show();
                //Intent cameraIntent = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
                Intent cameraIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(cameraIntent, MY_CAMERA_PERMISSION_CODE);
            } else {
                Toast.makeText(getContext(), "camera permission denied", Toast.LENGTH_LONG).show();
            }
        }
    }



        /*public void onActivityResult(int requestCode, int resultCode, Intent data)
        {
            super.onActivityResult(requestCode, resultCode, data);
            if (requestCode == CAMERA_REQUEST && resultCode == Activity.RESULT_OK)
            {
                Bitmap photo = (Bitmap) data.getExtras().get("data");
                imageView.setImageBitmap(photo);



            }
        }*/
/*
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == CAMERA_REQUEST && resultCode == Activity.RESULT_OK) {
            Bitmap photo = (Bitmap) data.getExtras().get("data");
            //motherImage.setImageBitmap(photo);

        }
    }
*/
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
       //Toast.makeText(getContext(), "camera permission granted", Toast.LENGTH_LONG).show();
        if (requestCode == MY_CAMERA_PERMISSION_CODE) {
            if (resultCode == Activity.RESULT_OK) {

                Uri selectedImage = imageUri;
                getActivity().getContentResolver().notifyChange(selectedImage, null);
                ContentResolver cr = getActivity().getContentResolver();
                Bitmap bitmap;
                try {
                    bitmap = android.provider.MediaStore.Images.Media
                            .getBitmap(cr, selectedImage);

                    motherImage.setImageBitmap(bitmap);

                    Toast.makeText(getActivity(), selectedImage.toString(),
                            Toast.LENGTH_LONG).show();
                } catch (Exception e) {
                    Toast.makeText(getActivity(), "Failed to load", Toast.LENGTH_SHORT)
                            .show();
                    Log.e("Camera", e.toString());
                    Log.d("URI", selectedImage.toString());
                }

            }
            else {
                Log.d("foto", "gagal boss");
            }
        }

    }
}

