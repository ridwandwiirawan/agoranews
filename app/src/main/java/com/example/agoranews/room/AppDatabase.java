package com.example.agoranews.room;


import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;


import com.example.agoranews.model.News;

@Database(entities = {News.class}, version = 7, exportSchema = false)
public abstract class AppDatabase extends RoomDatabase {

    public static AppDatabase db(Context context) {
        return Room.databaseBuilder(context.getApplicationContext(),
                AppDatabase.class, "agora")
                .allowMainThreadQueries()
                .fallbackToDestructiveMigration()
                .build();
    }

    public abstract NewsRoom newsRoom();
}

