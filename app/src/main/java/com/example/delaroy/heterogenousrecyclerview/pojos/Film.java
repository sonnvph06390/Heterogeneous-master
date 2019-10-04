package com.example.delaroy.heterogenousrecyclerview.pojos;

public class Film {
    private int imageFilm;
    private String tvTitleFilm;
    private String tvAct;

    public Film(int imageFilm, String tvTitleFilm, String tvAct) {
        this.imageFilm = imageFilm;
        this.tvTitleFilm = tvTitleFilm;
        this.tvAct = tvAct;
    }

    public Film() {
    }

    public int getImageFilm() {
        return imageFilm;
    }

    public void setImageFilm(int imageFilm) {
        this.imageFilm = imageFilm;
    }

    public String getTvTitleFilm() {
        return tvTitleFilm;
    }

    public void setTvTitleFilm(String tvTitleFilm) {
        this.tvTitleFilm = tvTitleFilm;
    }

    public String getTvAct() {
        return tvAct;
    }

    public void setTvAct(String tvAct) {
        this.tvAct = tvAct;
    }
}
