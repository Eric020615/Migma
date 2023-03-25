package com.example.migma;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class VotingPage extends AppCompatActivity implements View.OnClickListener {

    private static ImageView current_pressed;
    private ImageView box1, box2, box3, box4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_voting_page);

        box1 = findViewById(R.id.box1);
        box2 = findViewById(R.id.box2);
        box3 = findViewById(R.id.box3);
        box4 = findViewById(R.id.box4);

        box1.setOnClickListener(this);
        box2.setOnClickListener(this);
        box3.setOnClickListener(this);
        box4.setOnClickListener(this);

        Button submit_btn = findViewById(R.id.submit_btn);
        submit_btn.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.box1:
                if (current_pressed != null) {
                    current_pressed.setSelected(false);
                }
                current_pressed = box1;
                box1.setSelected(true);
                break;
            case R.id.box2:

                if (current_pressed != null) {
                    current_pressed.setSelected(false);
                }
                current_pressed = box2;
                box2.setSelected(true);
                break;
            case R.id.box3:
                if (current_pressed != null) {
                    current_pressed.setSelected(false);
                }
                current_pressed = box3;
                box3.setSelected(true);
                break;
            case R.id.box4:
                if (current_pressed != null) {
                    current_pressed.setSelected(false);
                }
                current_pressed = box4;
                box4.setSelected(true);
                break;
            case R.id.submit_btn:
                Intent intent = new Intent(VotingPage.this,SuccessfulPage.class);
                startActivity(intent);
        }
    }
}