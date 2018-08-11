package com.example.arhamakbar.andamovie.Activities.Home;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.arhamakbar.andamovie.R;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.example.arhamakbar.andamovie.Models.UserProfile;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        UserProfile bob = new UserProfile("Bob", "Smith", "Male", 20, "11121", "bob@gmail.com", "bob123");

        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference();

        myRef.setValue(bob);

    }

}
