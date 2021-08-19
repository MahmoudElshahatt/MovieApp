package com.example.movieapp.adapters;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.movieapp.R;
import com.example.movieapp.models.Movie;

import java.util.List;

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.MyViewHolder> {
    private Context mcontext;
    private List<Movie> movieList;
   MovieitemClickListener listener;
    public MovieAdapter(Context mcontext, List<Movie> movieList, MovieitemClickListener listener) {
        this.mcontext = mcontext;
        this.movieList = movieList;
        this.listener=listener;
    }
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(mcontext).inflate(R.layout.item_movie,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MovieAdapter.MyViewHolder holder, int position) {
   holder.tvtitle.setText(movieList.get(position).getTitle());
   holder.imagemovie.setImageResource(movieList.get(position).getThumbnail());

    }

    @Override
    public int getItemCount() {
        return movieList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
       private TextView tvtitle;
        private ImageView imagemovie;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            tvtitle=itemView.findViewById(R.id.item_movie_title);
            imagemovie=itemView.findViewById(R.id.item_movie_img);


            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener.OnMovieClick(movieList.get(getAbsoluteAdapterPosition()),imagemovie);
                }
            });
        }
    }
}
