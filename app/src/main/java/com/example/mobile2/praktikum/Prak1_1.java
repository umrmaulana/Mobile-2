package com.example.mobile2.praktikum;

import android.os.Bundle;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.Rotate;
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions;
import com.bumptech.glide.request.RequestOptions;
import com.example.mobile2.R;

public class Prak1_1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_prak11);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        ImageView imageView = (ImageView) findViewById(R.id.imageView);
        Glide.with(this)
                .load("https://upload.wikimedia.org/wikipedia/commons/9/98/Logo_udinus1.jpg")
                .error(R.drawable.ic_launcher_background)
                .circleCrop()
                .apply(new RequestOptions().transform(new Rotate(180)))
                .apply(new RequestOptions().override(500,500))
                .transition(DrawableTransitionOptions.withCrossFade(5000))
                .into(imageView);
    }
}