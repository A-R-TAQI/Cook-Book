package com.example.cookbook;



import java.util.List;

public class Recipes{
    private String title;
    private String ingredients;
    private String directions;

    private String preparation;
    private String cook;
    private String total;
    private String make;

    private String cuisine;

    private String diet;

    private String recipeMethodTitle;
    private int photoResId; // Resource ID of the recipe photo

    public Recipes(String title, String ingredients,String recipeMethodTitle ,String directions, int photoResId,String preparation,String cook,String total,String make,String cuisine,String diet) {
        this.title = title;
        this.ingredients = ingredients;
        this.recipeMethodTitle = recipeMethodTitle;
        this.directions = directions;
        this.photoResId = photoResId;
        this.preparation=preparation;
        this.cook=cook;
        this.total=total;
        this.make=make;
        this.cuisine=cuisine;
        this.diet=diet;
    }

    public String getTitle() {
        return title;
    }

    public String getIngredients() {
        return ingredients;
    }
    public String getRecipeMethodTitle() {return recipeMethodTitle;}
    public String getDirections() {
        return directions;
    }

    public int getPhotoResId() {
        return photoResId;
    }

    public String getPreparation() {return preparation;}

    public String getCook() {return cook;}

    public String getTotal() {return total;}

    public String getMake() {return make;}

    public String getCuisine() {
        return cuisine;
    }

    public String getDiet() {
        return diet;
    }
}