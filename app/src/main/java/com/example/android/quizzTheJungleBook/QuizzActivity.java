package com.example.android.quizzTheJungleBook;

import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;


public class QuizzActivity extends AppCompatActivity {
    int total = 0;
    private MediaPlayer mMediaPlayer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.quizz);

    }

    //go to the show result layout
    public void finishQuizz(View view) {
        //get the name of the player from the main layout
        String Congrats = "";
        Bundle firstPage = getIntent().getExtras();
        if (firstPage != null) {
            Congrats = firstPage.getString("name");
        }
        //call the method to calculate the correct results
        total = calculatePoints(total);
        //show a simple toast with the result
        Toast.makeText(this, "You earned "+total+ " points", Toast.LENGTH_LONG).show();
        Intent c = new Intent(this, com.example.android.quizzTheJungleBook.finalPage.class);
        c.putExtra("total", total);
        c.putExtra("name", Congrats);
        startActivity(c);
    }

    //play song for forst question
    public void playMusic(View view) {
            mMediaPlayer = MediaPlayer.create(this, R.raw.bear);
            mMediaPlayer.start();
        }

    //add the correct answers
    private int calculatePoints(int total) {
        //checks the answer for question One
        RadioButton button1 = findViewById(R.id.qOneVarThree);
        if (button1.isChecked()) {
            total++;
            }
        //checks the answer for question Two
        EditText answerText = findViewById(R.id.qTwoVarOne);
        String answer = answerText.getText().toString();
        if (answer.equals("BALOO")) {
            total++;
            }

        //checks the answer for question Three
        CheckBox checkOne = findViewById(R.id.qThreeVarTwo);
        CheckBox checkTwo = findViewById(R.id.qThreeVarFour);
        CheckBox checkThree = (CheckBox) findViewById(R.id.qThreeVarOne);
        CheckBox checkFour = (CheckBox) findViewById(R.id.qThreeVarThree);
        if (checkOne.isChecked() && checkTwo.isChecked() &&!checkThree.isChecked() &&!checkFour.isChecked() ) {
            total++;
            }

        //checks the answer for question four
        RadioButton buttonFour = findViewById(R.id.qFourVarFour);
        if (buttonFour.isChecked()) {
            total++;
            }

        RadioButton buttonFive = findViewById(R.id.qFiveVarThree);
        if (buttonFive.isChecked()) {
            total++;
        }

        return total;
    }


}
