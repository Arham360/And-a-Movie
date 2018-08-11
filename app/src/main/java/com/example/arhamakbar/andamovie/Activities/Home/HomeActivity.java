package com.example.arhamakbar.andamovie.Activities.Home;

import android.content.Context;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.example.arhamakbar.andamovie.Activities.Home.dummy.DummyContent;
import com.example.arhamakbar.andamovie.R;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.example.arhamakbar.andamovie.Models.UserProfile;

public class HomeActivity extends AppCompatActivity implements MovieFragment.OnListFragmentInteractionListener {

    Context context;

    FragmentManager fragmentManager;
    FragmentTransaction fragmentTransaction;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

	// TODO: Might have to move this to another activity
        UserProfile bob = new UserProfile("Bob", "Smith", "Male", 20, "11121", "bob@gmail.com", "bob123");

        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference();

        myRef.setValue(bob);
	//-------------------------------------------------

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
