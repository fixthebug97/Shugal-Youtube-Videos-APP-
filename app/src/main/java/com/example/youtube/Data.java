package com.example.youtube;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

class Data {
    @SerializedName("items")
    @Expose
    private ArrayList<Items> items;

    public Data(ArrayList<Items> items) {
        this.items = items;
    }

    public ArrayList<Items> getItems() {
        return items;
    }
}
