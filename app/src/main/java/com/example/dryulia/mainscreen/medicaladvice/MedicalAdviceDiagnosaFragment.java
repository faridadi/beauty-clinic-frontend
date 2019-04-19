package com.example.dryulia.mainscreen.medicaladvice;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.dryulia.R;
import com.example.dryulia.mainscreen.profile.ProfileShowFragment;


public class MedicalAdviceDiagnosaFragment extends Fragment {
    Button medicalAdvice;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_medical_advice_diagnosa, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        medicalAdvice = view.findViewById(R.id.button_medical_advice);
        medicalAdvice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment showAdvice = new MedicalAdviceShowFragment();
                FragmentTransaction transaction = getFragmentManager().beginTransaction();
                transaction.replace(R.id.medical_advice_container, showAdvice).commit();
            }
        });
    }
}
