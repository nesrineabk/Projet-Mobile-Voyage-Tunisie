package com.example.proet_nesrine.Utils;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.proet_nesrine.HomeAdapter.Best_Place_Adptr;
import com.example.proet_nesrine.Entities.Best_Places;
import com.example.proet_nesrine.R;

import java.util.ArrayList;

public class Bars extends AppCompatActivity {
    RecyclerView BarsRecycler;
    RecyclerView.Adapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bars);
        BarsRecycler = findViewById(R.id.bars_ryc);
        BarsRecycler();
    }

    private void BarsRecycler() {
        BarsRecycler.setHasFixedSize(true);
        BarsRecycler.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));

        ArrayList<Best_Places> RestaurantsLocations = new ArrayList<>();
        RestaurantsLocations.add(new Best_Places(R.drawable.yuka, "Yuka", "Gammarth", "This restaurants is specialized in sandwich "));
        RestaurantsLocations.add(new Best_Places(R.drawable.jobi, "Jobi", "Gammarth", "This restaurants is specialized in sandwich"));
        RestaurantsLocations.add(new Best_Places(R.drawable.duplex, "Duplex", "Centre Ville", "This restaurants is specialized in sandwich"));
        RestaurantsLocations.add(new Best_Places(R.drawable.sterling, "Le Sterling", "Centre Ville", "This restaurants is specialized in sandwich and grilled food with hot sauces !!"));
        RestaurantsLocations.add(new Best_Places(R.drawable.soho, "SOHO", "Gammarth", "This restaurants is specialized in sandwich and grilled food with hot sauces !!"));
        RestaurantsLocations.add(new Best_Places(R.drawable.chezlm, "Chez l'Ami", "Sokra", "This restaurants is specialized in sandwich and grilled food with hot sauces !!"));
        adapter = new Best_Place_Adptr(RestaurantsLocations);
        BarsRecycler.setAdapter(adapter);
    }
}