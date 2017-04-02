package com.evgeny.trafficlight;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.style.BackgroundColorSpan;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private Button rButton;
    private Button yButton;
    private Button gButton;

    private int color;

    private LinearLayout layout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rButton = (Button) findViewById(R.id.redButton);
        yButton = (Button) findViewById(R.id.yellowButton);
        gButton = (Button) findViewById(R.id.greenButton);
        layout = (LinearLayout) findViewById(R.id.Layout);

        rButton.setOnClickListener(this);
        yButton.setOnClickListener(this);
        gButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v){
        switch(v.getId()){
            case R.id.redButton:
                color=Color.RED;
                break;
            case R.id.yellowButton:
                color=Color.YELLOW;
                break;
            case R.id.greenButton:
                color=Color.GREEN;
                break;
        }
        resetUI();
    }

    protected void onSaveInstanceState (Bundle outState){
        super.onSaveInstanceState(outState);
        outState.putInt("bgColor", color);
    }

    protected void onRestoreInstanceState (Bundle savedInstanceState){
        super.onRestoreInstanceState(savedInstanceState);
        color=savedInstanceState.getInt("bgColor");
        resetUI();
    }

    public void resetUI(){
        layout.setBackgroundColor(color);
    }
}