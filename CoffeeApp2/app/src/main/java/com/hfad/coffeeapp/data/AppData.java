package com.hfad.coffeeapp.data;

import com.hfad.coffeeapp.R;

import java.util.ArrayList;
import java.util.List;

public class AppData {

    List<Integer> imagesCoffee;
    List<String> namesCoffee;

    public List<Integer> imagesCoffee(){
        imagesCoffee = new ArrayList<>();
        imagesCoffee.add(R.drawable.coffee_1);
        imagesCoffee.add(R.drawable.coffee_2);
        imagesCoffee.add(R.drawable.coffee_3);
        imagesCoffee.add(R.drawable.coffee_4);
        return imagesCoffee;
    }

    public List<String> namesCoffee(){
        namesCoffee = new ArrayList<>();
        namesCoffee.add("Coffee 1");
        namesCoffee.add("Coffee 2");
        namesCoffee.add("Coffee 3");
        namesCoffee.add("Coffee 4");
        return namesCoffee;
    }

}
