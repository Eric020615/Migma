package com.example.migma;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.migma.adapter.FaqAdapter;
import com.example.migma.entity.FaqModel;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class performance_fragment extends Fragment {

    private View root;

    public performance_fragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        root = inflater.inflate(R.layout.fragment_performance, container, false);
        DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReferenceFromUrl("https://migma-2f57a-default-rtdb.firebaseio.com/");
        DatabaseReference checking = FirebaseDatabase.getInstance().getReferenceFromUrl("https://migma-2f57a-default-rtdb.firebaseio.com/");
        RecyclerView feedback = root.findViewById(R.id.feedback_recyclerview);
        FaqAdapter faqAdapter = new FaqAdapter(getContext());
        feedback.setLayoutManager(new LinearLayoutManager(getContext()));

        databaseReference.child("Feedback").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                faqAdapter.clear();
                for (DataSnapshot dataSnapshot : snapshot.getChildren()) {
                    FaqModel faqModel = dataSnapshot.getValue(FaqModel.class);
                    faqAdapter.add(faqModel);
                }
                feedback.setAdapter(faqAdapter);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });


        return root;
    }
}