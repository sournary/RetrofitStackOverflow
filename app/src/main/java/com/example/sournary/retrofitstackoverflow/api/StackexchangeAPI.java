package com.example.sournary.retrofitstackoverflow.api;

import com.example.sournary.retrofitstackoverflow.model.Stackexchange;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by sournary on 31/05/2017.
 */

public interface StackexchangeAPI {

    String BASE_URL = "https://api.stackexchange.com";

    @GET("/2.2/answers?order=desc&sort=activity&site=stackoverflow")
    Call<Stackexchange> getAnswers();

    @GET("/2.2/answers?order=desc&sort=activity&site=stackoverflow")
    Call<Stackexchange> getAnswers(@Query("tagged") String tags);


}
