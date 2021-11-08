package com.example.proet_nesrine.HomeAdapter;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.proet_nesrine.Entities.Hotel;
import com.example.proet_nesrine.R;
import com.example.proet_nesrine.Utils.Hotels_details;

import java.util.ArrayList;

public class HotelsAdapter extends RecyclerView.Adapter<HotelsAdapter.HotelsViewHolder> {

    ArrayList<Hotel> HotelsLocations;

    public HotelsAdapter(ArrayList<Hotel> HotelsLocations) {
        this.HotelsLocations = HotelsLocations;
    }

    @NonNull
    @Override
    public HotelsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.hotels_card_design, parent, false);
        HotelsViewHolder HotelsViewHolder = new HotelsViewHolder(view);

        return HotelsViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull HotelsViewHolder holder, int position) {
        Hotel HotelsHelperClass = HotelsLocations.get(position);
        holder.image.setImageResource(HotelsHelperClass.getImage());
        holder.title.setText(HotelsHelperClass.getTitle());
        holder.descrip.setText(HotelsHelperClass.getDescrip());
        holder.location.setText(HotelsHelperClass.getLocation());


    }

    @Override
    public int getItemCount() {
        return HotelsLocations.size();
    }

    public static class HotelsViewHolder extends RecyclerView.ViewHolder {
        ImageView image;
        TextView title;
        TextView descrip;
        TextView location;

        public HotelsViewHolder(@NonNull View itemView) {
            super(itemView);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent i = new Intent(v.getContext(), Hotels_details.class);
                    //i.putExtra("image",image.)
                    i.putExtra("title", (title.getText().toString()));
                    i.putExtra("location", (location.getText().toString()));
                    // i.putExtra("image",image.)
                    //i.putExtra("image",);
                    v.getContext().startActivity(i);
                }
            });
            image = itemView.findViewById(R.id.Hotels_image);
            title = itemView.findViewById(R.id.Hotels_title);
            descrip = itemView.findViewById(R.id.Hotels_descrip);
            location = itemView.findViewById(R.id.Hotels_location);
        }
    }
}
