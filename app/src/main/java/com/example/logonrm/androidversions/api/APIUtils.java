package com.example.logonrm.androidversions.api;

import com.example.logonrm.androidversions.models.Android;

/**
 * Created by logonrm on 21/06/2017.
 */

public class APIUtils {
    public static final String BASE_URL = "http://www.mocky.io";

    public static IAndroidAPI getAndroidAPI() {
        return  RetrofitClient.getClient(BASE_URL)
                .create(IAndroidAPI.class);
    }
}
