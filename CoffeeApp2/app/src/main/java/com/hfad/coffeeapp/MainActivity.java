package com.hfad.coffeeapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.widget.Toast;

import com.hfad.coffeeapp.databinding.ActivityMainBinding;
import com.hfad.coffeeapp.fragments.*;
import com.hfad.coffeeapp.fragments.order.MyOrderFragment;


public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        HomeFragment homeFragment = new HomeFragment();
        MyOrderFragment myOrderFragment = new MyOrderFragment();
        RewardsFragment rewardsFragment = new RewardsFragment();

        replaceFragment(new HomeFragment());
        binding.bottomNav.setOnItemSelectedListener(item -> {
            int itemId = item.getItemId();
            if (itemId == R.id.nav_coffee) {
                replaceFragment(homeFragment);
                Toast.makeText(this, "Hello", Toast.LENGTH_SHORT).show();
                return true;
            } else if (itemId == R.id.nav_order) {
                replaceFragment(myOrderFragment);
                return true;
            } else if (itemId == R.id.nav_rewards) {
                replaceFragment(rewardsFragment);
                return true;
            }
            return true;
        });





    }

    private void replaceFragment(Fragment fragment) {
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_main_activity, fragment).commit();
    }



}