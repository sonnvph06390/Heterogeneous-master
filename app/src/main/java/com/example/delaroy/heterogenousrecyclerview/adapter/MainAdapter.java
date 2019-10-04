package com.example.delaroy.heterogenousrecyclerview.adapter;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.delaroy.heterogenousrecyclerview.R;
import com.example.delaroy.heterogenousrecyclerview.pojos.Film;
import com.example.delaroy.heterogenousrecyclerview.pojos.SingleHorizontal;
import com.example.delaroy.heterogenousrecyclerview.pojos.SingleVertical;

import java.util.ArrayList;

import static com.example.delaroy.heterogenousrecyclerview.MainActivity.getFilmData;
import static com.example.delaroy.heterogenousrecyclerview.MainActivity.getHorizontalData;
import static com.example.delaroy.heterogenousrecyclerview.MainActivity.getVerticalData;

public class MainAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private Context context;
    private ArrayList<Object> items;
    private final int VERTICAL = 1;
    private final int HORIZONTAL = 2;
    private final int FILM = 3;

    public MainAdapter(Context context, ArrayList<Object> items) {
        this.context = context;
        this.items = items;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view;
        RecyclerView.ViewHolder holder;
        switch (viewType) {
            case VERTICAL:
                view = inflater.inflate(R.layout.vertical, parent, false);
                holder = new VerticalViewHolder(view);
                break;
            case HORIZONTAL:
                view = inflater.inflate(R.layout.horizontal, parent, false);
                holder = new HorizontalViewHolder(view);
                break;
            case FILM:
                view = inflater.inflate(R.layout.rcv_film, parent, false);
                holder = new FilmViewHolder(view);
                break;

            default:
                view = inflater.inflate(R.layout.horizontal, parent, false);
                holder = new HorizontalViewHolder(view);
                break;
        }


        return holder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (holder.getItemViewType() == VERTICAL)
            verticalView((VerticalViewHolder) holder);
        else if (holder.getItemViewType() == HORIZONTAL)
            horizontalView((HorizontalViewHolder) holder);
        else if (holder.getItemViewType() == FILM)
            filmView((FilmViewHolder) holder);
    }

    private void verticalView(VerticalViewHolder holder) {

        VerticalAdapter adapter1 = new VerticalAdapter(getVerticalData());
        holder.recyclerView.setLayoutManager(new LinearLayoutManager(context));
        holder.recyclerView.setAdapter(adapter1);
    }


    private void horizontalView(HorizontalViewHolder holder) {
        HorizontalAdapter adapter = new HorizontalAdapter(getHorizontalData());
        holder.recyclerView.setLayoutManager(new LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false));
        holder.recyclerView.setAdapter(adapter);
    }
    private void filmView(FilmViewHolder holder) {
        FilmAdapter adapter = new FilmAdapter(getFilmData());
        holder.recyclerView.setLayoutManager(new LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false));
        holder.recyclerView.setAdapter(adapter);
    }


    @Override
    public int getItemCount() {
        return items.size();
    }

    @Override
    public int getItemViewType(int position) {
        if (items.get(position) instanceof SingleVertical)
            return VERTICAL;
        if (items.get(position) instanceof SingleHorizontal)
            return HORIZONTAL;
        if (items.get(position) instanceof Film)
            return FILM;
        return -1;
    }

    public class HorizontalViewHolder extends RecyclerView.ViewHolder {

        RecyclerView recyclerView;

        HorizontalViewHolder(View itemView) {
            super(itemView);
            recyclerView = (RecyclerView) itemView.findViewById(R.id.inner_recyclerView);
        }
    }

    public class VerticalViewHolder extends RecyclerView.ViewHolder {
        RecyclerView recyclerView;

        VerticalViewHolder(View itemView) {
            super(itemView);
            recyclerView = (RecyclerView) itemView.findViewById(R.id.inner_recyclerView);
        }
    }
    public class FilmViewHolder extends RecyclerView.ViewHolder {

        RecyclerView recyclerView;

        FilmViewHolder(View itemView) {
            super(itemView);
            recyclerView = (RecyclerView) itemView.findViewById(R.id.inner_recyclerView);
        }
    }

}
