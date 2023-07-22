package com.hfad.coffeeapp.fragments.order;

import android.os.Bundle;

import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.material.tabs.TabLayout;
import com.hfad.coffeeapp.MainActivity;
import com.hfad.coffeeapp.R;
import com.hfad.coffeeapp.adapters.ViewPagerOrderAdapter;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link MyOrderFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class MyOrderFragment extends Fragment {


    private TabLayout tabLayout;
    private ViewPager2 viewPager2;
    private ViewPagerOrderAdapter viewPageOrderAdapter;
    private Toolbar mActionBarToolbar;

    @Override
    public void onStart() {
        super.onStart();

        tabLayout = getActivity().findViewById(R.id.tab_layout_my_order);
        viewPager2 = getActivity().findViewById(R.id.view_pager_my_order);
        viewPageOrderAdapter = new ViewPagerOrderAdapter(getActivity());
        viewPager2.setAdapter(viewPageOrderAdapter);
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {

            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager2.setCurrentItem(tab.getPosition()); // when tab is selected, the viewpager will change to the tab position

            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        viewPager2.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() { // when the viewpager is changed, the tab will change to the viewpager position
            @Override
            public void onPageSelected(int position) {
                tabLayout.selectTab(tabLayout.getTabAt(position));
            }
        });

        mActionBarToolbar = getActivity().findViewById(R.id.toolbar);
        ((MainActivity) requireActivity()).setSupportActionBar(mActionBarToolbar);
        ((MainActivity) requireActivity()).getSupportActionBar().show();
        ((MainActivity) requireActivity()).getSupportActionBar().setDisplayShowTitleEnabled(false);


    }

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public MyOrderFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment MyOrderFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static MyOrderFragment newInstance(String param1, String param2) {
        MyOrderFragment fragment = new MyOrderFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_my_order, container, false);
    }
}