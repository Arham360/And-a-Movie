package com.example.arhamakbar.andamovie.Activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.airbnb.lottie.LottieAnimationView;
import com.example.arhamakbar.andamovie.Activities.Home.HomeActivity;
import com.example.arhamakbar.andamovie.R;

public class Onboarding extends AppCompatActivity {
        LottieAnimationView lottieAnimationView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_onboarding);

        lottieAnimationView = findViewById(R.id.movieAnimation);

        lottieAnimationView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!lottieAnimationView.isAnimating()){
                    lottieAnimationView.playAnimation();
                }else{
                    lottieAnimationView.pauseAnimation();
                }
            }
        });

        findViewById(R.id.logInButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Onboarding.this, HomeActivity.class);
                startActivity(intent);
            }
        });

    }
}
