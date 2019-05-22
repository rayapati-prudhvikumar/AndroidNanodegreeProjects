package com.example.prudhvi.moviesappdb;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.Configuration;
import android.net.ConnectivityManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Toolbar;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.prudhvi.moviesappdb.allpojos.Moviedb;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    Toolbar toolbar;
    String jsonData;
    String sortOrder = "popular";
    static final String SOME_VALUE = "int_value";
    static final String SOME_OTHER_VALUE = "string_value";
    String popularurl="https://api.themoviedb.org/3/movie/popular?api_key=c2b6226475df2f71cc1497d17ade7431";

    public List lists;
    TextView net;
    int someIntValue;
    String someStringValue;
    int  currentVisiblePosition = 0;
    private static final String MOVIE_INFO_ARRAY_KEY = "movie-info-array";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.recyclerview_id);
        net=findViewById(R.id.err);
        if(savedInstanceState!=null){
            jsonData = savedInstanceState.getString("KEY");
            setJsonDataOnRecyclerView(jsonData);
        }else if(!isNetworkConnected()){
            recyclerView.setVisibility(View.INVISIBLE);
            net.setVisibility(View.VISIBLE);
            //net.setText("checkkk");

        }else {

            net.setVisibility(View.INVISIBLE);
            if(savedInstanceState!=null){
                jsonData = savedInstanceState.getString("KEY");
            }
            String url="https://api.themoviedb.org/3/movie/popular?api_key=c2b6226475df2f71cc1497d17ade7431";
            Jsonvolley(url);
        }

    }


    private boolean isNetworkConnected() {
        ConnectivityManager cm = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        return cm.getActiveNetworkInfo() != null;
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        if(jsonData!=null) {
            outState.putString("KEY", jsonData);
        }
    }


    public Activity getActivity(){
        Context context=this;
        while (context instanceof ContextWrapper){
            if(context instanceof Activity){
                return (Activity)context;
            }
        }
        return null;
    }
    public void Jsonvolley(String url1){
        RequestQueue queue1 = Volley.newRequestQueue(this);
        StringRequest stringRequest1 = new StringRequest(Request.Method.GET, url1,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        setJsonDataOnRecyclerView(response);
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
        queue1.add(stringRequest1);
        Toast.makeText(getApplicationContext(), "Item 2 Selected", Toast.LENGTH_LONG).show();
    }

    private void setJsonDataOnRecyclerView(String response) {
        jsonData = response;
        Gson gson = new GsonBuilder().create();
        Moviedb movieResults = gson.fromJson(response,Moviedb.class);
        movieadapter fa = new movieadapter(MainActivity.this,movieResults.getResults());
        recyclerView.setAdapter(fa);
        //recyclerView.setLayoutManager(new GridLayoutManager(MainActivity.this,2));
        if (getActivity().getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT) {


            GridLayoutManager gridLayoutManager = new GridLayoutManager(MainActivity.this, 2);
            //gridLayoutManager.setReverseLayout(false);
            recyclerView.setLayoutManager(gridLayoutManager);
        } else {
            GridLayoutManager gridLayoutManager1 = new GridLayoutManager(MainActivity.this, 3);
            //gridLayoutManager.setReverseLayout(false);
            recyclerView.setLayoutManager(gridLayoutManager1);
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch (id) {
            case R.id.item1:
                //Movievolley m=new Movievolley(url);
                Jsonvolley(popularurl);
                return true;
            case R.id.item2:
                String popularurl="https://api.themoviedb.org/3/movie/top_rated?api_key=c2b6226475df2f71cc1497d17ade7431";
                Jsonvolley(popularurl);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
