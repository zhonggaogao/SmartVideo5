package com.example.g1620731.smartvideo;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.VideoView;
import java.io.File;
import android.widget.ImageButton;
import android.widget.TextView;
import android.content.Intent;
import android.view.Window;
import android.view.WindowManager;


public class HomePageActivity extends Activity {
    private ImageButton ImageButton_movie=null;
    private ImageButton ImageButton_series=null;
    private ImageButton ImageButton_documentary=null;
    private ImageButton ImageButton_sport=null;
    private ImageButton ImageButton_music=null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);//去掉应用标题
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_home_page);
        ImageButton_movie= (ImageButton) findViewById(R.id.ImageButton_movie);
        ImageButton_series= (ImageButton) findViewById(R.id.ImageButton_series);
        ImageButton_documentary= (ImageButton) findViewById(R.id.ImageButton_documentary);
        ImageButton_sport= (ImageButton) findViewById(R.id.ImageButton_sport);
        ImageButton_music= (ImageButton) findViewById(R.id.ImageButton_music);
        ImageButton_movie.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomePageActivity.this, MainActivity.class);
                startActivity(intent);;
                finish();
            }
        });

        ImageButton_series.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomePageActivity.this, SeriesActivity.class);
                startActivity(intent);;
                finish();
            }
        });
        ImageButton_documentary.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomePageActivity.this, DocumentaryActivity.class);
                startActivity(intent);;
                finish();
            }
        });
        ImageButton_sport.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomePageActivity.this, MainActivity.class);
                startActivity(intent);;
                finish();
            }
        });
        ImageButton_music.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomePageActivity.this, MainActivity.class);
                startActivity(intent);;
                finish();
            }
        });
    }

}
