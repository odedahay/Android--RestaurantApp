package com.example.rodeliodahay.restaurantapp;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

/**
 * Created by RodelioDahay on 5/8/17.
 */

public class RestaurantDetailsActivity extends AppCompatActivity {

    // Global Variables
    String phoneNumber;
    String emailAdd;
    Button callButton;
    Button emailButton;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // go to restaurant details line
        setContentView(R.layout.restaurant_details);

        // Show Arrow back
        ActionBar actionbar = getSupportActionBar();

        if (actionbar != null){

            actionbar.setDisplayHomeAsUpEnabled(true);

        }

        final Intent intent = getIntent();

        callButton = (Button) findViewById(R.id.buttonViewCall);
        emailButton = (Button) findViewById(R.id.buttonViewEmail);

        // retrieve the data from Restaurant Adapter
        String restaurantName = intent.getStringExtra("rest_name");
        String recommendedDishes = intent.getStringExtra("recommended_dishes");
        String cuisineName = intent.getStringExtra("cuisine");
        int avePrice = intent.getIntExtra("ave_price", 0);
        String mainImage = intent.getStringExtra("ImageView");
        phoneNumber = intent.getStringExtra("phone");
        emailAdd = intent.getStringExtra("email");

        if(actionbar != null){
            actionbar.setTitle(restaurantName);
        }

        TextView rest_nameTextView = (TextView) findViewById(R.id.restNameTextView);
        TextView recommendedDishTextView = (TextView) findViewById(R.id.recommendedTextView);
        TextView cuisineTextView = (TextView) findViewById(R.id.cuisineTextView);
        TextView avePricesTextView = (TextView) findViewById(R.id.avePriceTextView);
        ImageView detailImageView = (ImageView) findViewById(R.id.detailImageView);
        TextView callTextView = (TextView) findViewById(R.id.callTextView);
        TextView emailTextView = (TextView) findViewById(R.id.emailTextView);

        rest_nameTextView.setText(restaurantName);
        recommendedDishTextView.setText(recommendedDishes);
        cuisineTextView.setText(cuisineName);
        avePricesTextView.setText("Ave Price: " + avePrice);

        // third party for image downloading and catching
        Picasso.with(this).load(mainImage).into(detailImageView);
        callTextView.setText(phoneNumber);
        emailTextView.setText(emailAdd);

        // Google Map
        // Need a real device in order to Display the map


        // email button
        callButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri myPhoneNumber = Uri.parse("tel:"+ phoneNumber);
                Intent callIntent = new  Intent(Intent.ACTION_DIAL, myPhoneNumber);
                startActivity(callIntent);
            }
        });


        // call us btn
        emailButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent emailIntent = new Intent(Intent.ACTION_SEND);
                emailIntent.setType("plain/text");
                emailIntent.putExtra(Intent.EXTRA_EMAIL, new String[]{emailAdd});
                emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Hello I want to reserve seat");
                startActivity(emailIntent);
            }
        });



    }
}
