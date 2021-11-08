package com.example.proet_nesrine.Utils.dao;


import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.proet_nesrine.Entities.UserCommentaire;
import java.util.List;

@androidx.room.Dao
public interface Dao {

    @Insert
    void insertOne(UserCommentaire commentaire);
    @Query("SELECT * FROM user_com WHERE id=:id")
    int check_item(int id);
    @Delete
    void delete(UserCommentaire produit);
    @Query("SELECT * FROM user_com")
    List<UserCommentaire> getAll();


}