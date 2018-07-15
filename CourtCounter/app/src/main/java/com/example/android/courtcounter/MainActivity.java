package com.example.android.courtcounter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    int scoreTeamA = 0;
    int scoreTeamB = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.i("working" ,scoreTeamA + " " + scoreTeamB);
        displayForTeamA(scoreTeamA);
        displayForTeamB(scoreTeamB);
    }
    /**
     * Displays the given score for Team A.
     */
    public void displayForTeamA(int score) {
        TextView scoreView = (TextView) findViewById(R.id.team_a_score);
        scoreView.setText(String.valueOf(score));
    }

    /*+3 button*/
    public void add3TeamA( View view ) {
        scoreTeamA += 3;
        displayForTeamA(scoreTeamA);
    }

    /*+2 button*/
    public void add2TeamA( View view )
    {
        scoreTeamA += 2;
        displayForTeamA(scoreTeamA);
    }

    /*+1 button*/
    public void freeThrowTeamA( View view ) {
        scoreTeamA += 1;
        displayForTeamA(scoreTeamA);
    }


    /**
     * Displays the given score for Team B
     */
    public void displayForTeamB(int score) {
        TextView scoreView2 = (TextView) findViewById(R.id.team_b_score);
        scoreView2.setText(String.valueOf(score));
    }

    /*+3 button*/

    public void add3TeamB( View view ) {
        scoreTeamB += 3;
        displayForTeamB(scoreTeamB);
    }

    /*+2 button*/
    public void add2TeamB( View view )
    {
        scoreTeamB += 2;
        displayForTeamB(scoreTeamB);
    }

    /*+1 button*/
    public void freeThrowTeamB( View view ) {
        scoreTeamB += 1;
        displayForTeamB(scoreTeamB);
    }

    public void resetButton(View view){
        scoreTeamA = 0;
        scoreTeamB = 0;

        displayForTeamA(scoreTeamA);
        displayForTeamB(scoreTeamB);
    }



}
