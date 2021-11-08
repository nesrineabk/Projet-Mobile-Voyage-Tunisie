package com.example.proet_nesrine.Utils;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.proet_nesrine.HomeAdapter.History_Adptr;
import com.example.proet_nesrine.Entities.History;
import com.example.proet_nesrine.R;

import java.util.ArrayList;

public class Restaurants extends AppCompatActivity {
    RecyclerView RestaurantsRecycler;
    RecyclerView.Adapter adapter;
    View.OnClickListener listener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restaurants);
        RestaurantsRecycler = findViewById(R.id.restau_ryc);
        RestaurantsRecycler();
    }

    private void RestaurantsRecycler() {
        RestaurantsRecycler.setHasFixedSize(true);
        RestaurantsRecycler.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));

        ArrayList<History> RestaurantsLocations = new ArrayList<>();
        RestaurantsLocations.add(new History(R.drawable.plan_b, "Plan B", "Manzah 1", "This restaurants is specialized in sandwich "));
        RestaurantsLocations.add(new History(R.drawable.kfc, "KFC", "Manar 2", "This restaurants is specialized in sandwich"));
        RestaurantsLocations.add(new History(R.drawable.tacos, "Chaneb Tacos", "Ennasr 1", "This restaurants is specialized in sandwich"));
        RestaurantsLocations.add(new History(R.drawable.baguette, "Baguette&Baguette", "Centre Ville", "This restaurants is specialized in sandwich and grilled food with hot sauces !!"));
        RestaurantsLocations.add(new History(R.drawable.senio_tacos, "Senior Tacos", "Ennasr 2", "This restaurants is specialized in sandwich and grilled food with hot sauces !!"));
        RestaurantsLocations.add(new History(R.drawable.carmine, "Carmine", "Gammarth", "This restaurants is specialized in sandwich and grilled food with hot sauces !!"));
        RestaurantsLocations.add(new History(R.drawable.pasta_causi, "Pasta Cosi", "Lac 1", "This restaurants is specialized in sandwich and grilled food with hot sauces !!"));
        RestaurantsLocations.add(new History(R.drawable.dar_zmen, "Dar Zmen", "Lac 2", "This restaurants is specialized in sandwich and grilled food with hot sauces !!"));
        adapter = new History_Adptr(RestaurantsLocations);
        RestaurantsRecycler.setAdapter(adapter);

    }
}