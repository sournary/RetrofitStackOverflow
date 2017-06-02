package com.example.sournary.retrofitstackoverflow.api;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by sournary on 01/06/2017.
 */

public class Service {

    public static StackexchangeAPI getStackexchangeAPI() {
        return new Retrofit.Builder()
                .baseUrl(StackexchangeAPI.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(StackexchangeAPI.class);
    }

}
