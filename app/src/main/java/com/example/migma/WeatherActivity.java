package com.example.migma;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.example.migma.databinding.ActivityMainBinding;

public class WeatherActivity extends AppCompatActivity {
    private AlphaAnimation buttonClick = new AlphaAnimation(1F, 0.8F);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weather);

        ImageView backBtn = findViewById(R.id.backButton);
        backBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                v.startAnimation(buttonClick);
                Intent intent = new Intent(WeatherActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });

        LinearLayout linearLayout = findViewById(R.id.linearLayout);
        LinearLayout linearLayout2 = findViewById(R.id.linearLayout2);
        linearLayout.setOrientation(LinearLayout.HORIZONTAL);
        linearLayout2.setOrientation(LinearLayout.HORIZONTAL);

    }
}
