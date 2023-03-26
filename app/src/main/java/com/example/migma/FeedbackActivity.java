package com.example.migma;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

public class FeedbackActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feedback);

        EditText editText = findViewById(R.id.ET1);

        Button submitBtn = findViewById(R.id.submitBtn);
        submitBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                String value = editText.getText().toString();
                if (!value.trim().isEmpty()) {
                    Intent intent = new Intent(FeedbackActivity.this, SuccessfulPage.class);
                    startActivity(intent);
                }
            }
        });
    }
}
