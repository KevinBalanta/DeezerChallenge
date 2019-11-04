package com.example.deezerchallenge.adapters;

import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.deezerchallenge.R;
import com.example.deezerchallenge.model.PlayList;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class AdapterPlayList extends BaseAdapter {

    private ArrayList<PlayList> playLists;
    private Bitmap image;

    public AdapterPlayList(ArrayList<PlayList> playLists, Bitmap image) {
        this.playLists = playLists;
        this.image = image;
    }

    public AdapterPlayList() {
        playLists = new ArrayList<>();
    }

    @Override
    public int getCount() {
        return playLists.size();
    }

    @Override
    public Object getItem(int i) {
        return playLists.get(i);
    }

    @Override
    public long getItemId(int i) {
        return ((PlayList) playLists.get(i)).getId();
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        LayoutInflater inflater = LayoutInflater.from(viewGroup.getContext());
        View rowView = inflater.inflate(R.layout.item_playlist, null);
        ImageView rowImage = rowView.findViewById(R.id.imgPlaylist);
        TextView rowName = rowView.findViewById(R.id.namePlaylist);
        TextView rowViews = rowView.findViewById(R.id.nameUser);
        TextView rowDesc = rowView.findViewById(R.id.numberItem);
        rowName.setText(playLists.get(i).getTitle());
        rowViews.setText(playLists.get(i).getUser().getName());
        rowDesc.setText(""+ playLists.get(i).getNb_tracks());
        Picasso.get().load(playLists.get(i).getPicture_small()).into(rowImage);


        return rowView;
    }

    public ArrayList<PlayList> getPlayLists() {
        return playLists;
    }

    public void setPlayLists(ArrayList<PlayList> playLists) {
        this.playLists = playLists;
        notifyDataSetChanged();
    }

    public Bitmap getImage() {
        return image;
    }

    public void setImage(Bitmap image) {
        this.image = image;
    }
}
