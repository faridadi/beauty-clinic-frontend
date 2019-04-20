package com.example.dryulia.auth;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.common.ConnectionClassManager;
import com.androidnetworking.common.Priority;
import com.androidnetworking.error.ANError;
import com.androidnetworking.interfaces.JSONObjectRequestListener;
import com.example.dryulia.R;
import com.example.dryulia.database.DatabaseHelper;
import com.example.dryulia.helper.ConnectivityHelper;
import com.example.dryulia.mainscreen.MainScreenActivity;
import com.example.dryulia.model.User;

import org.json.JSONException;
import org.json.JSONObject;

public class LoginActivity extends AppCompatActivity {

    EditText uname;
    EditText pass;
    Button login;
    TextView regis;
    DatabaseHelper db;

    String url;
    String apikey;
    String nameKey;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        db = new DatabaseHelper(getApplicationContext());
        if (db.cekUser()){
            Intent intent = new Intent(LoginActivity.this, MainScreenActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(intent);
            finish();
        }
        super.onCreate(savedInstanceState);
        //cek user di database;
        setContentView(R.layout.activity_login);
        uname = (EditText) findViewById(R.id.login_username);
        pass = (EditText) findViewById(R.id.login_password);
        login = (Button) findViewById(R.id.button_login);
        regis = (TextView) findViewById(R.id.text_register);
        url = "http://192.168.100.98/klinik_kecantikan/core/request/auth_cust?appkey=2nqcKDagPLlTk9ibHOQUIG0l5bSKsloZ6JSjrshFcV8xYLGRixtuEKVGlIBGv04LRpnQrOcxvYg";
        apikey = "2nqcKDagPLlTk9ibHOQUIG0l5bSKsloZ6JSjrshFcV8xYLGRixtuEKVGlIBGv04LRpnQrOcxvYg";
        nameKey = "appkey";

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
                if (ConnectivityHelper.isConnectedToNetwork(getApplicationContext())) {
                    AndroidNetworking.post(url)
                            .setPriority(Priority.MEDIUM)
                            .addBodyParameter("uname", username)
                            .addBodyParameter("upass", password)
                            .addPathParameter("appkey", apikey)
                            .build()
                            .getAsJSONObject(new JSONObjectRequestListener() {
                                @Override
                                public void onResponse(JSONObject response) {
                                    //Handle Response
                                    Log.d("TAG", "onResponse: " + response); //untuk log pada onresponse
                                    try {
                                        String res = response.getString("response");
                                        JSONObject data = response.getJSONObject("data");
                                        String id  = data.getString("id");
                                        String name = data.getString("name");
                                        String phone = data.getString("phone");
                                        String email = data.getString("email");
                                        String address = data.getString("address");
                                        String uname = data.getString("uname");
                                        String token_acc = data.getString("token_acc");
                                        String token_gcm = data.getString("token_gcm");
                                        User user = new User(id,name,phone,email,address,uname,token_acc,token_gcm);
                                        if (res.toString().equals("success")){
                                            if (db.cekUser()){

                                            }else {
                                                db.insertUser(user);
                                            }
                                            Intent intent = new Intent(LoginActivity.this, MainScreenActivity.class);
                                            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP);
                                            startActivity(intent);
                                            finish();

                                            return;
                                        }else{
                                            Toast.makeText(LoginActivity.this, "gagal login", Toast.LENGTH_SHORT).show();
                                        }
                                    } catch (JSONException e) {
                                        e.printStackTrace();
                                        Toast.makeText(LoginActivity.this, "Gagal Login silahkan d", Toast.LENGTH_SHORT).show();
                                    }
                                }
                                @Override
                                public void onError(ANError error) {
                                    //Handle Error
                                    Log.d("TAG", "onError: Failed" + error); //untuk log pada onerror
                                    Toast.makeText(getApplicationContext(),"Data gagal ditambahkan", Toast.LENGTH_SHORT).show();
                                    //memunculkan Toast saat data gagal ditambahkan
                                }
                            });
                } else {
                    Toast.makeText(LoginActivity.this, "Anda Belum Terhubung Internet", Toast.LENGTH_SHORT).show();
                }
            }
        });

        regis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),RegisterActivity.class));
                finish();
            }
        });
    }
}
