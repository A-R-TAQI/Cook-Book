package com.example.cookbook;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class RecipeAdapter extends RecyclerView.Adapter<RecipeAdapter.MyHolder> {
    private Context mContext;
    List<Recipe> recipe;
    public RecipeAdapter(Context mContext, List<Recipe> mData){

        this.mContext = mContext;
        this.recipe = recipe;
    }
    @NonNull
    @Override
    public MyHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View view ;
        LayoutInflater layoutInflater = LayoutInflater.from(mContext);
        view = layoutInflater.inflate(R.layout.cardview_recipe,viewGroup,false);

        return new MyHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return recipe.size();
    }

    public class MyHolder extends RecyclerView.ViewHolder {
        CardView cardView;
        public MyHolder(@NonNull View itemView) {
            super(itemView);

            cardView = (CardView)itemView.findViewById(R.id.cardview_id);
        }
    }
}
