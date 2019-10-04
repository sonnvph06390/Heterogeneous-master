package com.example.delaroy.heterogenousrecyclerview.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;



import com.example.delaroy.heterogenousrecyclerview.R;
import com.example.delaroy.heterogenousrecyclerview.pojos.Film;


import java.util.ArrayList;

public class FilmAdapter extends RecyclerView.Adapter<FilmAdapter.MyViewHolder> {

    ArrayList<Film> listFilm = new ArrayList<>();

    public FilmAdapter(ArrayList<Film> listFilm) {
        this.listFilm = listFilm;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_film, parent, false);
        return new FilmAdapter.MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.imgFilm.setImageResource(listFilm.get(position).getImageFilm());
        holder.titleFilm.setText(listFilm.get(position).getTvTitleFilm());
        holder.tvAct.setText(listFilm.get(position).getTvAct());
    }

    @Override
    public int getItemCount() {
        return listFilm.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        ImageView imgFilm;
        TextView titleFilm, tvAct;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            imgFilm = (ImageView) itemView.findViewById(R.id.ivFilm);
            titleFilm = (TextView) itemView.findViewById(R.id.tvFilmName);
            tvAct = (TextView) itemView.findViewById(R.id.tvAct);
        }
    }
}
