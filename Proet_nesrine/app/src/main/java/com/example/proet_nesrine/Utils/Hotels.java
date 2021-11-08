package com.example.proet_nesrine.Utils;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.proet_nesrine.HomeAdapter.HotelsAdapter;
import com.example.proet_nesrine.Entities.Hotel;
import com.example.proet_nesrine.R;

import java.util.ArrayList;

public class Hotels extends AppCompatActivity {
    RecyclerView HotelsRecycler;
    RecyclerView.Adapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hotels);
        HotelsRecycler = findViewById(R.id.hotels_ryc);
        HotelsRecycler();
    }

    private void HotelsRecycler() {
        HotelsRecycler.setHasFixedSize(true);
        HotelsRecycler.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));

        ArrayList<Hotel> RestaurantsLocations = new ArrayList<>();
        RestaurantsLocations.add(new Hotel(R.drawable.gldntulip, "Golde Tulip", "Gammarth", "This restaurants is specialized in sandwich "));
        RestaurantsLocations.add(new Hotel(R.drawable.mouradi, "El Mouradi", "Gammarth", "This restaurants is specialized in sandwich"));
        RestaurantsLocations.add(new Hotel(R.drawable.hilton, "Hilton", "Gammarth", "This restaurants is specialized in sandwich"));
        RestaurantsLocations.add(new Hotel(R.drawable.mercure, "Mercure", "Centre Ville", "This restaurants is specialized in sandwich and grilled food with hot sauces !!"));
        RestaurantsLocations.add(new Hotel(R.drawable.movenpik, "Movenpick", "Sousse", "This restaurants is specialized in sandwich and grilled food with hot sauces !!"));
        RestaurantsLocations.add(new Hotel(R.drawable.chezlm, "Chez l'Ami", "Sokra", "This restaurants is specialized in sandwich and grilled food with hot sauces !!"));
        adapter = new HotelsAdapter(RestaurantsLocations);
        HotelsRecycler.setAdapter(adapter);
    }
}