package com.example.migma;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

public class VerifyICPage extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_verify_icpage);

        ImageView back = findViewById(R.id.back_IV);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        Button btn = findViewById(R.id.scan_btn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ProgressBar pb = findViewById(R.id.pbHorizontal);
                TextView tv = findViewById(R.id.comparing_text);
                pb.setVisibility(View.VISIBLE);
                tv.setVisibility(View.VISIBLE);
                btn.setVisibility(View.GONE);

                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            Thread.sleep(1500);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        Intent intent = new Intent(VerifyICPage.this,VotingPage.class);
                        startActivity(intent);
                    }
                }).start();


            }
        });
    }


}