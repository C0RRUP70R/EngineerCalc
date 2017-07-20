package com.example.bptestingapp.activities;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;

import com.example.bptestingapp.R;
import com.example.bptestingapp.calcFc;

import static com.example.bptestingapp.MainActivity.MESSAGE_MAIN;
import static com.example.bptestingapp.MainActivity.MESSAGE_TYPE;

public class RotCalc extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rot_calc);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
    }



    /**
     * Called when the user clicks the Send button
     */
    public void sendMessage(View view) {
        // Do something in response to
        Intent intent = new Intent(this, ResultActivity.class);
        //String EXTRA_MESSAGE = "";

        EditText editTextSpeed = (EditText) findViewById(R.id.edit_speed);
        EditText editTextDiameter = (EditText) findViewById(R.id.edit_diameter);

        String speed_str = editTextSpeed.getText().toString();
        String diameter_str = editTextDiameter.getText().toString();
        if (speed_str.length() == 0) {
            editTextSpeed.setError("Speed is required!");
        } else if (diameter_str.length() == 0) {
            editTextDiameter.setError("Diameter is required!");
        } else {
            Double Speed = Double.parseDouble(speed_str);
            Double Diameter = Double.parseDouble(diameter_str);

            String message = calcFc.countRot(Speed, Diameter) + " ot/min";
            intent.putExtra(MESSAGE_MAIN, message);
            intent.putExtra(MESSAGE_TYPE, "rot");
            startActivity(intent);
        }


    }

    public boolean onOptionsItemSelected(MenuItem item) {
        finish();
        return true;
    }
}
