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
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.example.migma.databinding.ActivityMainBinding;

public class MedicalRecordActivity extends AppCompatActivity {
    ActivityMainBinding binding;
    private AlphaAnimation buttonClick = new AlphaAnimation(1F, 0.8F);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_medical_record);

        LinearLayout linearLayout = findViewById(R.id.linearLayout);
        linearLayout.setOrientation(LinearLayout.HORIZONTAL);

        ImageView imgButton = findViewById(R.id.MenuButton);
        imgButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                view.startAnimation(buttonClick);
                Intent intent = new Intent(MedicalRecordActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });

    }
}