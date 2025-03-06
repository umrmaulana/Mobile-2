package com.example.mobile2.latihan;

import android.os.Bundle;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mobile2.R;
import com.example.mobile2.adapter.AdapterProduct21;
import com.example.mobile2.adapter.ProductResponse;
import com.example.mobile2.api.ProductAPI;
import com.example.mobile2.api.ServerAPI;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Latih2_1 extends AppCompatActivity {
    public static final String URL = new ServerAPI().BASE_URL;
    private RecyclerView recyclerView;
    private AdapterProduct21 adapter;
    private List<Product11> product11List;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_latih21);
        getSupportActionBar().hide();
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        recyclerView = findViewById(R.id.recyclerView);
        GridLayoutManager layoutManager = new GridLayoutManager(this, 2);
        recyclerView.setLayoutManager(layoutManager);
        product11List = new ArrayList<>();
        adapter = new AdapterProduct21(this, product11List);
        recyclerView.setAdapter(adapter);

        fetchProducts();
    }
    private void fetchProducts() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        ProductAPI apiService = retrofit.create(ProductAPI.class);
        Call<ProductResponse> call = apiService.getProducts();

        call.enqueue(new Callback<ProductResponse>() {
            @Override
            public void onResponse(Call<ProductResponse> call, Response<ProductResponse> response) {
                if (response.isSuccessful() && response.body() != null) {
                    if (response.body().getResult() != null) {
                        product11List.clear();
                        product11List.addAll(response.body().getResult());
                        adapter.notifyDataSetChanged();
                    } else {
                        Toast.makeText(Latih2_1.this, "Data tidak tersedia", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(Latih2_1.this, "Failed to fetch data", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<ProductResponse> call, Throwable t) {
                t.printStackTrace();
                Toast.makeText(Latih2_1.this, "Network error: " + t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    public static class Product11 {
        private String merk;
        private String hargabeli;
        private String stok;
        private String foto;

        public Product11(String merk, String hargabeli, String stok, String foto) {
            this.merk = merk;
            this.hargabeli = hargabeli;
            this.stok = stok;
            this.foto = foto;
        }

        public String getMerk() {
            return merk;
        }

        public String getHargaBeli() {
            return hargabeli;
        }

        public String getStok() {
            return stok;
        }

        public String getFoto() {
            return foto;
        }
    }
}