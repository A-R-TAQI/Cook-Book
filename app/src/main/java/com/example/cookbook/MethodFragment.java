package com.example.cookbook;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


public class MethodFragment extends Fragment {
    private TextView mMethodTextView;
    private String mMethods;

    public MethodFragment(String methods) {
        mMethods = methods;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_method, container, false);
        mMethodTextView = view.findViewById(R.id.directionsTextView);

        // Set the method text in the TextView
        mMethodTextView.setText(mMethods);

        return view;
    }
}