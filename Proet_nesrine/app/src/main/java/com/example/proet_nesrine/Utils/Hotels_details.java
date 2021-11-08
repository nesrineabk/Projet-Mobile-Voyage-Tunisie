package com.example.proet_nesrine.Utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.airbnb.lottie.LottieAnimationView;
import com.example.proet_nesrine.Entities.User;
import com.example.proet_nesrine.Entities.UserCommentaire;
import com.example.proet_nesrine.HomeAdapter.CommentaireAdapter;
import com.example.proet_nesrine.R;
import com.example.proet_nesrine.Retrofit.INodeJS;
import com.example.proet_nesrine.Retrofit.RetrofitClient;
import com.example.proet_nesrine.Utils.database.AppDataBase;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Hotels_details extends AppCompatActivity {
    private AppDataBase database;
    private List<UserCommentaire> A = new ArrayList<UserCommentaire>();
    ImageView img;
    TextView name, location;
    SharedPreferences sharedPreferences;
    EditText comtext;
    List<UserCommentaire> comsList;
    Context mContext;
    RecyclerView recyclerView;
    TextView com;
    LottieAnimationView refsh;
    private CommentaireAdapter adapterList;
    public static INodeJS iNodeJS;
    CompositeDisposable compositeDisposable = new CompositeDisposable();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hotels_details);

    location = findViewById(R.id.hotels_loaction);
    name = findViewById(R.id.hotels_name);
    img = findViewById(R.id.imageH);
    com = findViewById(R.id.comHBtn);
    comtext = findViewById(R.id.textcomH);
    refsh = findViewById(R.id.refreshH);
    recyclerView = findViewById(R.id.comHrecycler);
    database = AppDataBase.getAppDatabase(Hotels_details.this);

    iNodeJS = RetrofitClient.getInstance().create(INodeJS.class);

    String name_restau = getIntent().getStringExtra("title");
    String location_restau = getIntent().getStringExtra("location");
    int image_restau = getIntent().getIntExtra("image", 0);
            name.setText(name_restau);
            location.setText(location_restau);
            img.setImageResource(R.drawable.hilton);

    sharedPreferences = getApplicationContext().getSharedPreferences("CurrentUser", Context.MODE_PRIVATE);

    GetListCom();

            refsh.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            GetListCom();
        }
    });

            com.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if (comtext.getText().toString().equals("")) {

                Toast.makeText(Hotels_details.this, "Add a comment!", Toast.LENGTH_SHORT).show();

            } else
                commenter(comtext.getText().toString(), "Admin");
        }
    });

}

    private void GetListCom () {
        recyclerView.setLayoutManager(new LinearLayoutManager(Hotels_details.this));
        A = database.produitDao().getAll();

        adapterList = new CommentaireAdapter(Hotels_details.this,A);

        recyclerView.setAdapter(adapterList);
    }

    private void commenter ( final String commentaire, final String nom_user)
    {

        UserCommentaire tmpUser = new UserCommentaire(commentaire,nom_user);

        database.produitDao().insertOne(tmpUser);
        Toast.makeText(Hotels_details.this,"Commentaire Ajouté",Toast.LENGTH_SHORT).show();
        //Toast.makeText(itemView.getContext(),"Nom du joueur choisi",Toast.LENGTH_SHORT).show();

    }

}