package com.example.dryulia.mainscreen.profile;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.example.dryulia.R;

public class ProfileEditPasswordFragment extends Fragment {

    EditText edtEnterPassword, edtNewPassword, edtReEnterPassword;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_profile_edit_password, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {

        edtEnterPassword = view.findViewById(R.id.edt_profile_enter_password);
        edtNewPassword = view.findViewById(R.id.edt_profile_enter_new_password);
        edtReEnterPassword = view.findViewById(R.id.edt_profile_retype_new_password);




    }
}
