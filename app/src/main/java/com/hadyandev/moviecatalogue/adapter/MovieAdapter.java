package com.hadyandev.moviecatalogue.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.hadyandev.moviecatalogue.R;
import com.hadyandev.moviecatalogue.model.Movie;
import com.hadyandev.moviecatalogue.viewholder.MovieViewHolder;

import java.util.List;

public class MovieAdapter extends RecyclerView.Adapter<MovieViewHolder> {
    private MovieClickListener listener;
    private List<Movie> movie;

    public MovieAdapter(List<Movie> movie, MovieClickListener listener) {
        this.movie = movie;
        this.listener = listener;
    }

    @NonNull
    @Override
    public MovieViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        final View viewHolder = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_movie, viewGroup, false);
        final MovieViewHolder movieViewHolder = new MovieViewHolder(viewHolder);

        return movieViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MovieViewHolder movieViewHolder, int i) {
        movieViewHolder.setMovieData(movie.get(i), listener);
    }

    @Override
    public int getItemCount() {
        return movie.size();
    }
}
