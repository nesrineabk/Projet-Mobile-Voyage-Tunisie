package com.example.proet_nesrine.HomeAdapter;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.proet_nesrine.Entities.History;
import com.example.proet_nesrine.R;
import com.example.proet_nesrine.Utils.Restau_details;

import java.util.ArrayList;

public class History_Adptr extends RecyclerView.Adapter<History_Adptr.RestaurantsViewHolder> {

    static ArrayList<History> RestaurantsLocations;

    public History_Adptr(ArrayList<History> RestaurantsLocations) {
        this.RestaurantsLocations = RestaurantsLocations;

    }

    @NonNull
    @Override
    public RestaurantsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.restaurants_card_design, parent, false);
        RestaurantsViewHolder RestaurantsViewHolder = new RestaurantsViewHolder(view);

        return RestaurantsViewHolder;
    }


    @Override
    public void onBindViewHolder(@NonNull RestaurantsViewHolder holder, int position) {
        History title = RestaurantsLocations.get(position);
        History RestaurantsHelperClass = RestaurantsLocations.get(position);
        holder.image.setImageResource(RestaurantsHelperClass.getImage());
        holder.title.setText(RestaurantsHelperClass.getTitle());
        holder.descrip.setText(RestaurantsHelperClass.getDescrip());
        holder.location.setText(RestaurantsHelperClass.getLocation());

    }

    @Override
    public int getItemCount() {
        return RestaurantsLocations.size();
    }


    public class RestaurantsViewHolder extends RecyclerView.ViewHolder {
        ImageView image;
        TextView title;
        TextView descrip;
        TextView location;

        public RestaurantsViewHolder(@NonNull View itemView) {
            super(itemView);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent i = new Intent(v.getContext(), Restau_details.class);
                    //i.putExtra("image",image.)
                    i.putExtra("title", (title.getText().toString()));
                    i.putExtra("location", (location.getText().toString()));
                    // i.putExtra("image",image.)
                    //i.putExtra("image",);
                    v.getContext().startActivity(i);
                }
            });
            image = itemView.findViewById(R.id.Restaurants_image);
            title = itemView.findViewById(R.id.Restaurants_title);
            descrip = itemView.findViewById(R.id.Restaurants_descrip);
            location = itemView.findViewById(R.id.Restaurants_location);

        }

    }
}
