package com.example.fragmentexample3;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements IDescriptionInterface{

    private boolean twoPane = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // if we find the second frag in the layout
        // that means we have 2 panes
        if (findViewById(R.id.fragContainer_land_second) != null){
            twoPane = true;
        }
        // loading in whether 1 or 2 frags based on the boolean varialbe
        if (!twoPane){
            loadFragment(new FirstFragment(), R.id.fragContainer_first);
            Button buttonPersonality = findViewById(R.id.button_personality);
            Button buttonHome = findViewById(R.id.button_house);
            //Bundle bundle = new Bundle();
            buttonHome.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    launchActivity(v, SecondActivity.class);
                }
            });
            buttonPersonality.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    launchActivity(v, ThirdActivity.class);
                }
            });
        }
        else {
            Bundle bundle_home = new Bundle();
            SecondFragment secondFragment_house = new SecondFragment();
            bundle_home.putString("house", "house");
            secondFragment_house.setArguments(bundle_home);

            Bundle bundle_personality = new Bundle();
            SecondFragment secondFragment_personality = new SecondFragment();
            bundle_personality.putString("personality", "personality");
            secondFragment_personality.setArguments(bundle_personality);

            loadFragment(new FirstFragment(), R.id.fragContainer_land_first);
            loadFragment(new SecondFragment(), R.id.fragContainer_land_second);
            loadFragment(new SecondFragment(), R.id.fragContainer_land_third);
        }

    }

    public void loadFragment(Fragment fragment, int id){
        FragmentManager fragmentManager = getSupportFragmentManager();
        // create a fragment transaction to begin the transaction and replace the fragment
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        //replacing the placeholder - fragmentContainterView with the fragment that is passed as parameter
        fragmentTransaction.replace(id, fragment);
        fragmentTransaction.commit();
    }

    public void launchActivity(View view, Class clas){
        Intent intent = new Intent(this, clas);
        startActivity(intent);
    }


    @Override
    public String setTitle() {
        // depending on the fragContainer? return either house or personality

        return "Smug";
    }

    @Override
    public String setBody() {
        return getString(R.string.smug);
    }
}