package com.example.movieapp.adapters;

import android.widget.ImageView;

import com.example.movieapp.models.Movie;

public interface MovieitemClickListener {
    void OnMovieClick(Movie movie, ImageView imageView);
}
