package com.example.agoranews;


import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.os.StrictMode;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Toast;

import com.example.agoranews.R;
import com.example.agoranews.adapter.NewsAdapter;
import com.example.agoranews.api.ClientService;
import com.example.agoranews.api.RetrofitClient;
import com.example.agoranews.model.News;
import com.example.agoranews.room.AppDatabase;
import com.example.agoranews.room.NewsRoom;
import com.google.gson.JsonObject;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class SplashScreen extends AppCompatActivity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splashscreen);

        if (android.os.Build.VERSION.SDK_INT > 9) {
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);
        }

        Retrofit retrofit = RetrofitClient.connect();
        ClientService client = retrofit.create(ClientService.class);
        Call<ResponseBody> request = client.topHeadlines("ID");
        request.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                // insert to room
                // start main activity
                try{
                    String json = response.body().string();
                    Log.e("Response", json);
                    JSONObject root = new JSONObject(json);
                    JSONArray articles = root.getJSONArray("articles");
                    NewsRoom room = AppDatabase.db(SplashScreen.this).newsRoom();
                    room.deleteAll();
                    for (int i = 0; i < articles.length(); i++) {
                        JSONObject newsJson = articles.getJSONObject(i);
                        String author = newsJson.getString("author");
                        String title = newsJson.getString("title");
                        String description = newsJson.getString("description");
                        String url = newsJson.getString("url");
                        String urlToImg = newsJson.getString("urlToImage");
                        String publishedAt = newsJson.getString("publishedAt");
                        String content = newsJson.getString("content");

                        News news = new News();
                        news.setAuthor(author);
                        news.setTitle(title);
                        news.setDescription(description);
                        news.setUrl(url);
                        news.setUrlToImg(urlToImg);
                        news.setPublishedAt(publishedAt);
                        news.setContent(content);
                        room.insert(news);
                    }
                    Intent intent = new Intent(SplashScreen.this, MainActivity.class);
                    startActivity(intent);
                    finish();
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                // jika gagal
                // keluar aplikasi / notifikasi error koneksi
            }
        });
    }
}

