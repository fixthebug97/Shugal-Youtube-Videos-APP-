package com.example.youtube;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

class Snippet {
    @SerializedName("title")
    @Expose
    private String title;

    @SerializedName("description")
    @Expose
    private String description;

    @SerializedName("channelTitle")
    @Expose
    private String channelTitle;


    @SerializedName("thumbnails")
    @Expose
    private Thumbnail thumbnails;

    public Snippet(String title, String description, String channelTitle, Thumbnail thumbnails) {
        this.title = title;
        this.description = description;
        this.channelTitle = channelTitle;
        this.thumbnails = thumbnails;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getChannelTitle() {
        return channelTitle;
    }

    public Thumbnail getThumbnails() {
        return thumbnails;
    }
}
