package com.example.dryulia.mainscreen.profile;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.dryulia.R;

public class ProfileShowFragment extends Fragment {

    TextView namaLengkap, username, email, alamat, noTelepon, tanggalLahir ;
    ImageView imgProfile, imgEditProfile;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_profile_show, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {

        namaLengkap = view.findViewById(R.id.tv_profile_nama_lengkap);
        username = view.findViewById(R.id.tv_profile_username);
        email = view.findViewById(R.id.tv_profile_email);
        alamat = view.findViewById(R.id.tv_profile_alamat);
        noTelepon = view.findViewById(R.id.tv_profile_no_telepon);
        tanggalLahir = view.findViewById(R.id.tv_profile_tanggal_lahir);
        imgProfile = view.findViewById(R.id.ic_edit_profile);
        imgEditProfile = view.findViewById(R.id.ic_edit_profile);


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
