package com.example.deezerchallenge.model;

import com.example.deezerchallenge.items.TracklistDTO;

import java.io.Serializable;

public class PlayList implements Serializable {

    private long id;

    private  User user;

    private  String picture_small;

    private  String title;

    private  int fans;

    private  int nb_tracks;

    private  String description;

    private TracklistDTO tracks;


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getPicture_small() {
        return picture_small;
    }

    public void setPicture_small(String picture_small) {
        this.picture_small = picture_small;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getFans() {
        return fans;
    }

    public void setFans(int fans) {
        this.fans = fans;
    }

    public int getNb_tracks() {
        return nb_tracks;
    }

    public void setNb_tracks(int nb_tracks) {
        this.nb_tracks = nb_tracks;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public TracklistDTO getTracks() {
        return tracks;
    }

    public void setTracks(TracklistDTO tracks) {
        this.tracks = tracks;
    }
}
