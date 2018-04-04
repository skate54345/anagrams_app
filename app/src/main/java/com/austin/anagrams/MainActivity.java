package com.austin.anagrams;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.IBinder;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.media.MediaPlayer;

import static com.austin.anagrams.MusicManager.mPlayer;

public class MainActivity extends AppCompatActivity {

    MusicManager mm;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mm = new MusicManager(this, R.raw.anagrams_music);;
        mm.play();

        Button challengeButton = (Button) findViewById(R.id.Challenges);
        Button aboutButton = (Button) findViewById(R.id.About);
        Button settingsButton = (Button) findViewById(R.id.Settings);

        challengeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, Challenges.class));
            }

        });

        aboutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, About.class));
            }

        });

        settingsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, Settings.class));
            }

        });
    }
    @Override
    protected void onDestroy(){
        super.onDestroy();
        mPlayer.stop();
    }

    public void onBackPressed(){
        mPlayer.stop();
        finish();
        System.exit(0); //Stops Music
    }
}

