package com.example.agoranews;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.agoranews.R;
import com.example.agoranews.adapter.NewsAdapter;
import com.example.agoranews.api.ClientService;
import com.example.agoranews.api.RetrofitClient;
import com.example.agoranews.model.News;
import com.example.agoranews.room.AppDatabase;
import com.example.agoranews.room.NewsRoom;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.Path;

import static java.security.AccessController.getContext;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {
    private ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        NewsRoom room = AppDatabase.db(this).newsRoom();
        List<News> list = room.selectAll();
        NewsAdapter adapter = new NewsAdapter(this, list, this);
        RecyclerView recyclerView = findViewById(R.id.daftar);
        recyclerView.setAdapter(adapter);
        LinearLayoutManager man = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(man);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        if (id == android.R.id.home) {
            finish();
        }
        return super.onOptionsItemSelected(item);
    }
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
    }
}
//        List berita = list.get(position);
//        Intent intent = new Intent(MainActivity.this, NewsDetailActivity.class);
//        intent.putExtra("id", berita.getId());
//        startActivityForResult(intent, 50);

