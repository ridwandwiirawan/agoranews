package com.example.agoranews.room;


import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;


import com.example.agoranews.model.News;

import java.util.List;

@Dao
public interface NewsRoom {

    @Query("SELECT * FROM news WHERE id = :id")
    News select(int id);

    @Query("SELECT * FROM news")
    List<News> selectAll();

    @Insert
    void insert(News news);

    @Query("Delete from news")
    void deleteAll();
}
