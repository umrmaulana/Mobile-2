package com.example.mobile2;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.mobile2.databinding.ActivityMainBinding;
import com.example.mobile2.fragment.HomeFragment;
import com.example.mobile2.fragment.IdentitasFragment;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding binding;
    @SuppressLint("NonConstantResourceId")
    String username, nama, foto, password, status, email;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        Intent intent = getIntent();
        if (intent != null) {
            username = intent.getStringExtra("username");
            nama = intent.getStringExtra("nama");
            foto = intent.getStringExtra("foto");
            password = intent.getStringExtra("password");
            status = intent.getStringExtra("status");
            email = intent.getStringExtra("email");
        }
        replaceFragment(new HomeFragment(), username, email, nama, foto, password, status);

        binding.bottomNavigationView.setOnItemSelectedListener(item -> {
            if (item.getItemId() == R.id.home) {
                replaceFragment(new HomeFragment(), username, email, nama, foto, password, status);
            } else if (item.getItemId() == R.id.profile) {
                replaceFragment(new IdentitasFragment(), username, email, nama, foto, password, status);
            }
            return true;
        });
    }

    public void replaceFragment(Fragment fragment, String username, String email, String nama, String foto, String password, String status) {
        Bundle bundle = new Bundle();
        bundle.putString("username", username);
        bundle.putString("nama", nama);
        bundle.putString("foto", foto);
        bundle.putString("password", password);
        bundle.putString("status", status);
        bundle.putString("email", email);
        fragment.setArguments(bundle);

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.fragmentContainerView, fragment);
        fragmentTransaction.commit();
    }
}