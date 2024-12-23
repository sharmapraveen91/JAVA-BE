package com.praveen.movieInfo.model;

public class MovieInfo {
    private String movieId;
    private String Desc;

    public MovieInfo(String movieId, String desc) {
        this.movieId = movieId;
        Desc = desc;
    }

    public String getMovieId() {
        return movieId;
    }

    public void setMovieId(String movieId) {
        this.movieId = movieId;
    }

    public String getDesc() {
        return Desc;
    }

    public void setDesc(String desc) {
        Desc = desc;
    }
}
