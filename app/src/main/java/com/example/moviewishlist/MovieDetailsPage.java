package com.example.moviewishlist;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class MovieDetailsPage extends AppCompatActivity {
    private static final String BASE_IMAGE_URL = "https://image.tmdb.org/t/p/w185";
    private ImageView backdrop, poster;
    private TextView rating, release, description;

    ActionBar actionBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_details_page);

        backdrop = (ImageView) findViewById(R.id.backdrop_image_view);
        poster = (ImageView) findViewById(R.id.poster_image_view);

        rating = (TextView) findViewById(R.id.rating_text_view);
//        release = (TextView) findViewById(R.id.release_date_text_view2);
//        description = (TextView) findViewById(R.id.overview_text_view);


        Intent intent = getIntent();
        String backdropPath = intent.getStringExtra("backdrop_path");
        String posterPath = intent.getStringExtra("poster_path");
        String voteAverage = intent.getStringExtra("vote_average");
//        String releaseDate = intent.getStringExtra("release_date");
//        String overview = intent.getStringExtra("overview");

        System.out.println(voteAverage);

        actionBar = getSupportActionBar();
        assert actionBar != null;
        actionBar.setTitle(intent.getStringExtra("title"));


        Glide.with(backdrop.getContext()).load(BASE_IMAGE_URL + backdropPath).override(2000, 400).into(backdrop);
        Glide.with(poster.getContext()).load(BASE_IMAGE_URL + posterPath).into(poster);
        rating.setText(voteAverage);
//        release.setText(releaseDate);
//        description.setText(overview);



    }
}
