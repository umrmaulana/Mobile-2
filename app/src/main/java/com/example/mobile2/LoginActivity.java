package com.example.mobile2;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.mobile2.api.LoginAPI;
import com.example.mobile2.api.ServerAPI;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class LoginActivity extends AppCompatActivity {
    public static final String URL = new ServerAPI().BASE_URL;
    ProgressDialog pd;
    Button btnLogin;
    EditText ti_username, ti_password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_login);
        getSupportActionBar().hide();
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        EditText ti_username = (EditText) findViewById(R.id.ti_username);
        EditText ti_password = (EditText) findViewById(R.id.ti_password);
        Button btnLogin = (Button) findViewById(R.id.btn_login);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pd = new ProgressDialog(view.getContext());
                pd.setTitle("Progres Login...");
                pd.setMessage("Tunggu Sebentar...");
                pd.setCancelable(true);
                pd.setIndeterminate(true);
                prosesLogin(ti_username.getText().toString(),ti_password.getText().toString());
            }
        });
    }
    void prosesLogin(String vusername, String vpassword){
        pd.show();
        Retrofit retrofit = new Retrofit.Builder().baseUrl(URL).addConverterFactory(GsonConverterFactory.create()).build();
        LoginAPI api = retrofit.create(LoginAPI.class);
        api.login(vusername,vpassword).enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                try{
                    JSONObject json = new JSONObject(response.body().string());

                    if(json.getString("result").toString().equals("1")){
                        if(json.getJSONObject("data").getString("status").equals("1")){
                            Toast.makeText(LoginActivity.this,"Login Berhasil",Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(LoginActivity.this,MainActivity.class);
                            intent.putExtra("username",json.getJSONObject("data").getString("username"));
                            intent.putExtra("email",json.getJSONObject("data").getString("email"));
                            startActivity(intent);
                            finish();
                            pd.dismiss();
                        }
                        else{
                            pd.dismiss();
                            AlertDialog.Builder msg = new AlertDialog.Builder(LoginActivity.this);
                            msg.setMessage("Status User Ini Tidak Aktif").setNegativeButton("retry",null).create().show();
                        }
                    }else{
                        pd.dismiss();
                        AlertDialog.Builder msg = new AlertDialog.Builder(LoginActivity.this);
                        msg.setMessage("Username atau Password Salah").setNegativeButton("retry",null).create().show();
                    }
                }catch (JSONException | IOException e){
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                Log.i("Info Load", "Load Gagal"+t.toString());
            }
        });
    }
}