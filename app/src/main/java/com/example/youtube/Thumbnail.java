package com.example.youtube;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

class Thumbnail {

    @SerializedName("medium")
    @Expose
    private Medium medium;

    public Thumbnail(Medium medium) {
        this.medium = medium;
    }

    public Medium getMedium() {
        return medium;
    }
}
