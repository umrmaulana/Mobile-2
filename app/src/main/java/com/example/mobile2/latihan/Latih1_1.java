package com.example.mobile2.latihan;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mobile2.R;
import com.example.mobile2.adapter.AdapterStudent11;

import java.util.ArrayList;
import java.util.List;

public class Latih1_1 extends AppCompatActivity {
    private RecyclerView recyclerView;
    private AdapterStudent11 adapter;
    private List<Student11> student11List;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_latih11);
        getSupportActionBar().setTitle("Daftar Mahasiswa");
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        student11List = new ArrayList<>();
        student11List.add(new Student11("A22.2021.02859", "Fahaddina Fikroh", "https://i.pinimg.com/736x/5d/ea/c3/5deac3296927862d06e73661c1bb7720.jpg"));
        student11List.add(new Student11("A22.2021.02860", "Rio Ferdinand", "https://i.pinimg.com/736x/5d/ea/c3/5deac3296927862d06e73661c1bb7720.jpg"));
        student11List.add(new Student11("A22.2021.02862", "Aditiya Firyan Syah", "https://i.pinimg.com/736x/57/ad/17/57ad1731e21449527950cfe98c68b012.jpg"));

        adapter = new AdapterStudent11(this, student11List);
        recyclerView.setAdapter(adapter);
    }

    public static class Student11 {
        private String nim;
        private String nama;
        private String imageUrl;

        public Student11(String nim, String nama, String imageUrl) {
            this.nim = nim;
            this.nama = nama;
            this.imageUrl = imageUrl;
        }

        public String getNim() {
            return nim;
        }

        public String getNama() {
            return nama;
        }

        public String getImageUrl() {
            return imageUrl;
        }
    }

}