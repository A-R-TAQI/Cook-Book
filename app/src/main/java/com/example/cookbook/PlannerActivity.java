package com.example.cookbook;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import com.example.cookbook.databinding.ActivityPlannerBinding;
import com.example.cookbook.databinding.ActivityUserBinding;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class PlannerActivity extends AppCompatActivity {
    private ActivityPlannerBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityPlannerBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottomNavigation);
        bottomNavigationView.setSelectedItemId(R.id.planner); // Set the selected menu item
        binding.bottomNavigation.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                // Determine which activity to launch based on the selected item

                if (item.getItemId() == R.id.home) {
                    startActivity(new Intent(PlannerActivity.this, HomeActivity.class));
                    overridePendingTransition(R.transition.slide_in_right, R.transition.slide_out_left);
                    finish();
                    return true;
                } else if (item.getItemId() == R.id.search) {
                    startActivity(new Intent(PlannerActivity.this, SearchActivity.class));
                    overridePendingTransition(R.transition.slide_in_right, R.transition.slide_out_left);
                    finish();
                    return true;
                } else if (item.getItemId() == R.id.profile) {
                    startActivity(new Intent(PlannerActivity.this, UserActivity.class));
                    overridePendingTransition(R.transition.slide_in_right, R.transition.slide_out_left);
                    finish();
                    return true;
                }
                return false;
            }
        });
    }
}