package com.example.movieapp.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.movieapp.R;
import com.example.movieapp.adapters.CastAdapter;
import com.example.movieapp.models.Cast;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

public class MovieDetailActivity extends AppCompatActivity {
    private ImageView MovieThumbnailImg, MoviecoverImg;
    private TextView tv_title, tv_description;
    private FloatingActionButton play_fa;
    private RecyclerView RVcast;
    private CastAdapter castAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_detail);
        //ini Views
        iniViews();
        //set up list Cast
        setupRVCast();


    }

    void iniViews() {
        RVcast = findViewById(R.id.rv_cast);
        Intent intent = getIntent();
        String movietitle = intent.getStringExtra("Movie Title");
        int moviedesc = intent.getIntExtra("Movie Description",0);
        int movieimage = intent.getIntExtra("Movie Image", 0);
        int moviecover = intent.getIntExtra("Movie Cover", 0);
        MovieThumbnailImg = findViewById(R.id.detail_movie_img);
        Glide.with(this).load(movieimage).into(MovieThumbnailImg);
        MoviecoverImg = findViewById(R.id.detail_movie_cover);
        Glide.with(this).load(moviecover).into(MoviecoverImg);
        tv_title = findViewById(R.id.detail_movie_title);
        tv_title.setText(movietitle);
        getSupportActionBar().setTitle(movietitle);
        tv_description = findViewById(R.id.detail_movie_desc);
        tv_description.setText(moviedesc);
        play_fa = findViewById(R.id.play_fa);
        MoviecoverImg.setAnimation(AnimationUtils.loadAnimation(this, R.anim.scale_animation));
        play_fa.setAnimation(AnimationUtils.loadAnimation(this, R.anim.scale_animation));

    }

    void setupRVCast() {
        List<Cast> castList = new ArrayList<>();
        castList.add(new Cast(R.drawable.c1));
        castList.add(new Cast(R.drawable.s2));
        castList.add(new Cast(R.drawable.s3));
        castList.add(new Cast(R.drawable.s4));
        castList.add(new Cast(R.drawable.s5));
        castAdapter = new CastAdapter(castList, this);
        RVcast.setAdapter(castAdapter);
        RVcast.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false));


    }
}