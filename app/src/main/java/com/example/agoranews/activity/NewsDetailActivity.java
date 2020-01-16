package com.example.agoranews.activity;

import android.os.Bundle;
import android.view.MenuItem;

import androidx.appcompat.app.AppCompatActivity;

import com.example.agoranews.R;
import com.example.agoranews.model.News;
import com.example.agoranews.room.AppDatabase;
import com.example.agoranews.room.NewsRoom;


public class NewsDetailActivity extends AppCompatActivity {

    NewsRoom room;
    News news;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news_detail);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setTitle("News");


        room = AppDatabase.db(this).newsRoom();
        int id = getIntent().getIntExtra("id", 0);
        news = room.select(id);

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home){
            finish();
        }
        return super.onOptionsItemSelected(item);
    }
}
