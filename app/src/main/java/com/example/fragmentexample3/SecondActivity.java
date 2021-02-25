package com.example.fragmentexample3;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

public class SecondActivity extends AppCompatActivity implements IDescriptionInterface{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        /*
        Intent intent = getIntent();
        String category = intent.getStringExtra("category");

        // check to see what kind of button was pressed and set the Bundle accordingly
        Bundle bundle = new Bundle();
        SecondFragment secondFragment = new SecondFragment();
        if (category.contentEquals("house")){
            Log.d("clicked", category);
            bundle.putString("house", String.valueOf(R.string.house));
            secondFragment.setArguments(bundle);
        }
        else if (category.contentEquals("personality")){
            bundle.putString("personality", "personality");
            secondFragment.setArguments(bundle);
        }

         */

        // load fragment 2 into second activity, only happens when its portrait mode
        loadFragment(new SecondFragment(), R.id.fragContainer_second);


    }

    public void loadFragment(Fragment fragment, int id){
        FragmentManager fragmentManager = getSupportFragmentManager();
        // create a fragment transaction to begin the transaction and replace the fragment
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        //replacing the placeholder - fragmentContainterView with the fragment that is passed as parameter
        fragmentTransaction.replace(id, fragment);
        fragmentTransaction.commit();
    }


    @Override
    public String setTitle() {
        return "House Information";
    }

    @Override
    public String setBody() {
        return getString(R.string.house);
    }
}
