package com.example.agoranews.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import com.example.agoranews.NewsDetailActivity;
import com.example.agoranews.R;
import com.example.agoranews.model.News;
import com.squareup.picasso.Picasso;

import java.util.List;

public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.ViewHolder> {
    private Context context;
    private List<News> news;
    private AdapterView.OnItemClickListener listener;

    public NewsAdapter(Context context, List<News> news, AdapterView.OnItemClickListener listener) {
        this.context = context;
        this.news = news;
        this.listener = listener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context)
                .inflate(R.layout.item_news, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        final News news = this.news.get(position);
        holder.tvAuthor.setText(news.getAuthor());
        holder.tvTitle.setText(news.getTitle());
        holder.tvDescription.setText(news.getDescription());
        holder.tvPublishedAt.setText(news.getPublishedAt());
        Picasso.with(context)
                .load(news.getUrlToImg())
                .into(holder.ivPic);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View v) {
                Intent i = new Intent(context, NewsDetailActivity.class);
                i.putExtra("judul", news.getTitle());
                i.putExtra("gambar", news.getUrlToImg());
                i.putExtra("konten", news.getContent());
                i.putExtra("author", news.getAuthor());
                i.putExtra("tanggal", news.getPublishedAt());
                context.startActivity(i);
            }
        });
    }

    @Override
    public int getItemCount() {
        return news.size();
    }

    public class ViewHolder  extends RecyclerView.ViewHolder {
        public TextView tvAuthor;
        public TextView tvTitle;
        public TextView tvDescription;
        public TextView tvPublishedAt;
        public ImageView ivPic;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvAuthor = itemView.findViewById(R.id.news_author);
            tvTitle = itemView.findViewById(R.id.title_news);
            tvPublishedAt = itemView.findViewById(R.id.news_publishedAt);
            tvDescription = itemView.findViewById(R.id.news_description);
            ivPic = itemView.findViewById(R.id.pic);
        }
    }
}

