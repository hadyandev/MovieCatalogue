package com.hadyandev.moviecatalogue;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.hadyandev.moviecatalogue.model.Movie;
import com.squareup.picasso.Picasso;

public class DetailActivity extends AppCompatActivity {

    private ImageView imgBanner;
    private TextView txtMovieName;
    private TextView txtRating;
    private TextView txtDescription;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        //casting view
        imgBanner = findViewById(R.id.imgBanner);
        txtMovieName = findViewById(R.id.txtMovieName);
        txtRating = findViewById(R.id.txtRating);
        txtDescription = findViewById(R.id.txtDescription);

        Movie movie = getIntent().getParcelableExtra("MOVIE_DETAIL");

        Picasso.get().load(movie.getBanner()).into(imgBanner);
        txtMovieName.setText(movie.getName());
        txtRating.setText(String.valueOf(movie.getRating()));
        txtDescription.setText(movie.getDescription());
    }
}
