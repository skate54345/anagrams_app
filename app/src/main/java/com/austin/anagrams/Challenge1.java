package com.austin.anagrams;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Challenge1 extends AppCompatActivity {

    //initializes counters and string
    int enterPresses = 0;
    int userPoints = 0;
    String guess1 = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_challenge1);

        final Button enterButton = (Button)findViewById(R.id.Enter);
        final EditText userInput = (EditText) findViewById(R.id.editText);
        final TextView instructions = (TextView) findViewById(R.id.instructions);
        final TextView puzzleword = (TextView) findViewById(R.id.puzzleword);
        final TextView challengeText = (TextView) findViewById(R.id.challengeTextView);
        Global app = (Global) getApplication(); //grabs necessary global data
        final int currentChallenge = app.getChallengeNum(); //sets current challenge number

        switch (currentChallenge){
            case 1: puzzleword.setText("LOOPED");
                    challengeText.setText("Challenge 1");
                    break;
            case 2: puzzleword.setText("BELOW");
                    challengeText.setText("Challenge 2");
                    break;
            case 3: puzzleword.setText("REMAIN");
                    challengeText.setText("Challenge 3");
                    break;
        }

        enterButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (userInput.getText().toString().isEmpty()||userInput.getText().toString().equals(guess1)) {//if empty or used word
                    Context context = getApplicationContext(); //needed this for toast to work?
                    Toast toast = Toast.makeText(context, "Please enter a valid word.", Toast.LENGTH_SHORT); //makes toast to show submitted
                    toast.setGravity(Gravity.TOP, 0, 0);
                    toast.show();
                } else if (currentChallenge == 1) {
                    if (userInput.getText().toString().toUpperCase().equals("POODLE") || userInput.getText().toString().toUpperCase().equals("POOLED")) {
                        Context context = getApplicationContext(); //needed this for toast to work?
                        Toast toast = Toast.makeText(context, "Correct.", Toast.LENGTH_SHORT); //makes toast to show submitted
                        toast.setGravity(Gravity.TOP, 0, 0);
                        toast.show();
                        enterPresses++;
                        userPoints++;
                        guess1 = userInput.getText().toString();
                    }
                    else {
                        Context context = getApplicationContext(); //needed this for toast to work?
                        Toast toast = Toast.makeText(context, "WRONG!", Toast.LENGTH_SHORT); //makes toast to show submitted
                        toast.setGravity(Gravity.TOP, 0, 0);
                        toast.show();
                        enterPresses++;
                        guess1 = userInput.getText().toString();

                    }
                } else if (currentChallenge == 2) {
                    if (userInput.getText().toString().toUpperCase().equals("ELBOW") || userInput.getText().toString().toUpperCase().equals("BOWEL")) {
                        Context context = getApplicationContext();
                        Toast toast = Toast.makeText(context, "Correct.", Toast.LENGTH_SHORT);
                        toast.setGravity(Gravity.TOP, 0, 0);
                        toast.show();
                        enterPresses++;
                        userPoints++;
                        guess1 = userInput.getText().toString();
                    }
                    else {
                        Context context = getApplicationContext(); //needed this for toast to work?
                        Toast toast = Toast.makeText(context, "WRONG!", Toast.LENGTH_SHORT); //makes toast to show submitted
                        toast.setGravity(Gravity.TOP, 0, 0);
                        toast.show();
                        enterPresses++;
                        guess1 = userInput.getText().toString();
                    }
                }
                else if (currentChallenge == 3) {
                    if (userInput.getText().toString().toUpperCase().equals("AIRMEN") || userInput.getText().toString().toUpperCase().equals("MARINE")) {
                        Context context = getApplicationContext();
                        Toast toast = Toast.makeText(context, "Correct.", Toast.LENGTH_SHORT);
                        toast.setGravity(Gravity.TOP, 0, 0);
                        toast.show();
                        enterPresses++;
                        userPoints++;
                        guess1 = userInput.getText().toString();
                    }
                    else {
                        Context context = getApplicationContext(); //needed this for toast to work?
                        Toast toast = Toast.makeText(context, "WRONG!", Toast.LENGTH_SHORT); //makes toast to show submitted
                        toast.setGravity(Gravity.TOP, 0, 0);
                        toast.show();
                        enterPresses++;
                        guess1 = userInput.getText().toString();
                    }
                }

                userInput.setText(""); //clears text

                if (enterPresses >= 2) { //extra personalization
                    enterButton.setVisibility(View.INVISIBLE);
                    userInput.setVisibility(View.INVISIBLE);
                    instructions.setVisibility(View.INVISIBLE);
                    String str2;
                    if(userPoints == 2){
                        str2 = "Good Job.";
                    }
                    else if(userPoints == 1){
                        str2 = "Do better next time.";
                    }
                    else{
                        str2 = "You're a loser!";
                    }
                    String newStr = String.format("You scored: %d/%d.\n" + str2, userPoints,enterPresses); //gives score
                    puzzleword.setText(newStr);
                }
            }
        });
    }
}
