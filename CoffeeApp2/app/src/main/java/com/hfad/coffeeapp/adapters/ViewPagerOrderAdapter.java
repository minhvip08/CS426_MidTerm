package com.hfad.coffeeapp.adapters;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.hfad.coffeeapp.fragments.order.HistoryFragment;
import com.hfad.coffeeapp.fragments.order.OnGoingFragment;

public class ViewPagerOrderAdapter extends FragmentStateAdapter {

    public ViewPagerOrderAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position){
            case 0: return new HistoryFragment();
            case 1: return new OnGoingFragment();
        }
    return new HistoryFragment();
    }

    @Override
    public int getItemCount() {
        return 2;
    }
}
