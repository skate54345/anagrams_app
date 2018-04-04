package com.austin.anagrams;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Challenges extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_challenges);

        Button challenge1Button = (Button)findViewById(R.id.Challenge1);
        Button challenge2Button = (Button)findViewById(R.id.Challenge2);
        Button challenge3Button = (Button)findViewById(R.id.Challenge3);

        challenge1Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((Global) getApplication()).setChallengeNum(1); //sets challenge to 1
                startActivity(new Intent(Challenges.this, Challenge1.class));
            }
        });

        challenge2Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((Global) getApplication()).setChallengeNum(2); //sets challenge to 2
                startActivity(new Intent(Challenges.this, Challenge1.class));
            }
        });

        challenge3Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((Global) getApplication()).setChallengeNum(3); //sets challenge to 3
                startActivity(new Intent(Challenges.this, Challenge1.class));
            }
        });
    }
}
