package com.example.youtube;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

class Medium {
    @SerializedName("url")
    @Expose
    private String url;

    public Medium(String url) {
        this.url = url;
    }

    public String getUrl() {
        return url;
    }
}
