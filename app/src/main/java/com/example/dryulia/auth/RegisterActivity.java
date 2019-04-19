package com.example.dryulia.auth;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.common.Priority;
import com.androidnetworking.error.ANError;
import com.androidnetworking.interfaces.JSONObjectRequestListener;
import com.example.dryulia.R;
import com.example.dryulia.database.DatabaseHelper;
import com.example.dryulia.mainscreen.MainScreenActivity;
import com.example.dryulia.model.User;

import org.json.JSONException;
import org.json.JSONObject;

public class RegisterActivity extends AppCompatActivity {

    EditText nama, uname, upass, email, phone;
    Button regis;
    DatabaseHelper db;
    String url, apikey, nameKey;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        db = new DatabaseHelper(getApplicationContext());
        url = "http://192.168.100.98/klinik_kecantikan/core/request/registration?appkey=2nqcKDagPLlTk9ibHOQUIG0l5bSKsloZ6JSjrshFcV8xYLGRixtuEKVGlIBGv04LRpnQrOcxvYg";
        apikey = "2nqcKDagPLlTk9ibHOQUIG0l5bSKsloZ6JSjrshFcV8xYLGRixtuEKVGlIBGv04LRpnQrOcxvYg";
        nameKey = "appkey";

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
                if(chekForm()) {
                    AndroidNetworking.post(url)
                            .setPriority(Priority.MEDIUM)
                            .addBodyParameter("name", nama.getText().toString())
                            .addBodyParameter("uname", nama.getText().toString())
                            .addBodyParameter("address", nama.getText().toString())
                            .addBodyParameter("upass", nama.getText().toString())
                            .addBodyParameter("email", nama.getText().toString())
                            .addBodyParameter("phone", nama.getText().toString())
                            .build()
                            .getAsJSONObject(new JSONObjectRequestListener() {
                                @Override
                                public void onResponse(JSONObject response) {
                                    //Handle Response
                                    Log.d("TAG", "onResponse: " + response); //untuk log pada onresponse
                                    try {
                                        String res = response.getString("response");
                                        JSONObject data = response.getJSONObject("data");
                                        String id = data.getString("id");
                                        String name = data.getString("name");
                                        String phone = data.getString("phone");
                                        String email = data.getString("email");
                                        String address = data.getString("address");
                                        String uname = data.getString("uname");
                                        String token_acc = data.getString("token_acc");
                                        Toast.makeText(RegisterActivity.this, res.toString(), Toast.LENGTH_SHORT).show();
                                        User user = new User(id, name, phone, email, address, uname, token_acc, "");
                                        if (res.toString().equals("success")) {
                                            if (db.cekUser()) {
                                            } else {
                                                db.insertUser(user);
                                            }
                                            Intent intent = new Intent(getApplicationContext(), MainScreenActivity.class);
                                            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP);
                                            startActivity(intent);
                                            finish();
                                            return;
                                        } else {
                                            Toast.makeText(getApplicationContext(), "gagal login", Toast.LENGTH_SHORT).show();
                                        }
                                    } catch (JSONException e) {
                                        e.printStackTrace();
                                        Toast.makeText(getApplicationContext(), "Gagal Login silahkan d", Toast.LENGTH_SHORT).show();
                                    }

                                }

                                @Override
                                public void onError(ANError error) {
                                    //Handle Error
                                    Log.d("TAG", "onError: Failed" + error); //untuk log pada onerror
                                    Toast.makeText(getApplicationContext(), "Data gagal ditambahkan", Toast.LENGTH_SHORT).show();
                                    //memunculkan Toast saat data gagal ditambahkan
                                }
                            });
                }else {
                    Toast.makeText(RegisterActivity.this, "Ada field yang kosong", Toast.LENGTH_SHORT).show();
                }
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
