package com.example.deezerchallenge;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.deezerchallenge.adapters.AdapterSongList;
import com.example.deezerchallenge.model.PlayList;
import com.squareup.picasso.Picasso;

public class PlaylistActivity extends AppCompatActivity {


    private Button back_but;
    private ListView listView;
    private AdapterSongList adapterSongList;
    private ImageView imgPlaylist;
    private TextView namePlayList;
    private TextView description;
    private TextView numberSongs;
    private TextView numberFans;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_playlist);

        back_but = findViewById(R.id.back_but);
        listView = findViewById(R.id.list_playlist);
        adapterSongList = new AdapterSongList();
        listView.setAdapter(adapterSongList);
        imgPlaylist = findViewById(R.id.img_playlist);
        namePlayList = findViewById(R.id.name_PlayList);
        description = findViewById(R.id.descriptionTv);
        numberFans = findViewById(R.id.numberfansTv);
        numberSongs = findViewById(R.id.numbersongsTv);

        PlayList playList=null;

        Bundle parametros = this.getIntent().getExtras();

        if(parametros!=null){
            playList= (PlayList) getIntent().getExtras().get("choosed");
            Log.println(Log.ERROR, "ERRRRR", playList.getTitle());

            PlayList finalPlayList = playList;

            Picasso.get().load(finalPlayList.getPicture_small()).into(imgPlaylist);

            namePlayList.setText(finalPlayList.getTitle());
            description.setText(finalPlayList.getDescription());
            numberSongs.setText("# Songs : "+finalPlayList.getNb_tracks());
            numberFans.setText("# Fans : "+finalPlayList.getFans());

            new Thread(()->{

                runOnUiThread(()->{

                    adapterSongList.setTracks(finalPlayList.getTracks().getData());
                });

            }).start();


        }


        back_but.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), SearchSection.class);
                startActivity(intent);
            }
        });

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

            }
        });
    }
}
