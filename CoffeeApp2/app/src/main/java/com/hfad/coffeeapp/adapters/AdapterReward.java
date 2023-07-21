package com.hfad.coffeeapp.adapters;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.hfad.coffeeapp.R;

public class AdapterReward extends RecyclerView.Adapter<AdapterReward.ViewHolder>{

    LayoutInflater inflater;
    Activity activity;


    int numberCupBought;

    public AdapterReward(Context context, Activity activity, int numberCupBought){
        this.activity = activity;
        this.numberCupBought = numberCupBought;
        this.inflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.item_rewards, parent, false);
        return new ViewHolder(view);


    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        if(position < numberCupBought){
            holder.imageCup.setImageResource(R.drawable.coffee_cup_buy);
        }
        else {
            holder.imageCup.setImageResource(R.drawable.coffee_cup_not_bought);
        }
        holder.imageCup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(activity, "Clicked on cup", Toast.LENGTH_SHORT).show();
            }
        });

    }

    @Override
    public int getItemCount() {
        return 8;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        ImageView imageCup;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            imageCup = itemView.findViewById(R.id.imageCup);
        }
    }
}