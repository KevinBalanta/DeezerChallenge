package com.example.deezerchallenge.items;

import com.example.deezerchallenge.model.PlayList;

import java.io.Serializable;
import java.util.ArrayList;

public class PlaylistDTO implements Serializable {

    private ArrayList<PlayList> data;

    public PlaylistDTO(ArrayList<PlayList> data) {
        this.data = data;
    }

    public ArrayList<PlayList> getData() {
        return data;
    }

    public void setData(ArrayList<PlayList> data) {
        this.data = data;
    }
}
