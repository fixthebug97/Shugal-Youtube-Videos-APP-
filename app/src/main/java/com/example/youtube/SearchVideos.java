package com.example.youtube ;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;


import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class SearchVideos extends Fragment {
EditText videoText;
Button search;
 String BASE_URL="https://www.googleapis.com";
private IApi iApi;
private String API="Please use your own API";

private String title="";
private  String channel="";
    private  String description="";
    private  String imageURL="";
    private  String videoID="";
    String text="";
    private RecyclerView myRecyclerView;
    private RecyclerView.LayoutManager layoutManager;
    private RecyclerView.Adapter adapter = null;
    ArrayList<VideoData> listOfVideos=new ArrayList<>();
    ArrayList<VideoData> listofData=new ArrayList<>();
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.search,container,false);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        videoText=view.findViewById(R.id.videoText);
        search=view.findViewById(R.id.search);

        Retrofit retrofit = new Retrofit.Builder().baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create()).build();

        iApi = retrofit.create(IApi.class);

myRecyclerView=view.findViewById(R.id.myRecyclerView);
layoutManager=new LinearLayoutManager(getActivity());
myRecyclerView.setLayoutManager(layoutManager);

System.out.println("size of list"+listofData.size());


        SearchVideos();
        adapter = new RecyclerAdapter(listofData, getActivity(), new ICustomClick() {
            @Override
            public void onCustomClick(VideoData dataProvider, View view) {

                ((INavigationListener)getActivity()).ToPlayVideos(dataProvider,view,listofData);
            }
        });

        myRecyclerView.setAdapter(adapter);






    }

    public void SearchVideos(){


        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                text =videoText.getText().toString();
                if(text.equals("")) {
                    Toast.makeText(getActivity(), "Please enter text", Toast.LENGTH_SHORT).show();
                }
                else {
                    listOfVideos.clear();
                    listofData.clear();
                    Call<Data> call = iApi.getSearch("snippet", 10, text, API);

                    call.enqueue(new Callback<Data>() {
                        @Override
                        public void onResponse(Call<Data> call, Response<Data> response) {
                            ArrayList<Items> items = response.body().getItems();

                            for (int i = 0; i < items.size(); i++) {
                                title = items.get(i).getSnippet().getTitle();
                                videoID = items.get(i).getId().getVideoId();
                                channel = items.get(i).getSnippet().getChannelTitle();
                                description = items.get(i).getSnippet().getDescription();
                                imageURL = items.get(i).getSnippet().getThumbnails().getMedium().getUrl();
                                VideoData videoData = new VideoData(imageURL, title, channel, description, videoID);

                                listOfVideos.add(videoData);
                            }

                            for (VideoData videoData : listOfVideos) {
                                videoData.getImageUrl();
                                videoData.getChannel();
                                videoData.getDescription();
                                videoData.getTitle();
                                videoData.getVideoID();
                                listofData.add(videoData);


                            }
                            adapter.notifyDataSetChanged();

                            System.out.println(listofData.size());
                        }


                        @Override
                        public void onFailure(Call<Data> call, Throwable t) {

                        }
                    });


                }

            }
        });
    }


}
