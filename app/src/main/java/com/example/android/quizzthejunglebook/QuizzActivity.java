package com.example.android.quizzthejunglebook;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class QuizzActivity extends AppCompatActivity {
    int total = 0;

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

        Intent c = new Intent(this, finalPage.class);
        c.putExtra("total", total);
        c.putExtra("name", Congrats);
        startActivity(c);
    }

    //add the correct answers
    private int calculatePoints(int total) {
        //checks the answer for question One
        RadioButton button1 = (RadioButton) findViewById(R.id.qOneVarOne);
        if (button1.isChecked()) {
            total = total + 1;
        }
        //checks the answer for question Two
        EditText answerText = (EditText) findViewById(R.id.qTwoVarOne);
        String answer = answerText.getText().toString();
        if (answer.equals("KAA")) {
            total = total + 1;
        }
        //checks the answer for question Three
        CheckBox checkOne = (CheckBox) findViewById(R.id.qThreeVarTwo);
        CheckBox checkTwo = (CheckBox) findViewById(R.id.qThreeVarFour);
        if (checkOne.isChecked() && checkTwo.isChecked()) {
            total = total + 1;
        }
        //checks the answer for question four
        RadioButton buttonFour = (RadioButton) findViewById(R.id.qFourVarFour);
        if (buttonFour.isChecked()) {
            total = total + 1;
        }
        RadioButton buttonFive = (RadioButton) findViewById(R.id.qFiveVarThree);
        if (buttonFive.isChecked()) {
            total = total + 1;
        }
        return total;
    }


}
