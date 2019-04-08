package com.example.youtube;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

class Items {
    @SerializedName("id")
    @Expose
    private VideosID id;

    @SerializedName("snippet")
    @Expose
    private Snippet snippet;

    public Items(VideosID id, Snippet snippet) {
        this.id = id;
        this.snippet = snippet;
    }

    public VideosID getId() {
        return id;
    }

    public Snippet getSnippet() {
        return snippet;
    }
}
