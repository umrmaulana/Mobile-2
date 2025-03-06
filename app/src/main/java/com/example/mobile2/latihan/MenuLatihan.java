package com.example.mobile2.latihan;

import android.content.Intent;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.activity.OnBackPressedCallback;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mobile2.MainActivity;
import com.example.mobile2.R;
import com.example.mobile2.adapter.AdapterLatihan;
import com.example.mobile2.praktikum.MenuPraktikum;

import java.util.ArrayList;
import java.util.List;

public class MenuLatihan extends AppCompatActivity {
    RecyclerView recyclerView;
    List<ModelLatihan> latihanList;
    AdapterLatihan adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_menu_latihan);
        getSupportActionBar().hide();
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        getOnBackPressedDispatcher().addCallback(this, new OnBackPressedCallback(true) {
            @Override
            public void handleOnBackPressed() {
                Intent intent = new Intent(MenuLatihan.this, MainActivity.class);
                startActivity(intent);
            }
        });
        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new GridLayoutManager(this, 2));
        latihanList = new ArrayList<>();
        latihanList.add(new ModelLatihan("Latihan 1.1", "Product Retrofit", ProductRetrofit.class));
        latihanList.add(new ModelLatihan("Latihan 1.2", "Product API", ProductRetrofit.class));
        latihanList.add(new ModelLatihan("Latihan 1.3", "JSON Parsing", ProductRetrofit.class));
        latihanList.add(new ModelLatihan("Latihan 1.4", "CRUD Retrofit", ProductRetrofit.class));

        adapter = new AdapterLatihan(this, latihanList);
        recyclerView.setAdapter(adapter);
    }
}