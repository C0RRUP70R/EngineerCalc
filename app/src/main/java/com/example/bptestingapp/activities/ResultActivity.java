package com.example.bptestingapp.activities;


import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.bptestingapp.R;

import static com.example.bptestingapp.MainActivity.MESSAGE_MAIN;
import static com.example.bptestingapp.MainActivity.MESSAGE_SIDE;
import static com.example.bptestingapp.MainActivity.MESSAGE_SIDE2;
import static com.example.bptestingapp.MainActivity.MESSAGE_TYPE;
import static com.example.bptestingapp.auxiliary.auxFc.getTension;


public class ResultActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }


        Intent intent = getIntent();
        String message = intent.getStringExtra(MESSAGE_MAIN);
        String type = intent.getStringExtra(MESSAGE_TYPE);

        TextView textType = (TextView) findViewById(R.id.textType);
        TextView textOutput = (TextView) findViewById(R.id.textOutput);
        TextView mainText = (TextView) findViewById(R.id.mainText);
        switch (type) {
            case "rot":
                textType.setText("Optimální otáčky");
                mainText.setText("Otáčky:");
                textOutput.setText(message);
                break;
            case "force":
                textType.setText("Maximální zatížení");
                mainText.setText("Síla:");
                textOutput.setText(message + " N");
                break;
            case "tension":
                textType.setText("Vnitřní napětí materiálu");
                mainText.setText("Napětí");
                textOutput.setText(prepareOutput(message));
                prepareSpinner();
                setOutputTension();
                break;
        }
    }

    private void setOutputTension() {
        Intent intent = getIntent();
        String tens = intent.getStringExtra(MESSAGE_MAIN);
        double tension = Double.parseDouble(tens);

        String max = ((TextView) findViewById(R.id.textOutputSide)).getText().toString();
        max = max.substring(0, max.indexOf(' '));
        max = max.replaceAll(",", ".");
        double maximum = Double.parseDouble(max);

        TextView sideText = (TextView) findViewById(R.id.sideText);
        sideText.setText("Maximum:");
        sideText.setVisibility(View.VISIBLE);

        TextView sideOutput2 = (TextView) findViewById(R.id.textOutputSide2);
        double tot = maximum - tension;
        String side2 = tot + "";
        sideOutput2.setTextColor(Color.BLACK);
        if (tot < 0) {
            side2 = "+" + prepareOutput(side2);
            sideOutput2.setTextColor(Color.RED);
        } else if (tot > 0) {
            side2 = "-" + prepareOutput(side2);
            sideOutput2.setTextColor(0xFF339900);
        }
        sideOutput2.setText(side2);
        sideOutput2.setVisibility(View.VISIBLE);
    }

    private String prepareOutput(String text) {
        String res = "";
        double tmp = Double.parseDouble(text);
        if (tmp == 0.0) return text + " MPa";
        if (tmp < 0.0) tmp = tmp * -1;
        if (tmp < 1.0) {
            tmp = tmp * 1000;
            if (tmp < 1.0) {
                tmp = tmp * 100;
                return String.format("%.2f", tmp) + " Pa";
            } else {
                res = String.format("%.2f", tmp) + " kPa";
            }
        } else {
            res = String.format("%.2f", tmp) + " MPa";
        }
        return res;
    }

    private void prepareSpinner() {
        Spinner material_spinner = (Spinner) findViewById(R.id.material_spinner);
        ArrayAdapter<CharSequence> adapter2 = ArrayAdapter.createFromResource(this,
                R.array.material_array_short, android.R.layout.simple_spinner_item);
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        material_spinner.setAdapter(adapter2);
        material_spinner.setVisibility(View.VISIBLE);
        TextView materialText = (TextView) findViewById(R.id.materialText);
        materialText.setVisibility(View.VISIBLE);
        setSpinnerOutput();

        material_spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                setSpinnerOutput();
                setOutputTension();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }

    private void setSpinnerOutput() {
        String material = ((Spinner) findViewById(R.id.material_spinner)).getSelectedItem().toString();
        TextView output = (TextView) findViewById(R.id.textOutputSide);
        Intent intent = getIntent();
        String typ = intent.getStringExtra(MESSAGE_SIDE);
        String nature = intent.getStringExtra(MESSAGE_SIDE2);


        int tension = getTension(material, typ, nature, this);
        output.setText(prepareOutput(tension + ""));
        output.setVisibility(View.VISIBLE);
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        finish();
        return true;
    }
}


