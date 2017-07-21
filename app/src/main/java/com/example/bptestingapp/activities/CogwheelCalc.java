package com.example.bptestingapp.activities;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.InputFilter;
import android.text.TextWatcher;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.bptestingapp.R;
import com.example.bptestingapp.auxiliary.InputFilterMinMax;
import com.example.bptestingapp.auxiliary.InputFilterMinMaxInt;

public class CogwheelCalc extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cogwheel);

        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
        Spinner modul_spinner = (Spinner) findViewById(R.id.modul_spinner);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.modul, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        modul_spinner.setAdapter(adapter);

        modul_spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                if (checkInput()) {
                    calculate();
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        final EditText input = (EditText) findViewById(R.id.zub_val);
        input.setFilters(new InputFilter[]{new InputFilterMinMaxInt("1", "500")});
        input.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                TextView tv = (TextView) findViewById(R.id.diameter_text);
                tv.setText(input.getText().toString());
                if (input.getText().length() == 0) {
                    //TODO
                } else {
                    calculate();
                }
            }

            @Override
            public void afterTextChanged(Editable s) {
            }
        });
    }

    private boolean checkInput() {
        String input = ((EditText) findViewById(R.id.zub_val)).getText().toString();
        if (input.length() > 0) {
            return true;
        }
        return false;
    }

    private void calculate() {

    }

    public boolean onOptionsItemSelected(MenuItem item) {
        finish();
        return true;
    }
}
