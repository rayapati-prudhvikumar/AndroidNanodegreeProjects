package com.example.prudhvi.moviesappdb.allpojos;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class TheMovieDBJsonUtils {

    public static MovieInfo[] getMovieInfoArrayFromJson(String jsonResponseString) throws JSONException {

        final String TMDB_RESULTS = "results";
        final String TMDB_ORIGINAL_TITLE = "original_title";
        final String TMDB_POSTER_PATH = "poster_path";
        final String TMDB_USER_RATING = "vote_average";
        final String TMDB_ID = "id";
        final String TMDB_PLOT_SYNOPSIS = "overview";
        final String TMDB_RELEASE_DATE = "release_date";


        JSONArray resultsJsonArray = new JSONObject(jsonResponseString).getJSONArray(TMDB_RESULTS);

        MovieInfo[] movieInfoArray = new MovieInfo[resultsJsonArray.length()];

        for (int i = 0; i < resultsJsonArray.length(); i++) {

            MovieInfo movieInfo = new MovieInfo();

            JSONObject movieInfoJson = (JSONObject) resultsJsonArray.get(i);

            movieInfo.setId(movieInfoJson.getInt(TMDB_ID));
            movieInfo.setOriginalTitle(movieInfoJson.getString(TMDB_ORIGINAL_TITLE));
            movieInfo.setPlotSynopsis(movieInfoJson.getString(TMDB_PLOT_SYNOPSIS));
            movieInfo.setPosterUrl("http://image.tmdb.org/t/p/w185"+movieInfoJson.getString(TMDB_POSTER_PATH));
            movieInfo.setUserRating(movieInfoJson.getDouble(TMDB_USER_RATING));
            movieInfo.setReleaseDate(movieInfoJson.getString(TMDB_RELEASE_DATE));

            movieInfoArray[i] = movieInfo;
        }

        return movieInfoArray;

    }
}
