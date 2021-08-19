package com.example.movieapp.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;

import com.example.movieapp.Utils.DataSource;
import com.example.movieapp.models.Movie;
import com.example.movieapp.adapters.MovieAdapter;
import com.example.movieapp.adapters.MovieitemClickListener;
import com.example.movieapp.R;
import com.example.movieapp.models.Slide;
import com.example.movieapp.adapters.SliderPagerAdapter;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class HomeActivity extends AppCompatActivity implements MovieitemClickListener {
    private List<Slide> lsSlides;
    private ViewPager slidespager;
    private TabLayout indecator;
    private RecyclerView RVmovies,RVmoviesWeek;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        iniViews();
        iniSlider();
        iniPopularMovies();
        iniWeekmovies();
    }

    private void iniWeekmovies() {
        MovieAdapter movieAdapter=new MovieAdapter(this,DataSource.getWeekMovies(),this);
        RVmoviesWeek.setAdapter(movieAdapter);
        RVmoviesWeek.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false));
    }

    private void iniPopularMovies() {
        //setup a RecyclerView
        MovieAdapter movieAdapter=new MovieAdapter(this,DataSource.getPopularMovies(),this);
        RVmovies.setAdapter(movieAdapter);
        RVmovies.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false));
    }

    private void iniSlider() {
        lsSlides = new ArrayList<Slide>();
        lsSlides.add(new Slide(R.drawable.slide1, "The Wolverine"));
        lsSlides.add(new Slide(R.drawable.slide2, "Gravity"));
        lsSlides.add(new Slide(R.drawable.slide5, "Once Upon a Time in Hollywood"));
        lsSlides.add(new Slide(R.drawable.slide4, "Spider Man"));
        lsSlides.add(new Slide(R.drawable.slide2, "Gravity"));
        SliderPagerAdapter adapter = new SliderPagerAdapter(this, lsSlides);
        slidespager.setAdapter(adapter);
        //setup timer
        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new SliderTimer(), 4000, 6000);
        indecator.setupWithViewPager(slidespager, true);
    }

    private void iniViews() {
        slidespager = findViewById(R.id.slider_pager);
        indecator = findViewById(R.id.indecator);
        RVmovies=findViewById(R.id.rv_movies);
        RVmoviesWeek=findViewById(R.id.rv_movies_week);
    }

    @Override
    public void OnMovieClick(Movie movie, ImageView imageView) {
        //here we send movie information to detail activity.
        Intent intent=new Intent(this,MovieDetailActivity.class);
        intent.putExtra("Movie Title",movie.getTitle());
        intent.putExtra("Movie Image",movie.getThumbnail());
        intent.putExtra("Movie Cover",movie.getCoverPhoto());
        intent.putExtra("Movie Description",movie.getDescription());

        //Animation
        ActivityOptions options=ActivityOptions.makeSceneTransitionAnimation(HomeActivity.this,
                imageView,"sharedName");
        startActivity(intent,options.toBundle());
    }

    private class SliderTimer extends TimerTask {

        @Override
        public void run() {
            HomeActivity.this.runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    if (slidespager.getCurrentItem() < lsSlides.size() - 1) {
                        slidespager.setCurrentItem(slidespager.getCurrentItem() + 1);
                    } else
                        slidespager.setCurrentItem(0);
                }
            });
        }
    }
}