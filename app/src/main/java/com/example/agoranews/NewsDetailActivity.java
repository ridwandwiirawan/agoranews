package com.example.agoranews;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.StrictMode;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.agoranews.adapter.NewsAdapter;
import com.example.agoranews.model.News;
import com.example.agoranews.room.AppDatabase;
import com.example.agoranews.room.NewsRoom;
import com.squareup.picasso.Picasso;

import java.util.List;

public class NewsDetailActivity extends AppCompatActivity {
    TextView tvJudul;
    ImageView ivGambar;
    TextView tvKonten;
    TextView tvAuthor;
    TextView tvPublishedAt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news_detail);

        tvJudul = (TextView) findViewById(R.id.judul);
        ivGambar = (ImageView) findViewById(R.id.gambar);
        tvKonten = (TextView) findViewById(R.id.konten);
        tvAuthor = (TextView) findViewById(R.id.author);
        tvPublishedAt = (TextView) findViewById(R.id.tanggal);

        Intent i =getIntent();

        if (i == null)
            return;

        String judul = i.getStringExtra("judul");
        String gambar = i.getStringExtra("gambar");
        String konten = i.getStringExtra("konten");
        String author = i.getStringExtra("author");
        String publishedat = i.getStringExtra("tanggal");

        tvJudul.setText(judul);
        tvKonten.setText(konten);
        Picasso.with(this)
                .load(gambar)
                .into(ivGambar);
        tvAuthor.setText(author);
        tvPublishedAt.setText(publishedat);
    }
}

