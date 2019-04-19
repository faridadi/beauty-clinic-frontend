package com.example.dryulia.auth;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.error.ANError;
import com.androidnetworking.interfaces.JSONObjectRequestListener;
import com.example.dryulia.R;
import com.example.dryulia.database.DatabaseHelper;
import com.example.dryulia.mainscreen.MainScreenActivity;
import com.example.dryulia.model.User;

import org.json.JSONObject;

public class LoginActivity extends AppCompatActivity {

    EditText uname;
    EditText pass;
    Button login;
    TextView regis;
    DatabaseHelper db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //cek user di database;
        db = new DatabaseHelper(getApplicationContext());
        setContentView(R.layout.activity_login);
        uname = (EditText) findViewById(R.id.login_username);
        pass = (EditText) findViewById(R.id.login_password);
        login = (Button) findViewById(R.id.button_login);
        regis = (TextView) findViewById(R.id.text_register);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = uname.getText().toString();
                String password = pass.getText().toString();
                if(TextUtils.isEmpty(username)) {
                    uname.setError("Username Kosong silahkan isi");
                    Toast.makeText(LoginActivity.this, "Username Kosong silahkan isi", Toast.LENGTH_SHORT).show();
                    return;
                }
                if(TextUtils.isEmpty(password)) {
                    pass.setError("Password Kosong silahkan isi");
                    Toast.makeText(LoginActivity.this, "Password Kosong silahkan isi", Toast.LENGTH_SHORT).show();
                    return;
                }

                AndroidNetworking.get("https://api.myjson.com/bins/158wds")
                        .build().getAsJSONObject(new JSONObjectRequestListener() {
                            //handle dari server
                    @Override
                    public void onResponse(JSONObject response) {
                        if (db.cekUser()){
                            if (db.loginUser(uname.getText().toString())){
                                Toast.makeText(LoginActivity.this, "Login sukses", Toast.LENGTH_SHORT).show();
                                startActivity(new Intent(getApplicationContext(),MainScreenActivity.class));
                                return;
                            }
                            Toast.makeText(LoginActivity.this, "Salah username", Toast.LENGTH_SHORT).show();
                            return;
                        }
                    }

                    @Override
                    public void onError(ANError anError) {
                        Toast.makeText(LoginActivity.this, "login Gagal", Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });

        regis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),RegisterActivity.class));
            }
        });


    }
}
