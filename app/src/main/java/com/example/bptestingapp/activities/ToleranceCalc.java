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
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.bptestingapp.R;
import com.example.bptestingapp.auxiliary.InputFilterMinMax;
import com.example.bptestingapp.database.SQLiteDatabaseHandler;
import com.example.bptestingapp.models.Tolerance;

import java.util.List;

import static com.example.bptestingapp.auxiliary.auxFc.getRangeEP;
import static com.example.bptestingapp.auxiliary.auxFc.getRangeRS;
import static com.example.bptestingapp.auxiliary.auxFc.getTolerance;

public class ToleranceCalc extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tolerance_field);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);

        Spinner field_spinner = (Spinner) findViewById(R.id.field_spinner);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.hole_tolerance_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        field_spinner.setAdapter(adapter);

        ((TextView) findViewById(R.id.diameter_text)).setText("0");
        ((TextView) findViewById(R.id.upper)).setText("0");
        ((TextView) findViewById(R.id.lower)).setText("0");

        field_spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                switchItSpinner();
                compute();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        Spinner it_spinner = (Spinner) findViewById(R.id.it_spinner);
        ArrayAdapter<CharSequence> adapter2 = ArrayAdapter.createFromResource(this,
                R.array.e, android.R.layout.simple_spinner_item);
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        it_spinner.setAdapter(adapter2);

        it_spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                compute();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        RadioGroup rg = (RadioGroup) findViewById(R.id.radioGroup);
        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                // This will get the radiobutton that has changed in its check state
                RadioButton checkedRadioButton = (RadioButton) group.findViewById(checkedId);
                // This puts the value (true/false) into the variable
                boolean isChecked = checkedRadioButton.isChecked();
                // If the radiobutton that has changed in check state is now checked...
                if (isChecked) {
                    switchSpinnerType(checkedRadioButton.getText().toString());
                }
            }
        });

        final EditText input = (EditText) findViewById(R.id.diameterInput);
        input.setFilters(new InputFilter[]{new InputFilterMinMax("1", "500")});
        input.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                TextView tv = (TextView) findViewById(R.id.diameter_text);
                tv.setText(input.getText().toString());
                if (input.getText().length() == 0) {
                    tv.setText("0");
                    ((TextView) findViewById(R.id.upper)).setText("0");
                    ((TextView) findViewById(R.id.lower)).setText("0");
                }
                compute();
            }

            @Override
            public void afterTextChanged(Editable s) {
            }
        });
    }

    private void switchSpinnerType(String type) {
        Spinner field_spinner = (Spinner) findViewById(R.id.field_spinner);
        int last = field_spinner.getSelectedItemPosition();
        switch (type) {
            case "Hřídel":
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.tolerance_array, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                field_spinner.setAdapter(adapter);
                break;
            case "Díra":
                adapter = ArrayAdapter.createFromResource(this,
                        R.array.hole_tolerance_array, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                field_spinner.setAdapter(adapter);
                break;
        }
        field_spinner.setSelection(last);
        compute();
    }

    private void switchItSpinner() {
        Spinner it_spinner = (Spinner) findViewById(R.id.it_spinner);
        String field = ((Spinner) findViewById(R.id.field_spinner)).getSelectedItem().toString().toLowerCase();
        int resID = getResources().getIdentifier(field, "array", getPackageName());
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                resID, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        it_spinner.setAdapter(adapter);

    }

    private void compute() {
        String input = ((EditText) findViewById(R.id.diameterInput)).getText().toString();
        if (input.length() > 0) {
            String field = ((Spinner) findViewById(R.id.field_spinner)).getSelectedItem().toString();
            String it = ((Spinner) findViewById(R.id.it_spinner)).getSelectedItem().toString();
            it = "IT" + it;
            String range;
            String itRange = getRangeEP(input);
            if (field.toUpperCase().equals("R") || field.toUpperCase().equals("S")) {
                range = getRangeRS(input);
            } else {
                range = getRangeEP(input);
            }
            Tolerance tolerance = getTolerance(field, range, itRange, it, this);

            Double ES = tolerance.getES();
            Double EI = tolerance.getEI();
            String ESText = String.format("%.4f", ES);
            String EIText = String.format("%.4f", EI);
            if (ES > 0.0) {
                ESText = "+" + ESText;
            }
            if (EI > 0.0) {
                EIText = "+" + EIText;
            }

            ((TextView) findViewById(R.id.upper)).setText(ESText);
            ((TextView) findViewById(R.id.lower)).setText(EIText);
        }
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        finish();
        return true;
    }
}
