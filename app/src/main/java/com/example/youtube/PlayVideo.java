package com.example.youtube;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;

import com.google.android.youtube.player.YouTubePlayerSupportFragment;

import java.util.ArrayList;

public class PlayVideo extends Fragment {
    private String API="Please use your own API";
    YouTubePlayer mplayer;
    VideoData videoData;
    TextView videoTitle;
    TextView chaneltitle;
    private RecyclerView RecyclerView;
    private RecyclerView.LayoutManager layoutManager;
    private RecyclerView.Adapter adapter = null;
    private   ArrayList<VideoData> videoDataArrayList;
    String newVideoid="";
    String title="";
    String chanelTitle="";

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.play_video, container, false);





return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
RecyclerView=view.findViewById(R.id.Recycler);
        layoutManager=new LinearLayoutManager(getActivity());
        RecyclerView.setLayoutManager(layoutManager);
        videoTitle=view.findViewById(R.id.videoTitle);
        chaneltitle=view.findViewById(R.id.chanelTitle);
        Bundle bundle = getArguments();
        videoData = (VideoData) bundle.getSerializable("videoID");
        videoDataArrayList  = (ArrayList<VideoData>) bundle.getSerializable("listVideos");
        System.out.println("size of new array"+videoDataArrayList.size());
        newVideoid = videoData.getVideoID();
chanelTitle=videoData.getChannel();
        title=videoData.getTitle();
        videoTitle.setText(title);
        chaneltitle.setText(chanelTitle);
        System.out.println(newVideoid);
        Youtube();
        getData();



    }



    public void Youtube(){
        YouTubePlayerSupportFragment youTubePlayerFragment = YouTubePlayerSupportFragment.newInstance();
        FragmentTransaction transaction = getChildFragmentManager().beginTransaction();
        transaction.add(R.id.youtube_layout, youTubePlayerFragment).commit();


        youTubePlayerFragment.initialize(API, new YouTubePlayer.OnInitializedListener() {


            @Override
            public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer player, boolean wasRestored) {
                if (!wasRestored) {
                    mplayer=player;
                    mplayer.setPlayerStyle(YouTubePlayer.PlayerStyle.DEFAULT);
                  mplayer.loadVideo(newVideoid);

                    mplayer.play();
                }
            }


            @Override
            public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult error) {
                // YouTube error
                String errorMessage = error.toString();
                Toast.makeText(getActivity(), errorMessage, Toast.LENGTH_LONG).show();
                Log.d("errorMessage:", errorMessage);
            }
        });



    }

    public void getData(){

        adapter=new RecyclerAdapter(videoDataArrayList, getActivity(), new ICustomClick() {
            @Override
            public void onCustomClick(VideoData dataProvider, View view) {
                newVideoid=dataProvider.getVideoID();
                title=dataProvider.getTitle();
                chanelTitle=dataProvider.getChannel();
                System.out.println(newVideoid);
                videoTitle.setText(title);
                chaneltitle.setText(chanelTitle);
             mplayer.loadVideo(newVideoid);
             mplayer.play();
            }
        });
        RecyclerView.setAdapter(adapter);
    }



}
