package com.example.cookbook;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.cookbook.databinding.ActivitySearchBinding;
import com.example.cookbook.databinding.ActivityUserBinding;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.squareup.picasso.Picasso;

public class UserActivity extends AppCompatActivity {
    private ActivityUserBinding binding;
    private TextView userNameTextView;
    private ImageView profileImageView;
    private Button btn;

    private Button CreateBtn,saveRecipe;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        binding = ActivityUserBinding.inflate(getLayoutInflater());
        super.onCreate(savedInstanceState);
        setContentView(binding.getRoot());
        setContentView(R.layout.activity_user);
        userNameTextView = findViewById(R.id.userNameTextView);
        profileImageView = findViewById(R.id.profileImageView);
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottomNavigation);
        bottomNavigationView.setSelectedItemId(R.id.profile);
        FirebaseAuth firebaseAuth = FirebaseAuth.getInstance();
        FirebaseUser user = firebaseAuth.getCurrentUser();

        if (user != null) {
            userNameTextView.setText(user.getDisplayName());
            Glide.with(this)
                    .load(user.getPhotoUrl())
                    .circleCrop()
                    .into(profileImageView);
        }

        CreateBtn=findViewById(R.id.createRecipe);
        CreateBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(UserActivity.this, CreateActivity.class);
                startActivity(intent);
            }
        });
        btn=findViewById(R.id.button);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FirebaseAuth.getInstance().signOut();
                Intent i=new Intent(UserActivity.this,SigninActivity.class);
                startActivity(i);
            }
        });
        saveRecipe=findViewById(R.id.savedRecipe);
        saveRecipe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(UserActivity.this, SaveActivity.class);
                startActivity(intent);
            }
        });


        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                if (item.getItemId() == R.id.home) {
                    startActivity(new Intent(UserActivity.this, HomeActivity.class));
                    overridePendingTransition(R.transition.slide_in_right, R.transition.slide_out_left);
                    finish();
                    return true;
                } else if (item.getItemId() == R.id.search) {
                    startActivity(new Intent(UserActivity.this, SearchActivity.class));
                    overridePendingTransition(R.transition.slide_in_right, R.transition.slide_out_left);
                    finish();
                    return true;
                } else if (item.getItemId() == R.id.planner) {
                    startActivity(new Intent(UserActivity.this, PlannerActivity.class));
                    overridePendingTransition(R.transition.slide_in_right, R.transition.slide_out_left);
                    finish();
                    return true;
                }
                return false;
            }
        });
    }
}
