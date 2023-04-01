package com.example.migma.adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.migma.R;
import com.example.migma.entity.FaqModel;
import com.example.migma.entity.NotificationModel;
import com.example.migma.entity.User;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.storage.FileDownloadTask;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FaqAdapter extends RecyclerView.Adapter<FaqAdapter.MyViewHolder>{

    private Context context;
    private String user_id;
    private List<FaqModel> FaqList;

    @NonNull
    @Override
    public FaqAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.feedback_row,parent,false);
        return new FaqAdapter.MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull FaqAdapter.MyViewHolder holder, int position) {
        FaqModel faqModel = FaqList.get(position);
        StorageReference storageReference = FirebaseStorage.getInstance().getReference("images/"+faqModel.getUid());
        try {
            File localfile = File.createTempFile("Temp File", ".jpg");
            storageReference.getFile(localfile)
                    .addOnCompleteListener(new OnCompleteListener<FileDownloadTask.TaskSnapshot>() {
                        @Override
                        public void onComplete(@NonNull Task<FileDownloadTask.TaskSnapshot> task) {

                            Bitmap bitmap = BitmapFactory.decodeFile(localfile.getAbsolutePath());
                            holder.profile.setImageBitmap(bitmap);
                        }
                    }).addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {

                        }
                    });
        } catch (IOException exception) {
            exception.printStackTrace();
        }
        holder.feedback_name.setText(faqModel.getProfile_name());
        holder.feedback_details.setText(faqModel.getFeedback_details());
        holder.ratings.setText(Double.toString(faqModel.getProfile_rating())+"/ 5.0");

    }

    @Override
    public int getItemCount() {
        return FaqList.size();
    }

    public FaqAdapter(Context context){
        this.context=context;
        FaqList=new ArrayList<>();
    }

    public FaqAdapter(){
        this.context=context;
        FaqList=new ArrayList<>();
    }

    public void add(FaqModel faqModel){
        FaqList.add(faqModel);
        notifyDataSetChanged();
    }

    public void clear(){
        FaqList.clear();
        notifyDataSetChanged();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        private RelativeLayout content;
        private TextView feedback_details;
        private TextView feedback_name;
        private TextView ratings;
        private ImageView profile;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            feedback_name = itemView.findViewById(R.id.name_feedback);
            content = itemView.findViewById(R.id.feedback_content);
            feedback_details = itemView.findViewById(R.id.feedback_details);
            ratings = itemView.findViewById(R.id.ratingText);
            profile = itemView.findViewById(R.id.feedback_profile);
        }
    }
}


