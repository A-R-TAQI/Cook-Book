package com.example.cookbook;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;

public class RecipeActivity extends AppCompatActivity {

    private TextView mPrepIn;
    private TextView mCookIn;
    private TextView mTotalIn;
    private TextView mMakes;
    private TextView mRecipeName;
    private ImageView mRecipeImage;
    private TextView mCuisine;
    private TextView mDiet;

    private TabLayout tabLayout;
    private ViewPager viewPager;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipe);

        tabLayout = findViewById(R.id.tabLayout);
        viewPager = findViewById(R.id.viewPager);

        tabLayout.setupWithViewPager(viewPager);

        Intent intent = getIntent();
        String Title = intent.getExtras().getString("RecipeName");
        String Ingredients = intent.getExtras().getString("RecipeIngredients");
        String MethodTitle = intent.getExtras().getString("RecipeMethodTitle");
        String Recipe = intent.getExtras().getString("Recipe");
        String Prep =intent.getExtras().getString("Prep");
        String Cook =intent.getExtras().getString("Cook");
        String Total =intent.getExtras().getString("Total");
        String Make =intent.getExtras().getString("Make");
        String Cuisine=intent.getExtras().getString("Cuisine");
        String Diet=intent.getExtras().getString("Diet");


        int RecipeImage = intent.getExtras().getInt("Thumbnail");


        mRecipeName = findViewById(R.id.titleTextView);
        mRecipeImage = findViewById(R.id.photoImageView);
        mPrepIn=findViewById(R.id.prepsin);
        mCookIn=findViewById(R.id.cooksin);
        mTotalIn=findViewById(R.id.totalin);
        mMakes=findViewById(R.id.makesin);
        mCuisine=findViewById(R.id.Cuisine);
        mDiet=findViewById(R.id.Diet);


        mRecipeName.setText(Title);
        mRecipeImage.setImageResource(RecipeImage);
        mPrepIn.setText(Prep);
        mCookIn.setText(Cook);
        mTotalIn.setText(Total);
        mMakes.setText(Make);
        mCuisine.setText(Cuisine);
        mDiet.setText(Diet);


        VPAdapter vpAdapter = new VPAdapter(getSupportFragmentManager(), FragmentPagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);

        // Create ingredient and method fragments with constructor
        IngredientFragment ingredientFragment = new IngredientFragment(Ingredients);
        MethodFragment methodFragment = new MethodFragment(Recipe);

        // Add the fragments to the adapter
        vpAdapter.addFragment(ingredientFragment, "Ingredients");
        vpAdapter.addFragment(methodFragment, "Method");

        viewPager.setAdapter(vpAdapter);
        tabLayout.setupWithViewPager(viewPager);
    }
}
