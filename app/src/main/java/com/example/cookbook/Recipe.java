package com.example.cookbook;

public class Recipe {
    private String title;
    private String cuisine;
    private String diet;
    private String prepsIn;
    private String cooksIn;
    private String totalIn;
    private String makes;

    public Recipe() {
        // Required empty constructor for Firebase
    }

    public Recipe(String title, String cuisine, String diet, String prepsIn, String cooksIn, String totalIn, String makes) {
        this.title = title;
        this.cuisine = cuisine;
        this.diet = diet;
        this.prepsIn = prepsIn;
        this.cooksIn = cooksIn;
        this.totalIn = totalIn;
        this.makes = makes;
    }

    // Add getters and setters as needed

    public String getTitle() {
        return title;
    }

    public String getCuisine() {
        return cuisine;
    }

    public String getDiet() {
        return diet;
    }

    public String getPrepsIn() {
        return prepsIn;
    }

    public String getCooksIn() {
        return cooksIn;
    }

    public String getTotalIn() {
        return totalIn;
    }

    public String getMakes() {
        return makes;
    }
}
