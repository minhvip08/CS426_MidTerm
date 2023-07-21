package com.hfad.coffeeapp.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.hfad.coffeeapp.R;
import com.hfad.coffeeapp.adapters.AdapterReward;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link RewardTableFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class RewardTableFragment extends Fragment {

    RecyclerView rewardsRecycler;
    AdapterReward adapterRewards;
    int numberCupBought = 3;

    @Override
    public void onStart() {
        super.onStart();
        View view = getView();
        if (view != null){
            rewardsRecycler = view.findViewById(R.id.recycler_view_rewards);
            adapterRewards = new AdapterReward(getContext(), getActivity(), numberCupBought);
        }

        GridLayoutManager layoutManager = new GridLayoutManager(getActivity(), 8, GridLayoutManager.VERTICAL, false);

        rewardsRecycler.setLayoutManager(layoutManager);
        rewardsRecycler.setAdapter(adapterRewards);

    }

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public RewardTableFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment RewardTableFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static RewardTableFragment newInstance(String param1, String param2) {
        RewardTableFragment fragment = new RewardTableFragment();
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
        return inflater.inflate(R.layout.fragment_reward_table, container, false);
    }
}