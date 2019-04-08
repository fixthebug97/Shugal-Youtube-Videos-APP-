package com.example.youtube;

import android.view.View;

import java.util.ArrayList;

public interface INavigationListener {

    void ToSearchVideos(View view);
    void ToPlayVideos(VideoData videoData, View view, ArrayList<VideoData> videolist);

}
