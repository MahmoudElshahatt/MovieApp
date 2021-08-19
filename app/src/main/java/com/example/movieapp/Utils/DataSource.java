package com.example.movieapp.Utils;

import com.example.movieapp.R;
import com.example.movieapp.models.Movie;

import java.util.ArrayList;
import java.util.List;

public class DataSource {
    public static List<Movie> getPopularMovies(){
        List<Movie> movies=new ArrayList<Movie>();
        movies.add(new Movie("The Suicide Squad",R.string.sucide_desc,R.drawable.s,R.drawable.s));
        movies.add(new Movie("Free Guy",R.string.freeman_desc,R.drawable.free_guy,R.drawable.free_guy));
        movies.add(new Movie("Jungle Cruise",R.string.jungle_desc,R.drawable.j,R.drawable.j));
        movies.add(new Movie("Moana",R.string.moana_desc,R.drawable.moana,R.drawable.moana));
        movies.add(new Movie("Black Panther",R.string.default_desc,R.drawable.blackp,R.drawable.blackp));
        movies.add(new Movie("The Martian",R.string.default_desc,R.drawable.martian,R.drawable.martian));

        return  movies;
    }
    public static List<Movie> getWeekMovies(){
        List<Movie> movies=new ArrayList<Movie>();
        movies.add(new Movie("Black Panther",R.string.default_desc,R.drawable.blackp,R.drawable.slide4));
        movies.add(new Movie("The Martian",R.string.default_desc,R.drawable.martian,R.drawable.slide4));
        movies.add(new Movie("Moana",R.string.default_desc, R.drawable.moana,R.drawable.slide4));
        movies.add(new Movie("Black Panther",R.string.default_desc,R.drawable.blackp,R.drawable.slide4));
        movies.add(new Movie("The Martian",R.string.default_desc,R.drawable.martian,R.drawable.slide4));

        return  movies;
    }
}
