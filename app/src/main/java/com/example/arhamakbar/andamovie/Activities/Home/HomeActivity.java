package com.example.arhamakbar.andamovie.Activities.Home;

import android.content.Context;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.example.arhamakbar.andamovie.Activities.Home.dummy.DummyContent;
import com.example.arhamakbar.andamovie.R;

public class HomeActivity extends AppCompatActivity implements MovieFragment.OnListFragmentInteractionListener {

    Context context;

    FragmentManager fragmentManager;
    FragmentTransaction fragmentTransaction;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        context = this;

        fragmentManager = getSupportFragmentManager();

        fragmentTransaction = fragmentManager.beginTransaction();

        fragmentTransaction.replace(R.id.movieContainer, new MovieFragment());

        fragmentTransaction.commit();

    }

    @Override
    public void onListFragmentInteraction(DummyContent.DummyItem item) {
        Toast.makeText(context, "This is my Toast message!",
                Toast.LENGTH_LONG).show();
    }
}
