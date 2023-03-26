package com.example.migma;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

public class VerifyVoucherActivity extends AppCompatActivity {

    private boolean isImage1Showing = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_verify_voucher);

        String[] nameIV = {"IV1", "IV2", "IV3", "IV4"};
        for (int i = 0; i < nameIV.length; i++) {

            String IVname = nameIV[i];
            int resID = getResources().getIdentifier(IVname, "id", getPackageName());

            ImageView imgv = findViewById(resID);

            imgv.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (isImage1Showing) {
                        imgv.setImageResource(R.drawable.fragment_verify_voucher_page_success_icon);
                    } else {
                        imgv.setImageResource(R.drawable.fragment_verify_voucher_page_error_icon);
                    }
                    isImage1Showing = !isImage1Showing;
                }
            });
        }



        Button redeemBtn = findViewById(R.id.RedeemBtn);
        redeemBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                String[] nameIV = {"IV1", "IV2", "IV3", "IV4"};
                Boolean verify = true;

                for (int i = 0; i < nameIV.length; i++) {

                    String IVname = nameIV[i];
                    int resID = getResources().getIdentifier(IVname, "id", getPackageName());

                    ImageView imgv = findViewById(resID);

                    Drawable drawable = getResources().getDrawable(R.drawable.fragment_verify_voucher_page_success_icon);


                    if (imgv.getDrawable() != null && imgv.getDrawable().getConstantState() != null && imgv.getDrawable().getConstantState().equals(drawable.getConstantState())) {
                        verify = true;
                    } else {
                        verify = false;
                    }
                }

                if (verify) {
                    AlertDialog.Builder builder = new AlertDialog.Builder(VerifyVoucherActivity.this);
                    builder.setTitle("Migma");
                    builder.setMessage("Successful");
                    builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            Intent intent = new Intent(VerifyVoucherActivity.this, MainActivity.class);
                            startActivity(intent);
                        }
                    });
                    AlertDialog dialog = builder.create();
                    dialog.show();

                } else {
                    AlertDialog.Builder builder = new AlertDialog.Builder(VerifyVoucherActivity.this);
                    builder.setTitle("Migma");
                    builder.setMessage("Please check again, make sure all the steps are successful!");
                    builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            return;
                        }
                    });
                    AlertDialog dialog = builder.create();
                    dialog.show();
                }
            }
        });
    }
}