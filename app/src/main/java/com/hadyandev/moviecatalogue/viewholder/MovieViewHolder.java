package com.hadyandev.moviecatalogue.viewholder;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.hadyandev.moviecatalogue.R;
import com.hadyandev.moviecatalogue.adapter.MovieClickListener;
import com.hadyandev.moviecatalogue.model.Movie;
import com.squareup.picasso.Picasso;

public class MovieViewHolder extends RecyclerView.ViewHolder {
    private RelativeLayout movieItemRootView;
    private ImageView imgBanner;
    private TextView txtMovieName;
    private TextView txtRating;
    private TextView txtDescription;

    public MovieViewHolder(@NonNull View itemView) {
        super(itemView);
        movieItemRootView = itemView.findViewById(R.id.movieItemRootView);
        imgBanner = itemView.findViewById(R.id.imgBanner);
        txtMovieName = itemView.findViewById(R.id.txtMovieName);
        txtRating = itemView.findViewById(R.id.txtRating);
        txtDescription = itemView.findViewById(R.id.txtDescription);
    }

    public void setMovieData(final Movie movie, final MovieClickListener listener) {
        Picasso.get().load(movie.getBanner()).into(imgBanner);
        txtMovieName.setText(movie.getName());
        txtRating.setText(String.valueOf(movie.getRating()));
        txtDescription.setText(movie.getDescription());

        movieItemRootView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onMovieClicked(movie);
            }
        });
    }
}
