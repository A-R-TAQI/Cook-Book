package com.example.cookbook;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.widget.SearchView;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.cookbook.R;
import com.example.cookbook.Recipes;
import com.example.cookbook.RecyclerViewAdapter;
import com.example.cookbook.databinding.ActivityHomeBinding;
import com.example.cookbook.databinding.ActivitySearchBinding;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;
import java.util.List;

public class SearchActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private List<Recipes> recipes;
    private RecyclerViewAdapter adapter;
    private ActivitySearchBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySearchBinding.inflate(getLayoutInflater());
        setContentView(R.layout.activity_search);
        setContentView(binding.getRoot());
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottomNavigation);
        bottomNavigationView.setSelectedItemId(R.id.search); // Set the selected menu item

        binding.bottomNavigation.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                if (item.getItemId() == R.id.home) {
                    startActivity(new Intent(SearchActivity.this, HomeActivity.class));
                    overridePendingTransition(R.transition.slide_in_right, R.transition.slide_out_left);
                    finish();
                    return true;
                } else if (item.getItemId() == R.id.profile) {
                    startActivity(new Intent(SearchActivity.this, UserActivity.class));
                    overridePendingTransition(R.transition.slide_in_right, R.transition.slide_out_left);
                    finish();
                    return true;
                } else if (item.getItemId() == R.id.planner) {
                    startActivity(new Intent(SearchActivity.this, PlannerActivity.class));
                    overridePendingTransition(R.transition.slide_in_right, R.transition.slide_out_left);
                    finish();
                    return true;
                }
                return false;
            }
        });

        // Initialize the recipes list (replace with your actual list of recipes)
        recipes = getRecipes();

        recyclerView = findViewById(R.id.recyclerView_id);
        SearchView searchView = findViewById(R.id.searchView);

        // Create an instance of the RecyclerViewAdapter
        adapter = new RecyclerViewAdapter(this, recipes);

        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                // Perform search when the search button or Enter key is pressed
                performSearch(query);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                // Perform search as the text in the search view changes
                // No need to implement this method for your use case
                return false;
            }
        });
    }

    private List<Recipes> getRecipes() {
        // Replace this with your actual implementation to get the list of recipes
        List<Recipes> recipes = new ArrayList<>();
        recipes.add(new Recipes("Prawn Ghee Roast","250 grams Prawns , shelled and deveined\n" +
                "4 Dry Red Chillies\n" +
                "1/2 teaspoon Whole Black Peppercorns\n" +
                "1/2 teaspoon Cumin seeds (Jeera)\n" +
                "1/4 teaspoon Mustard seeds (Rai/ Kadugu)\n" +
                "1/4 Methi Seeds (Fenugreek Seeds)\n" +
                "1/2 teaspoon Coriander (Dhania) Seeds\n" +
                "1/2 Fennel seeds (Saunf)\n" +
                "1 tablespoon Tamarind , soaked in 1/4 cup warm water\n" +
                "1 teaspoon Turmeric powder (Haldi)\n" +
                "2 teaspoon Red Chilli powder\n" +
                "1/4 Cup Curd (Dahi / Yogurt)\n" +
                "1/2 Lemon juice\n" +
                "6 cloves Garlic\n" +
                "2 tablespoons Ghee , plus 1 teaspoon\n" +
                "Salt , as per taste.","Method",
                "1. To begin making the Prawn Ghee Roast recipe, soak the chillies in warm water for 1 hour, drain the water and reserve the chillies.\n" +
                        "\n" +
                        "2. Clean the prawns, wash and pat them dry.\n" +
                        "\n" +
                        "3. Soak tamarind in 1/4 cup warm water for 10 minutes. Once soaked squeeze the tamarind and extract the pulp.\n" +
                        "\n" +
                        "4. Heat a small fry pan, roast the pepper corns, fenugreek, mustard, fennel and cumin, once the spices stop to splutter, switch off the heat. Transfer the spices into a bowl, let it be cool, and grind to make a fine powder.\n" +
                        "\n" +
                        "5. Add the garlic and soaked chillies into a grinder with a splash of water and grind to form a smooth paste.\n" +
                        "\n" +
                        "6. Marinate the prawns with the lime juice, yoghurt, red chilli powder, turmeric and a pinch of salt for 20 minutes.\n" +
                        "\n" +
                        "7. Add 2 tablespoons ghee to a pan, place it on medium flame add the prawns in batches. Fry from both the sides until light brown. Remove the prawns from pan.\n" +
                        "\n" +
                        "8. Add garlic chilies paste into the remaining ghee, fry for 2 minutes, add prawns, roasted dry spice powder, remaining marination masala and salt, mix well and cook until oil gets separated.\n" +
                        "\n" +
                        "9. Add tamarind pulp, curry leaves and cook for 5 minutes on low flame, if required sprinkle some water.\n" +
                        "\n" +
                        "10. Add remaining 1 teaspoon ghee on top, mix and switch off the gas. Transfer the Prawn Ghee Roast into a serving bowl.\n" +
                        "\n" +
                        "11. Serve Prawn Ghee Roast as a side dish along with Mangalorean Style Kuvalyacho Pollav and Steamed Rice for a weekday meal.",
                R.drawable.prawns_ghee_roast_1,"10 M","15 M","25 M","2 Serves","Cuisine : Mangalorean","Diet : Non-Vegetarian"));

        recipes.add(new Recipes("Mangalorean Chana Gassi","1 cup Kabuli Chana (White Chickpeas) , soaked overnight\n" +
                "Salt , to taste\n" +
                "For Masala:\n" +
                "8 Dry Red Chillies\n" +
                "4 cloves Garlic\n" +
                "4 tablespoon Coriander (Dhania) Seeds\n" +
                "1 cup Fresh coconut , grated\n" +
                "1 teaspoon Tamarind Paste\n" +
                "1/2 teaspoon Turmeric powder (Haldi)\n" +
                "Salt , to taste\n" +
                "Water , as needed\n" +
                "For Tempering\n" +
                "1 tablespoon Coconut Oil\n" +
                "1/2 teaspoon Mustard seeds (Rai/ Kadugu)\n" +
                "1/4 teaspoon Methi Seeds (Fenugreek Seeds)\n" +
                "1 pinch Asafoetida (hing)\n" +
                "Curry leaves , a handful\n","",
                "1. To begin making Mangalorean Chana Gassi Recipe, soak Chickpeas overnight and pressure cook with water and salt for about 3 whistles. Prep with other ingredients as well.\n" +
                        "\n" +
                        "2. Drain the excess water and keep the cooked chickpeas aside. In the meanwhile, prepare the masala.\n" +
                        "\n" +
                        "3. To prepare masala, in a kadai, dry roast coriander seeds until the aroma rises from it. Keep aside. In the same pan, dry roast red chillies until crisp for about a minute. Let it cool.\n" +
                        "\n" +
                        "4. Once cooled, add turmeric powder, coconut, garlic, about 1/2 cup water and tamarind paste to it and grind using a mixer to a fine ground paste.\n" +
                        "\n" +
                        "5. Now, in a Kadai, add the ground masala and saute it for about a minute.\n" +
                        "\n" +
                        "6. Add the cooked chickpeas and a cup of water. Cook until the raw smell of the grounded paste goes off. Adjust the amount of water according to your desired consistency. Add a few tablespoon of water to thin out the curry. Season it with salt.\n" +
                        "\n" +
                        "7. In a tadka pan, heat coconut oil. Once the oil is hot, add asafetida, mustard seeds, curry leaves and fenugreek seeds. Let them splutter. Pour the tempering over the curry.\n" +
                        "\n" +
                        "8. Let it rest until it is served. Give a quick stir and Serve Mangalorean Chana Gassi Recipe with Malabari Parotta Without Egg Recipe (Kerala Parotta) or Mangalorean Neer Dosa Recipe (Savory Rice & Coconut Crepe) for lunch.",
                R.drawable.mangalorean_channa_gassi,
                "20 M","15 M","35 M","3 serves","Cuisine : Mangalorean","Diet : Vegetarian"));
        recipes.add(new Recipes("Kori Gassi Recipe - Mangalorean Chicken Curry",
                "500 grams Chicken , cut into pieces\n" +
                        "1 Onions , sliced thin\n" +
                        "1 cup Coconut milk , thin\n" +
                        "1/2 cup Coconut milk , thick\n" +
                        "2 Cloves (Laung)\n" +
                        "1 Bay leaf (tej patta)\n" +
                        "1 inch Cinnamon Stick (Dalchini)\n" +
                        "Salt , to taste\n" +
                        "1 sprig Curry leaves\n" +
                        "2 tablespoons Ghee\n" +
                        "Ingredients For Masala\n" +
                        "1 Onion , chopped\n" +
                        "10 cloves Garlic\n" +
                        "2 inch Ginger\n" +
                        "1 cup Fresh coconut , grated\n" +
                        "1-1/2 tablespoon Coriander (Dhania) Seeds\n" +
                        "8 Dry Red Chillies , or Kashmiri red chili variety\n" +
                        "1-1/2 teaspoon Cumin seeds (Jeera)\n" +
                        "1/4 teaspoon Methi Seeds (Fenugreek Seeds)\n" +
                        "1-1/2 teaspoon Whole Black Peppercorns\n" +
                        "1/2 teaspoon Turmeric powder (Haldi)\n" +
                        "20 grams Tamarind","",
                "1. To start preparing this Mangalorean Kori Gassi recipe, wash the chicken pieces well. Add 1 teaspoon salt, mix well. Cover and let it sit for 15 minutes. Meanwhile, get prep with all the other ingredients.\n" +
                        "\n" +
                        "2. In a Kadai/Pan add 1 teaspoon ghee. Roast coriander seeds, cumin seeds, dried red chilies, peppercorns one by one until fragrant. Once roasted remove from pan and set aside to cool.\n" +
                        "\n" +
                        "3. Once all spices are roasted, into the same pan, add sliced onions, garlic, and ginger and roast until onions start to turn brown.\n" +
                        "\n" +
                        "4. Now add fresh grated coconut tamarind ball, and continue to roast until coconut start to turn golden brown. Remove from pan and set it aside.\n" +
                        "\n" +
                        "5. Once all the roasted spices and onion-coconut mix has cooled, add them all to a blender and blend into smooth paste by adding little water.\n" +
                        "\n" +
                        "6. Now add remaining ghee and saute with the remaining slices till fragrant.dAd sliced onions and sauté for a minute. Add curry leaves, mix well.\n" +
                        "\n" +
                        "7. Add the ground masala paste and cook until oil/ghee separates from the sides of the pan.\n" +
                        "\n" +
                        "8. Add the chicken pieces and give it a good mix to ensure all chicken is coated uniformly with the masala. Cook for 5 minutes with constant stirring.\n" +
                        "\n" +
                        "9. Now add thin coconut milk and salt to taste, bring it to boil Reduce flame to medium, cover and cook until chicken well done.\n" +
                        "\n" +
                        "10. Once chicken is cooked well, add thick coconut milk, reduce to simmer. Wait for a minute or two and turn off the flame. Do not let the curry come to boil again, once you add thick coconut milk, if you boil it the milk will curdle.\n" +
                        "\n" +
                        "11. Break some Kori rotti into a plate. Pour generous amount Kori Gassi (chicken curry) with some chicken pieces over the rotti. Let it soak for 5 to 7 minutes. Enjoy the soggy pieces of Kori rotti with the Kori Gassi like the way it is eaten traditionally!\n" +
                        "\n" +
                        "12. Serve Kori Gassi Recipe as a Sunday meal along with Kori Rotti or Mangalorean Neer Dosa Recipe, and Chicken Ghee Roast Recipe - Chicken Dry Roast Recipe by the side.",
                R.drawable.korirotti,
                "10 M","45 M","55 M","4 serves","Cuisine : Mangalorean","Diet : Non-Vegetarian"));
        recipes.add(new Recipes("Mangalorean Style Ambe Upkari \n",
                "6 Mango (Ripe) , (fibrous smaller variety suits best)\n" +
                        "1/2 cup Jaggery , powdered (adjust to sweetness of mangoes)\n" +
                        "2 Green Chillies , (adjust to taste)\n" +
                        "1 teaspoon Ghee , or coconut oil\n" +
                        "2 Dry Red Chillies\n" +
                        "1/2 teaspoon White Urad Dal (Split)\n" +
                        "1/2 teaspoon Mustard seeds (Rai/ Kadugu)\n" +
                        "1 pinch Asafoetida (hing)\n","",
                "1. To begin making Mangalorean Style Ambe Upkari Recipe, wash mangoes well. Peel the skin with your hands. Some mango pulp will be adhering to the skin; that is ok; it will not go waste.\n" +
                        "\n" +
                        "2. Place the peeled mango in a saucepan and the peels in a bowl.\n" +
                        "\n" +
                        "3. Add water, about 1/4 cup to the bowl with the mango peels, just enough that they are dipped in water.\n" +
                        "\n" +
                        "4. Keep squeezing the peels well in the bowl with your hands to remove the pulp still sticking to it as much as possible.\n" +
                        "\n" +
                        "5. Transfer this water to the saucepan containing the peeled ripe mangoes. Keep repeating (adding more water) until the water is almost clear.\n" +
                        "\n" +
                        "6. Add slit green chillies to the mangoes in the saucepan. Heat on medium heat and bring to a boil.\n" +
                        "\n" +
                        "7. Once it comes to a boil, reduce the heat and simmer for about 10 to 15 minutes until the mangoes are cooked well and become soft; about 15 to 20 minutes.\n" +
                        "\n" +
                        "8. Add jaggery to taste along with some salt; adjust to suit your taste; mix well.\n" +
                        "\n" +
                        "9. Simmer for about 5 minutes or more until you get a good consistency.\n" +
                        "\n" +
                        "10. We love our mango curry a bit diluted; but if you want a thicker gravy, you can add a slurry of rice flour in water (about 2 to 3 teaspoons of rice flour in ¼ cup of water) to the boiling curry and boil until thick.\n" +
                        "\n" +
                        "11. Now, it is time to season or temper the curry.\n" +
                        "\n" +
                        "12. In a small saucepan, heat ghee. Once the ghee is hot, add mustard seeds and when they start to splutter and crackle, add the dry red chillies and hing.\n" +
                        "\n" +
                        "13. Immediately add to the curry and give it a good stir.\n" +
                        "\n" +
                        "14. Sweet, tangy and exotic Konkani style mango curry is ready.\n" +
                        "\n" +
                        "15. Mangalorean Style Ambe Upkari Recipe is usually served as a side dish with a South Indian Meal of Steamed rice, Mangalorean Style Sajjige Rotti, steamed rice, Sprouted Moong Dal Curry and Mangalorean Style Sonay Sukka Recipe (Dry Chickpea Stir Fry Recipe).",
                R.drawable.ambeupkari
                ,"20 M","20 M","40 M","3 serves","Cuisine : Mangalorean","Diet : Vegetarian"));
        recipes.add(new Recipes("Mangalorean Manoli Bheeja Upkari",
                "300 grams Tindora (Dondakaya/ Kovakkai) , (Manoli)\n" +
                        "1/2 cup Cashew nuts , (tender ones), soaked in warm water and salt for 15 minutes\n" +
                        "3 tablespoons Fresh coconut , grated\n" +
                        "1 teaspoon Sugar\n" +
                        "Salt , to taste \n" +
                        "To temper\n" +
                        "2 teaspoons Coconut Oil\n" +
                        "1 teaspoon White Urad Dal (Split)\n" +
                        "1/2 teaspoon Mustard seeds (Rai/ Kadugu)\n" +
                        "3 Dry Red Chillies , broken (adjust to taste)\n" +
                        "1/4 teaspoon Turmeric powder (Haldi)\n" +
                        "Curry leaves , a few","",
                "1. To begin making Mangalorean Manoli Bheeja Upkari Recipe (Ivy Gourd & Cashew Sabzi), soak the cashews in warm water and a little salt for about 10 minutes. Wash the Ivy gourd and cut off the ends. Slit them lengthwise in quarters.\n" +
                        "\n" +
                        "2. Heat oil in a heavy bottomed pan. Once the oil is hot, add mustard seeds and let them splutter.\n" +
                        "\n" +
                        "3. As the mustard splutters, add split black gram and fry till them till it turns golden brown.\n" +
                        "\n" +
                        "4. Break in the dry red chillies into half into the kadai and add curry leaves along.\n" +
                        "\n" +
                        "5. After a few seconds of frying them, add the cashew nuts, slit manoli or ivy gourd and turmeric. Toss the veggies and cashews to mix with the tempering. Keep sauteing for a couple of minutes on medium heat.\n" +
                        "\n" +
                        "6. Add salt , sugar  and about 1/2 cup of water and mix everything well. Now cover and cook in low heat for 15 to 20 minutes or until the ivy gourds are tender. Make sure not to overcook the Tindora though. Both the Tindora and cashew nuts should be soft but slightly crunchy.\n" +
                        "\n" +
                        "7. Add grated coconut and allow all the water to dry up with stirring. Check for salt and adjust spices if needed, allow to sit for a minute and switch off.\n" +
                        "\n" +
                        "8. Serve Mangalorean Manoli Bheeja Upkari Recipe (Ivy Gourd & Cashew Sabzi) with Steamed Rice, Bendekayi Koddel/Bolu Huli Recipe and Aralu Sandige Recipe for lunch.",
                R.drawable.manoli_bheeja,"10 M","20 M","30 M","4 serves","Cuisine : Mangalorean","Diet : Vegetarian"));
        return recipes;
    }

    private void performSearch(String query) {
        List<Recipes> searchResults = searchRecipes(query);
        if (!searchResults.isEmpty()) {
            recyclerView.setVisibility(View.VISIBLE); // Show the RecyclerView if there are search results
            adapter.setFilteredList(searchResults);
        } else {
            recyclerView.setVisibility(View.GONE); // Hide the RecyclerView if there are no search results
            Toast.makeText(SearchActivity.this, "Recipes not found", Toast.LENGTH_SHORT).show();
        }
        adapter.notifyDataSetChanged();
    }



    private List<Recipes> searchRecipes(String query) {
        List<Recipes> searchResults = new ArrayList<>();
        String lowerCaseQuery = query.toLowerCase(); // Convert the query to lowercase for case-insensitive matching
        for (Recipes recipe : recipes) {
            String recipeName = recipe.getTitle().toLowerCase(); // Convert recipe name to lowercase
            String ingredients = recipe.getIngredients().toLowerCase(); // Convert ingredients to lowercase

            if (recipeName.contains(lowerCaseQuery) || ingredients.contains(lowerCaseQuery)) {
                // Check if the recipe name or ingredients contain the query
                searchResults.add(recipe);
            }
        }
        return searchResults;
    }

}
