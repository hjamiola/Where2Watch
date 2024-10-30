package com.example.where2watch.ui.adapter;// MovieAdapter.java
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.where2watch.R;
import com.example.where2watch.ui.model.Movie;

import java.util.List;

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.MovieViewHolder> {
    private List<Movie> movieList;

    public MovieAdapter(List<Movie> movieList) {
        this.movieList = movieList;
    }

    @NonNull
    @Override
    public MovieViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_movie, parent, false);
        return new MovieViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MovieViewHolder holder, int position) {
        Movie movie = movieList.get(position);
        holder.titleTextView.setText(movie.getTitle());
        holder.genreTextView.setText(movie.getGenre());
        holder.ratingBar.setRating(movie.getRating());
        holder.coverImageView.setImageResource(movie.getImageResId()); // Set the image resource

    }

    @Override
    public int getItemCount() {
        return movieList.size();
    }

    public static class MovieViewHolder extends RecyclerView.ViewHolder {
        TextView titleTextView, genreTextView;
        RatingBar ratingBar;
        ImageView coverImageView; // Add this field


        public MovieViewHolder(View itemView) {
            super(itemView);
            titleTextView = itemView.findViewById(R.id.movie_title);
            genreTextView = itemView.findViewById(R.id.movie_genre);
            ratingBar = itemView.findViewById(R.id.movie_rating);
            coverImageView = itemView.findViewById(R.id.movie_cover); // Initialize the ImageView
        }
    }
}
