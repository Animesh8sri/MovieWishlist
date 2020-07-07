package com.example.moviewishlist.recyclerview;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.moviewishlist.MovieClick;
import com.example.moviewishlist.MovieDetailsPage;
import com.example.moviewishlist.R;
import com.example.moviewishlist.entity.ResponseAll;
import com.example.moviewishlist.entity.ResultsItem;
import com.example.moviewishlist.ui.home.HomeFragment;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {

    private static final String BASE_IMAGE_URL = "https://image.tmdb.org/t/p/w185";
    private ResponseAll responseAlls;
    private Context context;
    private MovieClick movieClick;

    public RecyclerViewAdapter(ResponseAll responseAlls, Context context,MovieClick movieClick) {
        this.responseAlls = responseAlls;
        this.context =  context;
        this.movieClick=movieClick;
    }



    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View v = inflater.inflate(R.layout.display_movies, parent, false);
        ViewHolder viewHolder = new ViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {

        ResultsItem results = responseAlls.getResults().get(position);

        holder.movieImageView.setAnimation(AnimationUtils.loadAnimation(context , R.anim.fade_transition_animation));
        holder.linearLayout.setAnimation(AnimationUtils.loadAnimation(context , R.anim.fade_scale_animation));

        Glide.with(holder.movieImageView.getContext()).load(BASE_IMAGE_URL + results.getPosterPath()).into(holder.movieImageView);
        holder.movieNameTextView.setText(results.getTitle());
        holder.realeaseDateTextView.setText(results.getReleaseDate());
        holder.descriptionTextView.setText(results.getOverview());


        holder.movieNameTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                movieClick.movieOnClickListener(responseAlls.getResults().get(position));
            }
        });



    }

    @Override
    public int getItemCount() {
        if (responseAlls != null)
            return responseAlls.getResults().size();
        else
            return 0;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        LinearLayout linearLayout;
        private ImageView movieImageView;
        private TextView movieNameTextView;
        private TextView realeaseDateTextView;
        private TextView descriptionTextView;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            linearLayout = itemView.findViewById(R.id.whole_card);
            movieImageView = itemView.findViewById(R.id.movie_image_view);
            movieNameTextView = itemView.findViewById(R.id.movie_name_text_view);
            realeaseDateTextView = itemView.findViewById(R.id.realease_date_text_view);
            descriptionTextView = itemView.findViewById(R.id.description_text_view);
        }
    }
}
