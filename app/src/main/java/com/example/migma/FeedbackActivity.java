package com.example.migma;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.Toast;
import java.util.*;

import com.example.migma.entity.FaqModel;
import com.example.migma.entity.User;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class FeedbackActivity extends AppCompatActivity {
    private FirebaseAuth mAuth = FirebaseAuth.getInstance();
    private DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReferenceFromUrl("https://migma-2f57a-default-rtdb.firebaseio.com/");
    private DatabaseReference checking = FirebaseDatabase.getInstance().getReferenceFromUrl("https://migma-2f57a-default-rtdb.firebaseio.com/");
    private float rating_index;
    private String uid = mAuth.getCurrentUser().getUid();
    private User user;
    private String name;
    private String comments;
    private Random r=new Random();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feedback);
        EditText editText = findViewById(R.id.EditText_Feedback);
        RatingBar ratingBar = findViewById(R.id.rating_feedback);
        Button submitBtn = findViewById(R.id.submitBtn);
        ratingBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float v, boolean fromUser) {
                rating_index = v;
                System.out.print(v);
            }
        });
        submitBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                comments = editText.getText().toString();
                System.out.println(rating_index);
                if (!comments.trim().isEmpty()) {
                    databaseReference.child("Users").child(uid).addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot snapshot) {
                            user = snapshot.getValue(User.class);
                            System.out.println(uid);
                        }
                        @Override
                        public void onCancelled(@NonNull DatabaseError error) {
                        }
                    });
                    checking.addListenerForSingleValueEvent(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot snapshot) {
                            String key = "1";
                            FaqModel feedback = new FaqModel(uid, user.username, rating_index, comments);
                            if(snapshot.hasChild("Feedback")){
                                key = String.valueOf(r.nextInt(15000)) ;
                                checking.child("Feedback").child(key).setValue(feedback);
                            }
                            else{
                                checking.child("Feedback").child(key).setValue(feedback);
                            }
                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError error) {

                        }
                    });
                    Intent intent = new Intent(FeedbackActivity.this, SuccessfulPage.class);
                    startActivity(intent);
                    Toast.makeText(FeedbackActivity.this,"Your response will be saved",Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(FeedbackActivity.this,"Please do not leave empty comments",Toast.LENGTH_SHORT).show();
                }
            }
        });


    }
}
