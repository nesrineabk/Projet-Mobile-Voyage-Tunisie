package com.example.proet_nesrine.Utils.database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.proet_nesrine.Entities.UserCommentaire;
import com.example.proet_nesrine.Utils.dao.Dao;


@Database(entities = {UserCommentaire.class}, version = 1, exportSchema = false)
public abstract class AppDataBase extends RoomDatabase {

    private static AppDataBase instance;
    public abstract Dao produitDao();
    public static AppDataBase getAppDatabase(Context context) {
        if (instance == null) {
            instance = Room.databaseBuilder(context.getApplicationContext(), AppDataBase.class, "commentaire")

                    .allowMainThreadQueries()
                    .build();

        }
        return instance;
    }
    }

