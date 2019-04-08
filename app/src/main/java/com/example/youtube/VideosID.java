package com.example.youtube;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

class VideosID {
    @SerializedName("videoId")
    @Expose
    private String videoId;

    public VideosID(String videoId) {
        this.videoId = videoId;
    }

    public String getVideoId() {
        return videoId;
    }
}
