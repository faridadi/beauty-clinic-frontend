package com.example.dryulia.mainscreen.profile;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.dryulia.R;
import com.example.dryulia.auth.LoginActivity;
import com.example.dryulia.database.DatabaseHelper;
import com.example.dryulia.mainscreen.MainScreenActivity;
import com.example.dryulia.model.User;

public class ProfileShowFragment extends Fragment {

    TextView namaLengkap, username, email, alamat, noTelepon, tanggalLahir ;
    ImageView imgProfile, imgEditProfile;
    CardView logout;
    DatabaseHelper db;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_profile_show, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        db = new DatabaseHelper(getActivity());

        namaLengkap = view.findViewById(R.id.tv_profile_nama_lengkap);
        username = view.findViewById(R.id.tv_profile_username);
        email = view.findViewById(R.id.tv_profile_email);
        alamat = view.findViewById(R.id.tv_profile_alamat);
        noTelepon = view.findViewById(R.id.tv_profile_no_telepon);
        tanggalLahir = view.findViewById(R.id.tv_profile_tanggal_lahir);
        imgProfile = view.findViewById(R.id.ic_edit_profile);
        imgEditProfile = view.findViewById(R.id.ic_edit_profile);
        logout = view.findViewById(R.id.tv_profile_logout);

        //cek user database
        if  (db.cekUser()){
            User us = db.getUser();
            namaLengkap.setText(us.getName());
            username.setText(us.getUname());
            email.setText(us.getEmail());
            alamat.setText(us.getAddress());
            noTelepon.setText(us.getPhone());
        }else{

        }

        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new DatabaseHelper(getActivity()).deleteAllRow();
                Toast.makeText(getActivity(), "Anda Logout", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(getActivity(), LoginActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
                getActivity().finish();
            }
        });

        imgEditProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment profileEditFragment = new ProfileEditFragment();
                FragmentTransaction transaction = getFragmentManager().beginTransaction();
                transaction.replace(R.id.profile_container, profileEditFragment).commit();
            }
        });
    }
}
