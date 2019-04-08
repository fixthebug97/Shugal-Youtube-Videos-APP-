package com.example.youtube;

import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import com.google.android.youtube.player.YouTubeBaseActivity;

import java.util.ArrayList;

import androidx.navigation.Navigation;

public class MainActivity extends AppCompatActivity implements INavigationListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }


    @Override
    public void ToSearchVideos(View view) {

        Navigation.findNavController(view).navigate(R.id.action_splahScreen_to_searchVideos);
    }

    @Override
    public void ToPlayVideos(VideoData videoData, View view, ArrayList<VideoData> videolist) {
        Bundle bundle=new Bundle();
        bundle.putSerializable("videoID",videoData);
        bundle.putSerializable("listVideos",videolist);
        Navigation.findNavController(view).navigate(R.id.action_searchVideos_to_playVideo,bundle);
    }


}
