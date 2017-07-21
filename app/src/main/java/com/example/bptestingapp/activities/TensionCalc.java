package com.example.bptestingapp.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.bptestingapp.R;
import com.example.bptestingapp.auxiliary.auxFc;
import com.example.bptestingapp.auxiliary.calcFc;

import static com.example.bptestingapp.MainActivity.MESSAGE_MAIN;
import static com.example.bptestingapp.MainActivity.MESSAGE_SIDE;
import static com.example.bptestingapp.MainActivity.MESSAGE_SIDE2;
import static com.example.bptestingapp.MainActivity.MESSAGE_TYPE;

public class TensionCalc extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tension_calc);

        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }

        Spinner type_spinner = (Spinner) findViewById(R.id.type_spinner);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.type_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        type_spinner.setAdapter(adapter);

        final Spinner shape_spinner = (Spinner) findViewById(R.id.shape_spinner);
        ArrayAdapter<CharSequence> adapter3 = ArrayAdapter.createFromResource(this,
                R.array.prurez_array, android.R.layout.simple_spinner_item);
        adapter3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        shape_spinner.setAdapter(adapter3);

        shape_spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
                String item = shape_spinner.getSelectedItem().toString().toLowerCase();
                switchInput(item);
            }

            @Override
            public void onNothingSelected(AdapterView<?> arg0) {

            }
        });

        Spinner nature_spinner = (Spinner) findViewById(R.id.nature_spinner);
        ArrayAdapter<CharSequence> adapter4 = ArrayAdapter.createFromResource(this,
                R.array.nature_array, android.R.layout.simple_spinner_item);
        adapter4.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        nature_spinner.setAdapter(adapter4);
    }

    private void switchInput(String item) {
        EditText sideB = (EditText) findViewById(R.id.sideB);
        TextView textA = (TextView) findViewById(R.id.textA);
        TextView textB = (TextView) findViewById(R.id.textB);
        switch (item) {
            case "kruh":
                sideB.setVisibility(View.INVISIBLE);
                textB.setVisibility(View.INVISIBLE);
                textA.setText("Průměr (mm):");
                break;
            case "čtverec":
                sideB.setVisibility(View.INVISIBLE);
                textB.setVisibility(View.INVISIBLE);
                textA.setText("Strana a (mm):");
                break;
            case "obdélník":
                sideB.setVisibility(View.VISIBLE);
                textB.setVisibility(View.VISIBLE);
                textA.setText("Strana a (mm):");
                break;
        }
    }

    protected void onClick(View view) {
        Intent intent = new Intent(this, ResultActivity.class);

        EditText sideA = (EditText) findViewById(R.id.sideA);
        EditText sideB = (EditText) findViewById(R.id.sideB);
        EditText forceInput = (EditText) findViewById(R.id.forceInput);

        String sideA_txt = sideA.getText().toString();
        String sideB_txt = sideB.getText().toString();
        String force_txt = forceInput.getText().toString();

        if (force_txt.length() == 0) {
            forceInput.setError("Field is required");
        } else if (sideA_txt.length() == 0) {
            sideA.setError("Field is required!");
        } else if (sideB_txt.length() == 0 && sideB.getVisibility() == View.VISIBLE) {
            sideB.setError("Field is required!");
        } else {
            String typ = ((Spinner) findViewById(R.id.type_spinner)).getSelectedItem().toString().toLowerCase();
            String nature = ((Spinner) findViewById(R.id.nature_spinner)).getSelectedItem().toString().toLowerCase();

            Spinner spinner = (Spinner) findViewById(R.id.shape_spinner);
            String areaType = spinner.getSelectedItem().toString().toLowerCase();

            double area = auxFc.getArea(typ, areaType, sideA_txt, sideB_txt);
            double tension =  calcFc.maxTension(area, Integer.parseInt(force_txt));

            String message = tension + "";
            intent.putExtra(MESSAGE_MAIN, message);
            intent.putExtra(MESSAGE_SIDE, typ);
            intent.putExtra(MESSAGE_SIDE2, nature);
            intent.putExtra(MESSAGE_TYPE, "tension");
            startActivity(intent);
        }

        /*int resourceId = this.getResources().
                getIdentifier("app" + "_text", "string", this.getPackageName());*/

    }


    public boolean onOptionsItemSelected(MenuItem item) {
        finish();
        return true;
    }
}
