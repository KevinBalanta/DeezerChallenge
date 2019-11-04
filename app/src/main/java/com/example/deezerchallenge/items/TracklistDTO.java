package com.example.deezerchallenge.items;

import com.example.deezerchallenge.model.Track;

import java.io.Serializable;
import java.util.ArrayList;

public class TracklistDTO implements Serializable {

    private ArrayList<Track> data;

    public TracklistDTO(ArrayList<Track> data) {
        this.data = data;
    }

    public ArrayList<Track> getData() {
        return data;
    }

    public void setData(ArrayList<Track> data) {
        this.data = data;
    }
}
