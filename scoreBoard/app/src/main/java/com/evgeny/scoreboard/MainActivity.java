package com.evgeny.scoreboard;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    public final static String teamOne="teamOne";
    public final static String teamTwo="teamTwo";
    private String numberGoalsTeamOne="0";
    private String numberGoalsTeamTwo="0";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if(savedInstanceState != null){
            TextView teamOneScore = (TextView)findViewById(R.id.firstTeam);
            TextView teamTwoScore = (TextView)findViewById(R.id.secondTeam);
            teamOneScore.setText(savedInstanceState.getString(teamOne));
            teamTwoScore.setText(savedInstanceState.getString(teamTwo));
            numberGoalsTeamOne = savedInstanceState.getString(teamOne);
            numberGoalsTeamTwo = savedInstanceState.getString(teamTwo);
        }
    }
    public void goalTeamOne(View view){
        TextView textView = (TextView)findViewById(R.id.firstTeam);
        int tmp = Integer.parseInt(textView.getText().toString());
        tmp++;
        textView.setText(String.valueOf(tmp));
        numberGoalsTeamOne=String.valueOf(tmp);
    }
    public void goalTeamTwo(View view){
        TextView textView = (TextView)findViewById(R.id.secondTeam);
        int tmp = Integer.parseInt(textView.getText().toString());
        tmp++;
        textView.setText(String.valueOf(tmp));
        numberGoalsTeamTwo = String.valueOf(tmp);
    }
    public void clearScoreBoard(View view){
        TextView teamOneScore = (TextView)findViewById(R.id.firstTeam);
        teamOneScore.setText("0");
        TextView teamTwoScore = (TextView)findViewById(R.id.secondTeam);
        teamTwoScore.setText("0");
        numberGoalsTeamOne = "0";
        numberGoalsTeamTwo = "0";
    }

    @Override
    public void onSaveInstanceState(Bundle saveInstanceState) {
        super.onSaveInstanceState(saveInstanceState);
        saveInstanceState.putString(teamOne, numberGoalsTeamOne);
        saveInstanceState.putString(teamTwo, numberGoalsTeamTwo);

    }
}