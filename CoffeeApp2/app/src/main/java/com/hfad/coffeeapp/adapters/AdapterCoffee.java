package com.hfad.coffeeapp.adapters;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.hfad.coffeeapp.R;

import java.util.List;

public class AdapterCoffee extends RecyclerView.Adapter<AdapterCoffee.ViewHolder> {

    List<Integer> imagesCoffee;
    List<String> namesCoffee;
    LayoutInflater inflater;
    Activity activity;

    public AdapterCoffee(Context context, List<Integer> imagesCoffee, List<String> namesCoffee, Activity activity) {
        this.imagesCoffee = imagesCoffee;
        this.namesCoffee = namesCoffee;
        this.activity = activity;
        this.inflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.item_coffee, parent, false);
        return new AdapterCoffee.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        holder.imageCup.setImageResource(imagesCoffee.get(position));
        holder.textCup.setText(namesCoffee.get(position));


    }

    @Override
    public int getItemCount() {
        return 4;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        ImageView imageCup;
        TextView textCup;
        View view;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageCup = itemView.findViewById(R.id.item_coffee_img);
            textCup = itemView.findViewById(R.id.item_coffee_text);
            view = itemView;
        }
    }
}
