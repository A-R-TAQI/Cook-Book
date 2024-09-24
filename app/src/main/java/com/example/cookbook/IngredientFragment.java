package com.example.cookbook;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class IngredientFragment extends Fragment {

    private TextView mIngredientsTextView;
    private String mIngredients;

    public IngredientFragment(String ingredients) {
        mIngredients = ingredients;
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_ingredient, container, false);
        mIngredientsTextView = view.findViewById(R.id.ingredientsTextView);

        // Set the ingredients text in the TextView
        mIngredientsTextView.setText(mIngredients);

        return view;
    }
}