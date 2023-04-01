package com.example.migma;

import static com.example.migma.R.id.biglinearLayout;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

public class SuccessfulPage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_successful_page);

        Button buttonnext = findViewById(R.id.back_home_btn);
        buttonnext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SuccessfulPage.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}