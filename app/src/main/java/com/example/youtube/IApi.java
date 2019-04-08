package com.example.youtube;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Query;

public interface IApi {



    @GET("/youtube/v3/search")
    Call<Data> getSearch(

            @Query("part") String part,
            @Query("maxResults") int max,
            @Query("q") String q,
            @Query("key") String key


    );
}
