package com.example.cookbook;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.List;

public class SaveActivity extends AppCompatActivity {
    RecyclerView myrecyclerView;
    RecipeAdapter myAdapter;
    List<Recipe> recipe;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_save);
        myrecyclerView = (RecyclerView)findViewById(R.id.recyclerView_id1);

        myAdapter = new RecipeAdapter(this,recipe);

        myrecyclerView.setLayoutManager(new GridLayoutManager(this,1));

        myrecyclerView.setAdapter(myAdapter);
    }
}