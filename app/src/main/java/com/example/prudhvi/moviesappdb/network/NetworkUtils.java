package com.example.prudhvi.moviesappdb.network;


import android.net.Uri;

public class NetworkUtils
{
    private static final String BASE_URI =
            "https://api.moviedb.org/3/discover/movie?";
    private static final String KEY = "sort_by";
    private static final String API_KEY = "api_key";
    //private static final String QUERY = "q";
    public static Uri buildUri()
    {
        Uri finalUri = Uri.parse(BASE_URI).buildUpon()
                .appendQueryParameter(KEY,"popular")
                .appendQueryParameter(API_KEY,"a2ae95b3c083c023197df998e1ef4475")
                .build();
        return finalUri;
    }
    public String buildImageString(String select){
        return "https://image.tmdb.org/t/p/w185"+select+"?"+API_KEY+"a2ae95b3c083c023197df998e1ef4475";
    }

}
