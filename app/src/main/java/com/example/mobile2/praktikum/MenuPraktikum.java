package com.example.mobile2.praktikum;

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
import com.example.mobile2.adapter.AdapterPraktikum;

import java.util.ArrayList;
import java.util.List;

public class MenuPraktikum extends AppCompatActivity {
    RecyclerView recyclerView;
    List<ModelPraktikum> praktikumList;
    AdapterPraktikum adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_menu_praktikum);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        getOnBackPressedDispatcher().addCallback(this, new OnBackPressedCallback(true) {
            @Override
            public void handleOnBackPressed() {
                Intent intent = new Intent(MenuPraktikum.this, MainActivity.class);
                startActivity(intent);
            }
        });
        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new GridLayoutManager(this, 2));
        praktikumList = new ArrayList<>();
        praktikumList.add(new ModelPraktikum("Praktikum 1.1", "Glide", Prak1_1.class));
        praktikumList.add(new ModelPraktikum("Praktikum 2.1", "Daftar Mahasiswa", Prak2_1.class));
        praktikumList.add(new ModelPraktikum("Praktikum 2.2", "Login Retrofit", Prak2_2.class));
        praktikumList.add(new ModelPraktikum("Praktikum 1.4", "CRUD Retrofit", Prak1_1.class));

        adapter = new AdapterPraktikum(this, praktikumList);
        recyclerView.setAdapter(adapter);
    }
}