package com.example.saurabh.wikipediasearch;

import org.json.JSONObject;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface Api {

    String BASE_URL="https://en.wikipedia.org/w/";
    @GET("api.php")
    Call<GetWikipediaResponse>
    getWikipideaResponse(@Query("action") String action,
                         @Query("format") String format,
                         @Query("prop") String prop,
                         @Query("generator") String generator,
                         @Query("redirects") Integer redirects,
                         @Query("formatversion") String formatVersion,
                         @Query("piprop") String piprop,
                         @Query("pithumbsize") String pithumbsize,
                         @Query("pilimit") String pilimit,
                         @Query("wbptterms") String wbptterms,
                         @Query("gpssearch") String gpssearch,
                         @Query("gpslimit") String gpslimit);
}
