package com.example.dryulia.auth;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.dryulia.R;
import com.example.dryulia.database.DatabaseHelper;
import com.example.dryulia.mainscreen.MainScreenActivity;
import com.example.dryulia.model.User;

public class RegisterActivity extends AppCompatActivity {

    EditText nama, uname, upass, email, phone;
    Button regis;
    DatabaseHelper db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        db = new DatabaseHelper(getApplicationContext());
        nama = (EditText) findViewById(R.id.register_namaLengkap);
        uname = (EditText) findViewById(R.id.register_username);
        upass = (EditText) findViewById(R.id.register_password);
        email = (EditText) findViewById(R.id.register_email);
        phone = (EditText) findViewById(R.id.register_Notelepon);
        regis = (Button) findViewById(R.id.button_register);

        nama.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                startActivity(new Intent(getApplicationContext(), MainScreenActivity.class));
                return false;
            }
        });
        regis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }

    private boolean isEmpty(EditText text){
        CharSequence str = text.getText().toString();
        return TextUtils.isEmpty(str);
    }

    private boolean chekForm(){
        if (isEmpty(nama) && isEmpty(uname) && isEmpty(upass) && isEmpty(email) && isEmpty(phone)){
            if (isEmpty(nama)){
                nama.setError("nama");
            }if (isEmpty(uname)){
                uname.setError("uname");
            }if (isEmpty(upass)){
                upass.setError("upass");
            }if (isEmpty(email)){
                email.setError("email");
            }if (isEmpty(phone)){
                phone.setError("phone");
            }
            return false;
        }else {
            return true;
        }
    }
}
