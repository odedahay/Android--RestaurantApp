package com.example.rodeliodahay.restaurantapp;

/**
 * Created by RodelioDahay on 4/8/17.
 */

class Restaurant {

    private String rest_name, recommended_dishes, cuisine, image, phone, email;
    private int ave_price;

    // create constructor function
    Restaurant(String rest_name, String recommended_dishes, String cuisine, int ave_price, String image, String phone, String email){
        super();

        this.rest_name = rest_name;
        this.recommended_dishes = recommended_dishes;
        this.cuisine = cuisine;
        this.ave_price = ave_price;
        this.image = image;
        this.phone = phone;
        this.email = email;
    }

    String getRest_name(){
        return this.rest_name;
    }

    String getRecommended_dishes(){
        return this.recommended_dishes;
    }
    String getCuisine(){
        return this.cuisine;
    }

    int getAve_price(){
        return this.ave_price;
    }

    String getImage(){
        return this.image;
    }

    String getPhone(){
        return this.phone;
    }
    String getEmail(){
        return this.email;
    }


}
