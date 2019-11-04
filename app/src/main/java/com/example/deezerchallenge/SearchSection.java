package com.example.deezerchallenge;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.deezerchallenge.adapters.AdapterPlayList;
import com.example.deezerchallenge.items.PlaylistDTO;
import com.example.deezerchallenge.model.PlayList;
import com.example.deezerchallenge.util.HTTPSWebUtilDomi;
import com.google.gson.Gson;

import java.io.IOException;

public class SearchSection extends AppCompatActivity {

    private Button searchBut;
    private TextView etPlaylist;
    private Button backBut;
    private ListView listPlayList;
    private AdapterPlayList adapterPlaylist;
    private PlayList choosed;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_section);

        searchBut = findViewById(R.id.but_search);
        etPlaylist = findViewById(R.id.et_search);
        backBut = findViewById(R.id.back_but);
        listPlayList = findViewById(R.id.list_play);
        adapterPlaylist = new AdapterPlayList();
        listPlayList.setAdapter(adapterPlaylist);
        searchBut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                    Gson gson = new Gson();
                String search = etPlaylist.getText().toString();

                    Toast.makeText(getApplicationContext(), search, Toast.LENGTH_LONG).show();
                    new Thread(()-> {
                        try {
                        HTTPSWebUtilDomi dominicHttp = new HTTPSWebUtilDomi();

                        String response = dominicHttp.GETrequest("https://api.deezer.com/search/playlist?q=" + search);

                        PlaylistDTO playlists = gson.fromJson(response, PlaylistDTO.class);

                        runOnUiThread(() ->
                        {
                            adapterPlaylist.setPlayLists(playlists.getData());
                        });
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    }).start();







            }
        });

        backBut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(i);

            }
        });

        listPlayList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                Long id=adapterPlaylist.getItemId(i);
                Intent intent = new Intent(getApplicationContext(), PlaylistActivity.class);
                Gson gson = new Gson();
                new Thread(()->{
                    try {
                        HTTPSWebUtilDomi utilDominic = new HTTPSWebUtilDomi();
                        String response= utilDominic.GETrequest("https://api.deezer.com/playlist/"+id);

                        runOnUiThread(()->{

                            Log.println(Log.ERROR, ">>>>>", response);
                            choosed= gson.fromJson(response,PlayList.class);
                            intent.putExtra("choosed",choosed);
                            startActivity(intent);
                        });

                    }catch (IOException ex){
                        ex.printStackTrace();
                    }
                }).start();

            }
        });
    }
}
