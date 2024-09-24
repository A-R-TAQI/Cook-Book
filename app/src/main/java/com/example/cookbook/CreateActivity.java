package com.example.cookbook;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.cookbook.Recipe;
import com.example.cookbook.databinding.ActivityCreateBinding;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class CreateActivity extends AppCompatActivity {
    ActivityCreateBinding binding;
    Uri imageUri;

    StorageReference storageReference;

    private DatabaseReference databaseRef;

    private EditText title;
    private EditText cuisine;
    private EditText diet;
    private EditText prepsIn;
    private EditText cooksIn;
    private EditText totalIn;
    private EditText makes;

    private Button saveButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create);
//        setContentView(binding.getRoot());

//        binding.selectImageBtn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                selectImage();
//            }
//        });


        // Initialize Firebase Database reference
        databaseRef = FirebaseDatabase.getInstance().getReference().child("recipes");

        title = findViewById(R.id.titleTextView1);
         cuisine = findViewById(R.id.Cuisine1);
         diet = findViewById(R.id.Diet1);
         prepsIn = findViewById(R.id.prepsin1);
         cooksIn = findViewById(R.id.cooksin1);
         totalIn = findViewById(R.id.totalin1);
         makes = findViewById(R.id.makesin);
        saveButton = findViewById(R.id.saveBtn);

        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                insertRecipe();
//                uploadImage();
            }
        });
    }

//    private void uploadImage() {
//
//        SimpleDateFormat formatter = new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss", Locale.CANADA);
//        Date now = new Date();
//        String fileName = formatter.format(now);
//        storageReference = FirebaseStorage.getInstance().getReference("images/" + fileName);
//
//
//        storageReference.putFile(imageUri)
//                .addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
//                    @Override
//                    public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
//                        binding.photoImageView.setImageURI(null);
//                        Toast.makeText(CreateActivity.this, "", Toast.LENGTH_SHORT).show();
//                    }
//                }).addOnFailureListener(new OnFailureListener() {
//                    @Override
//                    public void onFailure(@NonNull Exception e) {
//                        Toast.makeText(CreateActivity.this, "", Toast.LENGTH_SHORT).show();
//                    }
//                });
//
//
//    }

//    private void selectImage() {
//        Intent intent=new Intent();
//        intent.setType("image/*");
//        intent.setAction(Intent.ACTION_GET_CONTENT);
//        startActivityForResult(intent,100);
//
//    }

//    @Override
//    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
//        super.onActivityResult(requestCode, resultCode, data);
//
//        if (requestCode==100 && data != null && data.getData() != null){
//        imageUri=data.getData();
//        binding.photoImageView.setImageURI(imageUri);
//        }
//    }

    private void insertRecipe(){
        String title1 = title.getText().toString();
        String cuisine1 = cuisine.getText().toString();
        String diet1 = diet.getText().toString();
        String prepsIn1 = prepsIn.getText().toString();
        String cooksIn1= cooksIn.getText().toString();
        String totalIn1 = totalIn.getText().toString();
        String makes1 = makes.getText().toString();

        Recipe recipe=new Recipe(title1,cuisine1,diet1,prepsIn1,cooksIn1,totalIn1,makes1);

        databaseRef.push().setValue(recipe);
        Toast.makeText(CreateActivity.this, "Recipe Created", Toast.LENGTH_SHORT).show();
    }
}
