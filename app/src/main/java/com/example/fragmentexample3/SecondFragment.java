package com.example.fragmentexample3;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class SecondFragment extends Fragment {
    private TextView textView_title, textView_body;


    View view;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_second, container, false);
        textView_title = view.findViewById(R.id.textView_title);
        textView_body = view.findViewById(R.id.textView_body);
        IDescriptionInterface descriptionInterface = (IDescriptionInterface) getActivity();

        String title = descriptionInterface.setTitle();
        String body = descriptionInterface.setBody();

        textView_title.setText(title);
        textView_body.setText(body);


/**
        // unbundle
        if (getArguments().getString("house") != null){
            title.setText("House Information");
            body.setText(R.string.house);
        }
        else if (getArguments().getString("personality") != null){
            title.setText("Smug");
            body.setText(R.string.smug);
        }
 */


        return view;
    }
}
