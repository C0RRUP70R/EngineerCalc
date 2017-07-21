package com.example.bptestingapp;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.example.bptestingapp.activities.CogwheelCalc;
import com.example.bptestingapp.activities.ForceCalc;
import com.example.bptestingapp.activities.RotCalc;
import com.example.bptestingapp.activities.TensionCalc;
import com.example.bptestingapp.activities.ToleranceCalc;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void startRotActivity (View view){
        Intent intent = new Intent(this, RotCalc.class);
        startActivity(intent);
    }

    public void startForceActivity (View view){
        Intent intent = new Intent(this, ForceCalc.class);
        startActivity(intent);
    }

    public void startTensionActivity(View view){
        Intent intent = new Intent(this, TensionCalc.class);
        startActivity(intent);
    }

    public void startToleranceActivity(View view){
        Intent intent = new Intent(this, ToleranceCalc.class);
        startActivity(intent);
    }

    public void startCogwheelActivity(View view){
        Intent intent = new Intent(this, CogwheelCalc.class);
        startActivity(intent);
    }

    public static String MESSAGE_MAIN = "message";
    public static String MESSAGE_TYPE = "type";
    public static String MESSAGE_SIDE = "side";
    public static String MESSAGE_SIDE2 = "side2";
}
