package com.example.rodeliodahay.restaurantapp;

import android.os.Bundle;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.SearchView;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    ArrayList<Restaurant> restaurantArrayList;
    RestaurantAdapter adapter;

    Restaurant[] restaurants = new Restaurant[] {
            new Restaurant(
                    "Billy Bombers",
                    "All Star Burger, Strawberry Milkshake",
                    "American",
                    30,
                    "http://www.dash-off.com/android-assignment/american-01A.jpg",
                    "6596496517",
                    "odedahay@yahoo.com"

            ),
            new Restaurant(
                    "Mortons",
                    "Ribeye Steak, Crab Cake",
                    "American",
                    150,
                    "http://www.dash-off.com/android-assignment/american-02A.jpg",
                    "6596496519",
                    "odedahay@gmail.com"
            ),
            new Restaurant(
                    "Etna",
                    "Lasagna Tradizionale Emilana, Risotto al Fegato Grasso",
                    "Italian",
                    50,
                    "http://www.dash-off.com/android-assignment/italian-01.jpg",
                    "6596496511",
                    "testemail@yahoo.com"
            ),
            new Restaurant(
                    "Jaan",
                    "Degustation Menu",
                    "French",
                    210,
                    "http://www.dash-off.com/android-assignment/french-01.jpg",
                    "6596496512",
                    "company_email@yahoo.com"
            ),
            new Restaurant(
                    "Fat Cat Bistro",
                    "Thai Red Duck Curry, Tandoori Chicken",
                    "Asian",
                    35,
                    "http://www.dash-off.com/android-assignment/asian-01.jpg",
                    "6596496513",
                    "odedahay1@yahoo.com"
            ),
            new Restaurant(
                    "Sakunthala’s Food Palace",
                    "Chicken Tikka, Fried Squid, Fish Head Curry",
                    "Indian",
                    20,
                    "http://www.dash-off.com/android-assignment/indian-01.jpg",
                    "6596496514",
                    "odedahay2@yahoo.com"
            ),
            new Restaurant(
                    "Folk’s Collective",
                    "Pad Thai Goong, Ice Cream Kati",
                    "Thai",
                    25,
                    "http://www.dash-off.com/android-assignment/thai-01.jpg",
                    "6596496515",
                    "odedahay3@gmail.com"
            ),
            new Restaurant(
                    "Gajalee",
                    "Veg Hariyali Khas, Green Chilli Crab",
                    "Vegetarian",
                    40,
                    "http://www.dash-off.com/android-assignment/thai-02.jpg",
                    "6596496516",
                    "finalname@yahoo.com"
            ),
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Adding Logo for App
//        ActionBar actionBar = getSupportActionBar();
//        if(actionBar != null){
//            actionBar.setDisplayHomeAsUpEnabled(true);
//            actionBar.setDisplayUseLogoEnabled(true);
//            actionBar.setIcon(R.drawable*);
//        }

        restaurantArrayList = new ArrayList<>(Arrays.asList(restaurants));
        adapter = new RestaurantAdapter(this, restaurantArrayList);

        ListView restaurantListView = (ListView) findViewById(R.id.restaurantListView);
        restaurantListView.setAdapter(adapter);
    }

    // Display Search Icon:

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.my_menu, menu);

        MenuItem searchItem = menu.findItem(R.id.app_bar_search);

        // make sure press alt+ enter for see the support v.7
        SearchView searchView = (SearchView) MenuItemCompat.getActionView(searchItem);

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                Log.d("SEARCH", newText);

                restaurantArrayList.clear();

                //search restaurant
                if (newText.equals("")){
                    restaurantArrayList.addAll(Arrays.asList(restaurants));
                }else{

                    // Search Name of Restaurant
                    for(Restaurant restaurant : restaurants){

                        // Search Name of restaurant
                       if( restaurant.getRest_name().toLowerCase().contains(newText.toLowerCase()) ) {

                           restaurantArrayList.add(restaurant);
                           //Toast.makeText(MainActivity.this, "No Restaurant Found", Toast.LENGTH_SHORT).show();

                       }

                       else if (restaurant.getCuisine().toLowerCase().contains( newText.toLowerCase() )) {
                           restaurantArrayList.add(restaurant);
                       }

                    }
                    // show no record if search is empty
                    if (restaurantArrayList.isEmpty()){
                        Toast.makeText(MainActivity.this, "No Restaurant or Cuisine Found in the list", Toast.LENGTH_SHORT).show();
                    }


                }

                adapter.notifyDataSetChanged();


                return false;
            }
        });

        return super.onCreateOptionsMenu(menu);
    }
}