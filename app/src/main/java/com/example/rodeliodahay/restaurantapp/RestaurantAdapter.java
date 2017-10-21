package com.example.rodeliodahay.restaurantapp;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by RodelioDahay on 4/8/17.
 */

class RestaurantAdapter extends BaseAdapter {

    private Activity activity;
    private ArrayList<Restaurant> restaurantArrayList;
    private LayoutInflater inflater;

    RestaurantAdapter(Activity activity, ArrayList<Restaurant> restaurantArrayList){
        this.activity = activity;
        this.restaurantArrayList = restaurantArrayList;
    }

    @Override
    public int getCount() {
        return this.restaurantArrayList.size();
    }

    @Override
    public Restaurant getItem(int position) {
        return this.restaurantArrayList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup viewGroup) {

        if (inflater == null)
            inflater = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        if (convertView == null)
            convertView = inflater.inflate(R.layout.restaurant_list_item, null);

        TextView rest_name = (TextView) convertView.findViewById(R.id.rest_nameTextView);
        TextView recommended_dishes = (TextView) convertView.findViewById(R.id.recommended_dishesTextView);
        TextView cuisine = (TextView) convertView.findViewById(R.id.cuisineTextView);
        TextView ave_price = (TextView) convertView.findViewById(R.id.ave_priceTextView);
        ImageView image = (ImageView) convertView.findViewById(R.id.thumbnailImageView);
        //TextView phone = (TextView) convertView.findViewById(R.id.callTextView);

        final Restaurant restaurant = getItem(position);
        rest_name.setText(restaurant.getRest_name());

        // cut the character if less 70 char
        if (restaurant.getRecommended_dishes().length() <= 70){

            recommended_dishes.setText(restaurant.getRecommended_dishes());

        }else {

            recommended_dishes.setText(restaurant.getRecommended_dishes().substring(0, 70) + "...");
        }

        cuisine.setText(restaurant.getCuisine());
        ave_price.setText("Avg. Price " + restaurant.getAve_price());

        // third party for image downloading and catching
        Picasso.with(activity.getApplicationContext()).load(restaurant.getImage()).into(image);

        //phone.setText(restaurant.getPhone());

        // when restaurant app clicked it goes to class RestaurantDetailsActivity
        convertView.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(activity, RestaurantDetailsActivity.class);

                // pass the data from activity to another activity
                // pass the data to intent object and get data into another activity

                intent.putExtra("rest_name", restaurant.getRest_name());
                intent.putExtra("recommended_dishes", restaurant.getRecommended_dishes());
                intent.putExtra("cuisine", restaurant.getCuisine());
                intent.putExtra("ave_price", restaurant.getAve_price());
                intent.putExtra("ImageView", restaurant.getImage());
                intent.putExtra("phone", restaurant.getPhone());
                intent.putExtra("email", restaurant.getEmail());

                //initiate the data
                activity.startActivity(intent);
            }

        });

        return convertView;
    }
}
