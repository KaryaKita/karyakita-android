package com.karyakita.karyakita_android_new.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.karyakita.karyakita_android_new.R;
import com.karyakita.karyakita_android_new.model.Result;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MoviesAdapter extends RecyclerView.Adapter<MoviesAdapter.MoviesHolder> {

    List<Result> movieList;
    Context context;

    public MoviesAdapter(List<Result> movieList, Context context) {
        this.movieList = new ArrayList<>();
        this.context = context;
    }

    @Override
    public MoviesHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.test_list_cardwiew,parent,false);
        return new MoviesHolder(v);
    }

    @Override
    public void onBindViewHolder(MoviesHolder holder, int position) {

        holder.tvTitle.setText(movieList.get(position).getTitle());
        holder.tvOverview.setText(movieList.get(position).getOverview());
        holder.tvReleaseDate.setText(movieList.get(position).getReleaseDate());
        Glide.with(context).load("https://image.tmdb.org/t/p/w500/"+movieList.get(position).getPosterPath()).into(holder.ivMovie);
    }

    @Override
    public int getItemCount() {
        return movieList.size();
    }

    public void addToList(Result result) {
        movieList.add(result);
        notifyDataSetChanged();
    }

    public class MoviesHolder extends RecyclerView.ViewHolder {

        TextView tvTitle,tvOverview,tvReleaseDate;
        ImageView ivMovie;

        public MoviesHolder(View v) {
            super(v);
            context = v.getContext();

            tvTitle = (TextView) v.findViewById(R.id.tvTitle);
            tvOverview = (TextView) v.findViewById(R.id.tvOverView);
            tvReleaseDate = (TextView) v.findViewById(R.id.tvReleaseDate);
            ivMovie = (ImageView) v.findViewById(R.id.ivMovie);
        }
    }
}
