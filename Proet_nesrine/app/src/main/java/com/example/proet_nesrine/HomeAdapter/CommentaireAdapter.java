package com.example.proet_nesrine.HomeAdapter;

import android.content.Context;
import android.content.SharedPreferences;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.proet_nesrine.Entities.UserCommentaire;
import com.example.proet_nesrine.R;
import com.example.proet_nesrine.Retrofit.INodeJS;
import com.example.proet_nesrine.Retrofit.RetrofitClient;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.disposables.CompositeDisposable;

public class CommentaireAdapter extends RecyclerView.Adapter<CommentaireAdapter.myViewHolder> {

    Context mContext;
    private List<UserCommentaire> mData;
    private List<UserCommentaire> event_list = new ArrayList<>();
    SharedPreferences sharedPreferences, sharedPreferencesUE, sharedPreferencesU;
    CompositeDisposable compositeDisposable = new CompositeDisposable();
    TextView textcomm, nom_userr;
    public static INodeJS iNodeJS;
    int idus;


    public CommentaireAdapter(Context mContext, List<UserCommentaire> mDataa) {
        this.mContext = mContext;
        this.mData = mDataa;
    }

    @NonNull
    @Override
    public myViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        View v = inflater.inflate(R.layout.com_item, parent, false);
        myViewHolder vv = new myViewHolder(v);

        sharedPreferencesUE = parent.getContext().getSharedPreferences("UserEvent", Context.MODE_PRIVATE);
        sharedPreferencesU = parent.getContext().getSharedPreferences("CurrentUser", Context.MODE_PRIVATE);
        idus = sharedPreferencesU.getInt("idUser", 0);

        return vv;
    }

    @Override
    public void onBindViewHolder(@NonNull myViewHolder holder, int position) {
        UserCommentaire evenement = mData.get(position);

        nom_userr.setText(evenement.getNom_user());
        textcomm.setText(evenement.getCommentaire());
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }


    public class myViewHolder extends RecyclerView.ViewHolder {

        public myViewHolder(@NonNull final View itemView) {
            super(itemView);
            iNodeJS = RetrofitClient.getInstance().create(INodeJS.class);
            nom_userr = itemView.findViewById(R.id.nom_user);
            textcomm = itemView.findViewById(R.id.textcom);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    int position = getAdapterPosition();
                    if (position != RecyclerView.NO_POSITION) {
                        sharedPreferences = v.getContext().getSharedPreferences("Evenement", Context.MODE_PRIVATE);
                        sharedPreferencesUE = v.getContext().getSharedPreferences("UserEvent", Context.MODE_PRIVATE);
                        UserCommentaire ce = mData.get(position);

                    }
                }
            });


            itemView.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View v) {

                    return false;
                }
            });

        }
    }

}