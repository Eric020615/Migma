package com.example.migma;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import androidx.fragment.app.Fragment;

public class HomeFragment extends Fragment{

    private View root;
    private AlphaAnimation buttonClick = new AlphaAnimation(1F, 0.8F);

    public HomeFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        root = inflater.inflate(R.layout.fragment_home, container, false);
        Button myWalletbtn = root.findViewById(R.id.wallet_button);
        Button myfeedbackbtn = root.findViewById(R.id.feedback_button);
        Button myrewardbtn = root.findViewById(R.id.reward_button);
        RelativeLayout myweatherbtn = root.findViewById(R.id.weather_button);



        myWalletbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                view.startAnimation(buttonClick);
                Intent intent = new Intent(getActivity(),EWalletActivity.class);
                startActivity(intent);
            }
        });
        myfeedbackbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                view.startAnimation(buttonClick);
                Intent intent = new Intent(getActivity(),FeedbackActivity.class);
                startActivity(intent);
            }
        });
        myrewardbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                view.startAnimation(buttonClick);
                Intent intent = new Intent(getActivity(),VerifyVoucherActivity.class);
                startActivity(intent);
            }
        });
        myweatherbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                view.startAnimation(buttonClick);
                Intent intent = new Intent(getActivity(),WeatherActivity.class);
                startActivity(intent);
            }
        });

        Button emergency_btn = root.findViewById(R.id.emergency_button);
        emergency_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                view.startAnimation(buttonClick);
                Intent intent = new Intent(getActivity(),AlertDisasterPage.class);
                startActivity(intent);
            }
        });

        ImageView hotspot_disaster = root.findViewById(R.id.hotspot_disaster);
        hotspot_disaster.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                view.startAnimation(buttonClick);
                Intent intent = new Intent(getActivity(),HotspotDisasterPage.class);
                startActivity(intent);
            }
        });


        ImageButton voting = root.findViewById(R.id.voting_btn);
        voting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                view.startAnimation(buttonClick);
                Intent intent = new Intent(getActivity(),VerifyICPage.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
                startActivity(intent);
            }
        });


        return root;
    }
}



