package com.hfad.coffeeapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.Toast;

import com.hfad.coffeeapp.databinding.ActivityMainBinding;
import com.hfad.coffeeapp.fragments.*;


public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

//        replaceFragment(new HomeFragment());
        binding.bottomNav.setOnItemSelectedListener(item -> {
            int itemId = item.getItemId();
            if (itemId == R.id.nav_coffee) {
                replaceFragment(new HomeFragment());
                Toast.makeText(this, "Hello", Toast.LENGTH_SHORT).show();
                return true;
            } else if (itemId == R.id.nav_order) {
                replaceFragment(new MyOrderFragment());
                return true;
            } else if (itemId == R.id.nav_rewards) {
                replaceFragment(new RewardsFragment());
                return true;
            }
            return false;
        });


    }

    private void replaceFragment(Fragment fragment) {
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_main_activity, fragment).commit();
    }
}