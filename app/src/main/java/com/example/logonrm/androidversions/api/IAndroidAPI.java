package com.example.logonrm.androidversions.api;

import com.example.logonrm.androidversions.models.ResponseAndroid;

import retrofit2.Call;
import retrofit2.Response;
import retrofit2.http.GET;

public interface IAndroidAPI {
    //http://www.mocky.io/v2/58af1fb21000001e1cc94547
    @GET("/v2/58af1fb21000001e1cc94547")
    Call<ResponseAndroid> GetVersions();
}
