package com.example.youtube;

import java.io.Serializable;

public class VideoData implements Serializable {

    private String imageUrl;
    private String title;
    private String channel;
    private String description;
    private String videoID;

    public VideoData(String imageUrl, String title, String channel, String description, String videoID) {
        this.imageUrl = imageUrl;
        this.title = title;
        this.channel = channel;
        this.description = description;
        this.videoID = videoID;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public String getTitle() {
        return title;
    }

    public String getChannel() {
        return channel;
    }

    public String getDescription() {
        return description;
    }

    public String getVideoID() {
        return videoID;
    }
}
