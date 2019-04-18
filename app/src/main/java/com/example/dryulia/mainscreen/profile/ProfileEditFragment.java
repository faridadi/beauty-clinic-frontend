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

public class ProfileEditFragment extends Fragment {

    EditText edtNamaLengkap, edtUsername, edtEmail, edtAlamat, edtNoTelepon, edtTanggalLahir;
    TextView changePassword;
    ImageView profilePic;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_profile_edit, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {

        edtNamaLengkap = view.findViewById(R.id.edt_profile_nama_lengkap);
        edtUsername = view.findViewById(R.id.edt_profile_username);
        edtEmail = view.findViewById(R.id.edt_profile_email);
        edtAlamat = view.findViewById(R.id.edt_profile_alamat);
        edtNoTelepon = view.findViewById(R.id.edt_profile_no_telepon);
        edtTanggalLahir = view.findViewById(R.id.edt_profile_tanggal_lahir);
        changePassword = view.findViewById(R.id.tv_change_password);
        profilePic = view.findViewById(R.id.img_picture_profile);

        changePassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment profileedtPasswrod = new ProfileEditPasswordFragment();
                FragmentTransaction transaction = getFragmentManager().beginTransaction();
                transaction.replace(R.id.profile_container, profileedtPasswrod).commit();
            }
        });




    }
}
