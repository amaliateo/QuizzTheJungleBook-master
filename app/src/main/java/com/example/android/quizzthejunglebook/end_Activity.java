package com.example.android.quizzthejunglebook;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class end_Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_end_);
    }
    //go back to the main layout
    public void backButton(View view){
        Intent b = new Intent (this, MainActivity.class);
        startActivity(b);
    }
}
