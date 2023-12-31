package com.hfad.coffeeapp.fragments;

import android.os.Bundle;

import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.hfad.coffeeapp.MainActivity;
import com.hfad.coffeeapp.R;
import com.hfad.coffeeapp.adapters.AdapterCoffee;
import com.hfad.coffeeapp.data.AppData;

import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link HomeFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class HomeFragment extends Fragment {
    RecyclerView homeRecycler;
    AdapterCoffee adapterCoffee;
    List<Integer> imagesCoffee;
    List<String> namesCoffee;
    AppData appData;
    private Toolbar mActionBarToolbar;


    @Override
    public void onStart() {
        super.onStart();
        View view = getView();
        appData = new AppData();
        imagesCoffee = appData.imagesCoffee();
        namesCoffee = appData.namesCoffee();

        if (view != null) {
            homeRecycler = view.findViewById(R.id.fragment_home_recycler_view);
            adapterCoffee = new AdapterCoffee(getContext(), imagesCoffee, namesCoffee, getActivity());
        }
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getActivity(), 2, GridLayoutManager.VERTICAL, false);

        homeRecycler.setLayoutManager(gridLayoutManager);
        homeRecycler.setAdapter(adapterCoffee);

        mActionBarToolbar = getActivity().findViewById(R.id.toolbar);
        ((MainActivity) requireActivity()).setSupportActionBar(mActionBarToolbar);
        ((MainActivity) requireActivity()).getSupportActionBar().hide();

    }

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public HomeFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment HomeFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static HomeFragment newInstance(String param1, String param2) {
        HomeFragment fragment = new HomeFragment();
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
        return inflater.inflate(R.layout.fragment_home, container, false);
    }
}