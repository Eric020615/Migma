package com.example.migma;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class AlertDisasterPage extends AppCompatActivity {

    private ImageView alert1;
    private ImageView alert2;
    private ImageView alert3;
    private ImageView alert4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alert_disaster_page);

        Button send_btn = findViewById(R.id.send_location_btn);
        ImageView firstmap = findViewById(R.id.first_map_IV);
        LinearLayout progress = findViewById(R.id.progress_loading);
        Button find_evacuation = findViewById(R.id.find_evacuation_btn);
        find_evacuation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(AlertDisasterPage.this,EvacuationCenterPage.class);
                startActivity(intent);
            }
        });

        ImageView back = findViewById(R.id.back_IV);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        alert1 = findViewById(R.id.alert1);
        alert2 = findViewById(R.id.alert2);
        alert3 = findViewById(R.id.alert3);
        alert4 = findViewById(R.id.alert4);
        send_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                progress.setVisibility(View.VISIBLE);
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                try {
                                    Thread.sleep(500);
                                    progress.setVisibility(View.GONE);
                                    send_btn.setVisibility(View.GONE);
                                    firstmap.setVisibility(View.GONE);
                                } catch (InterruptedException e) {
                                    e.printStackTrace();
                                }
                            }
                        });
                    }
                }).start();
            }

        });
    }

}