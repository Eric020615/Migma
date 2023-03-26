package com.example.migma;

import static com.example.migma.R.id.biglinearLayout;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

public class MedicalHomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_medical_home);

        LinearLayout linearLayout = findViewById(biglinearLayout);
        linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MedicalHomeActivity.this, MedicalRecordActivity.class);
                startActivity(intent);
            }
        });
    }
}