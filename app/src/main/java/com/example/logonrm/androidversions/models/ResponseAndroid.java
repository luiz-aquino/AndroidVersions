package com.example.logonrm.androidversions.models;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by logonrm on 21/06/2017.
 */

public class ResponseAndroid {
    @SerializedName("android")
    private List<Android> android;

    public List<Android> getAndroid() {
        return android;
    }

    public void setAndroid(List<Android> android) {
        this.android = android;
    }
}
