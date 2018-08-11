package com.example.arhamakbar.andamovie.Activities.Home;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.arhamakbar.andamovie.Activities.Home.dummy.DummyContent;
import com.example.arhamakbar.andamovie.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.example.arhamakbar.andamovie.Models.UserProfile;

import org.w3c.dom.Text;

import java.util.HashMap;

public class HomeActivity extends AppCompatActivity implements MovieFragment.OnListFragmentInteractionListener {

    Context context;

    FragmentManager fragmentManager;
    FragmentTransaction fragmentTransaction;

    // Creates variable to be used to connect test button from activity_home.xml to this file
    private Button mTestButton;

    // Creates an instance of this database
    private DatabaseReference mDatabase;

    // Variables to be connected to user's data
    private EditText mFirstName;
    private EditText mLastName;
    private EditText mGender;
    private EditText mAge;
    private EditText mZipCode;
    private EditText mNameOfMovie;
    private EditText mFandangoEmail;
    private EditText mFandangoPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        // Connects test button from xml file to this file
        // TODO: Move button to appropriate XML file
        mTestButton = (Button) findViewById(R.id.test_button);

        // Connects this variable to root of firebase database
        mDatabase = FirebaseDatabase.getInstance().getReference();

        // Connecting user profile data to variables
        // TODO: Add EditText views to proper xml file in order to retrieve this data
        // Should we initiate Name of Movie variable when user makes their profil?
        // Also, should we add a gender preference?
        mFirstName = (EditText) findViewById(R.id.first_name);
        mLastName = (EditText) findViewById(R.id.last_name);
        mGender = (EditText) findViewById(R.id.gender);
        mAge = (EditText) findViewById(R.id.age);
        mZipCode = (EditText) findViewById(R.id.zip_code);
        mFandangoEmail= (EditText) findViewById(R.id.fandango_movie);
        mFandangoPassword = (EditText) findViewById(R.id.fandango_password);

        // Clicking the button results in data being stored to the database
        mTestButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Create child in root object
                // Assign some value to child object (User Profile data)

                String first_name = mFirstName.getText().toString().trim();
                String last_name = mLastName.getText().toString().trim();
                String gender = mGender.getText().toString().trim();
                String ageValue = mAge.getText().toString().trim();
                int age = Integer.parseInt((ageValue);
                String zip_code = mZipCode.getText().toString().trim();
                String fandango_email = mFandangoEmail.getText().toString().trim();
                String fandango_password = mFandangoPassword.getText().toString().trim();

                // Take all input and stores into an object to store to database
                HashMap<String, String, String, int, String, String, String, String> userData = new HashMap<String, String, String, int, String, String, String, String>();
                userData.put("First Name": first_name);
                userData.put("Last Name": last_name);
                userData.put("Gender": gender);
                userData.put("Age": age);
                userData.put("Zip Code": zip_code);
                userData.put("Fandango Email": fandango_email);
                userData.put("Fandango Password": fandango_password);

                // Pushes user info into the database as an object. Also checks if action was successful
                mDatabase.push().setValue(userData).addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if(task.isSuccessful()) {
                            Toast.makeText(HomeActivity.this, "Sign Up Successful!", Toast.LENGTH_LONG).show();
                        } else {
                            Toast.makeText(HomeActivity.this, "Something's Wrong", Toast.LENGTH_LONG).show();
                        }
                    }
                });
            }
        });

    // May not need this
	// TODO: Might have to move this to another activity
        UserProfile bob = new UserProfile("Bob", "Smith", "Male", 20, "11121", "Mulan", "bob@gmail.com", "bob123");

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
