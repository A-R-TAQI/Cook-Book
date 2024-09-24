package com.example.cookbook;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MyHolder> {

    private final Context mContext;
    private List<Recipes> mData;


    public void setFilteredList(List<Recipes> filteredList){
        this.mData = filteredList;
        notifyDataSetChanged();
    }
    public RecyclerViewAdapter(Context mContext, List<Recipes> mData){

        this.mContext = mContext;
        this.mData = mData;
    }



    @NonNull
    @Override
    public MyHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View view ;
        LayoutInflater layoutInflater = LayoutInflater.from(mContext);
        view = layoutInflater.inflate(R.layout.cardview_recipe,viewGroup,false);
        return  new MyHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final MyHolder myHolder, @SuppressLint("RecyclerView") final int i) {

        myHolder.recipeTitle.setText(mData.get(i).getTitle());
        myHolder.img_recipe_thumbnail.setImageResource(mData.get(i).getPhotoResId());
        myHolder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mContext,RecipeActivity.class);

                intent.putExtra("RecipeName",mData.get(i).getTitle());
                intent.putExtra("RecipeIngredients",mData.get(i).getIngredients());
                intent.putExtra("RecipeMethodTitle",mData.get(i).getRecipeMethodTitle());
                intent.putExtra("Recipe",mData.get(i).getDirections());
                intent.putExtra("Thumbnail",mData.get(i).getPhotoResId());
                intent.putExtra("Prep",mData.get(i).getPreparation());
                intent.putExtra("Cook",mData.get(i).getCook());
                intent.putExtra("Total",mData.get(i).getTotal());
                intent.putExtra("Make",mData.get(i).getMake());
                intent.putExtra("Cuisine",mData.get(i).getCuisine());
                intent.putExtra("Diet",mData.get(i).getDiet());

                mContext.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public class MyHolder extends RecyclerView.ViewHolder {

        TextView recipeTitle;
        CardView cardView;
        ImageView img_recipe_thumbnail;

        public MyHolder(@NonNull View itemView) {
            super(itemView);

            recipeTitle = (TextView)itemView.findViewById(R.id.recipe_text);
            img_recipe_thumbnail = (ImageView)itemView.findViewById(R.id.recipe_img_id);
            cardView = (CardView)itemView.findViewById(R.id.cardview_id);


        }
    }
}
