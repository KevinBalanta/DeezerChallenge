package com.example.deezerchallenge.adapters;

import android.graphics.Bitmap;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.deezerchallenge.R;
import com.example.deezerchallenge.model.Track;
import com.squareup.picasso.Picasso;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class AdapterSongList extends BaseAdapter {

    private ArrayList<Track> tracks;

    private Bitmap image;


    public AdapterSongList(ArrayList<Track> tracks, Bitmap image) {
        this.tracks = tracks;
        this.image = image;
    }

    public AdapterSongList() {
        tracks = new ArrayList<>();
    }

    @Override
    public int getCount() {
        return tracks.size();
    }

    @Override
    public Object getItem(int i) {
        return tracks.get(i);
    }

    @Override
    public long getItemId(int i) {
        return tracks.get(i).getId();
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        LayoutInflater inflater = LayoutInflater.from(viewGroup.getContext());
        View rowView = inflater.inflate(R.layout.item_individualplaylist, null);
        ImageView rowImage = rowView.findViewById(R.id.img_song);
        TextView rowName = rowView.findViewById(R.id.nameSong);
        TextView rowViews = rowView.findViewById(R.id.nameArtist);
        TextView rowDesc = rowView.findViewById(R.id.yearSong);
        rowName.setText(tracks.get(i).getTitle_short());
        rowViews.setText(tracks.get(i).getArtist().getName());
        Long date=tracks.get(i).getTime_add()*1000;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date fecha=new Date(date);
        rowDesc.setText(sdf.format(fecha));
        Log.println(Log.ERROR, "SSERRR",tracks.get(i).getAlbum().getCover_small() );
        Picasso.get().load(tracks.get(i).getAlbum().getCover_small()).into(rowImage);

        return rowView;
    }

    public ArrayList<Track> getTracks() {
        return tracks;
    }

    public void setTracks(ArrayList<Track> tracks) {
        this.tracks = tracks;
        notifyDataSetChanged();
    }

    public Bitmap getImage() {
        return image;
    }

    public void setImage(Bitmap image) {
        this.image = image;
    }
}
