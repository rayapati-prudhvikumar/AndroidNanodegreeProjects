package com.example.prudhvi.moviesappdb;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class Second extends AppCompatActivity {
    ImageView img2;
    TextView t1;
    TextView t2;
    TextView t3;
    TextView t4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        setContentView(R.layout.activity_second);

        //getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
        // WindowManager.LayoutParams.FLAG_FULLSCREEN);
        //getSupportActionBar().hide();
        img2 = findViewById(R.id.imageView2);
        t1=findViewById(R.id.title1);
        t2=findViewById(R.id.rating);
        t3=findViewById(R.id.overview);
        t4=findViewById(R.id.releasedate);
        Intent intent = getIntent();
        String url = intent.getStringExtra("KEY");
        String final_url="http://image.tmdb.org/t/p/w342/"+url;
        String i1=intent.getStringExtra("Key1");
        String i2=intent.getStringExtra("Key2");
        String i3=intent.getStringExtra("Key3");
        String i4=intent.getStringExtra("Key4");

        //Glide.with(this).load(final_url).into(img2);

        Picasso.with(this).load(final_url).into(img2);



        t1.setText("OverView:"+i1);
        t2.setText("Title:"+i2);
        t3.setText("Rating:"+i3);
        t4.setText("Release Date:"+i4);
    }
}