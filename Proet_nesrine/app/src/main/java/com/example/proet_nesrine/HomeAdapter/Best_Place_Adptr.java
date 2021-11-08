package com.example.proet_nesrine.HomeAdapter;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.proet_nesrine.Entities.Best_Places;
import com.example.proet_nesrine.R;
import com.example.proet_nesrine.Utils.Bars_details;

import java.util.ArrayList;

public class Best_Place_Adptr extends RecyclerView.Adapter<Best_Place_Adptr.BarsViewHolder> {

    ArrayList<Best_Places> BarsLocations;

    public Best_Place_Adptr(ArrayList<Best_Places> BarsLocations) {
        this.BarsLocations = BarsLocations;
    }

    @NonNull
    @Override
    public BarsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.bars_card_design, parent, false);
        BarsViewHolder BarsViewHolder = new BarsViewHolder(view);

        return BarsViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull BarsViewHolder holder, int position) {
        Best_Places BarsHelperClass = BarsLocations.get(position);
        holder.image.setImageResource(BarsHelperClass.getImage());
        holder.title.setText(BarsHelperClass.getTitle());
        holder.descrip.setText(BarsHelperClass.getDescrip());
        holder.location.setText(BarsHelperClass.getLocation());


    }

    @Override
    public int getItemCount() {
        return BarsLocations.size();
    }

    public static class BarsViewHolder extends RecyclerView.ViewHolder {
        ImageView image;
        TextView title;
        TextView descrip;
        TextView location;

        public BarsViewHolder(@NonNull View itemView) {
            super(itemView);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int position = getAdapterPosition();
                    Intent i = new Intent(v.getContext(), Bars_details.class);
                    //i.putExtra("image",image.)
                    i.putExtra("title", (title.getText().toString()));
                    i.putExtra("location", (location.getText().toString()));
                    //i.putExtra("image",)
                    //i.putExtra("image",);
                    v.getContext().startActivity(i);
                }
            });
            image = itemView.findViewById(R.id.bars_image);
            title = itemView.findViewById(R.id.bars_title);
            descrip = itemView.findViewById(R.id.bars_descrip);
            location = itemView.findViewById(R.id.bars_location);
        }
    }
}
