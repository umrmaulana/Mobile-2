package com.example.mobile2.praktikum;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.mobile2.R;

public class Prak2_2_Home extends AppCompatActivity {
    TextView tvWelcome;
    Button btnLogout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_prak22_home);
        getSupportActionBar().setTitle("Halaman Depan");
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        tvWelcome = (TextView) findViewById(R.id.tvWelcome);
        btnLogout = (Button) findViewById(R.id.btnLogout);
        String username = getIntent().getStringExtra("username").toString();
        String email = getIntent().getStringExtra("email").toString();
        tvWelcome.setText("Selamat Datang : "+username+" ("+email+")");
        btnLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Prak2_2_Home.this, Prak2_2.class);
                startActivity(intent);
                finish();
            }
        });
    }
}