package com.example.bptestingapp.activities;

import android.support.constraint.ConstraintLayout;
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
import com.example.bptestingapp.auxiliary.InputFilterMinMaxInt;

import static com.example.bptestingapp.auxiliary.CogWheelFc.*;

public class CogwheelCalc extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cogwheel);

        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
        final Spinner modul_spinner = (Spinner) findViewById(R.id.modul_spinner);
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
                double modul = Double.parseDouble(modul_spinner.getSelectedItem().toString());
                ((TextView) findViewById(R.id.text_roztec)).setText(getPitchStr(modul));
                ((TextView) findViewById(R.id.text_vrch_vule)).setText(getOutletStr(modul));
                ((TextView) findViewById(R.id.text_vyska_hlavy)).setText(getHeadStr(modul));
                ((TextView) findViewById(R.id.text_vyska_paty)).setText(getFootStr(modul));
                ((TextView) findViewById(R.id.text_vyska_zubu)).setText(getCogHeightStr(modul));
                ((TextView) findViewById(R.id.text_tl_zub)).setText(getCogWidth(modul));
                ((TextView) findViewById(R.id.text_zub_mez)).setText(getCogMarStr(modul));

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        if (modul_spinner.getCount() > 18) {
            modul_spinner.setSelection(18);
        }


        final EditText input = (EditText) findViewById(R.id.cog_count);
        input.setFilters(new InputFilter[]{new InputFilterMinMaxInt("1", "500")});
        input.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (input.getText().length() == 0) {
                    setAllFieldsZero();
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
        String input = ((EditText) findViewById(R.id.cog_count)).getText().toString();
        return input.length() > 0;
    }

    private void calculate() {
        String modul_txt = ((Spinner) findViewById(R.id.modul_spinner)).getSelectedItem().toString();
        String count_txt = ((EditText) findViewById(R.id.cog_count)).getText().toString();

        double modul = Double.parseDouble(modul_txt);
        int count = Integer.parseInt(count_txt);

        ((TextView) findViewById(R.id.text_roztec_kr)).setText(getPitchDiameterStr(modul, count));
        ((TextView) findViewById(R.id.text_hlav_kr)).setText(getHeadDiameterStr(modul, count));
        ((TextView) findViewById(R.id.text_pata_kr)).setText(getFootDiameterStr(modul, count));
       /* ((TextView)findViewById(R.id.text_roztec)).setText(getPitchStr(modul));
        ((TextView)findViewById(R.id.text_vrch_vule)).setText(getOutletStr(modul));
        ((TextView)findViewById(R.id.text_vyska_hlavy)).setText(getHeadStr(modul));
        ((TextView)findViewById(R.id.text_vyska_paty)).setText(getFootStr(modul));
        ((TextView)findViewById(R.id.text_vyska_zubu)).setText(getCogHeightStr(modul));
        ((TextView)findViewById(R.id.text_tl_zub)).setText(getCogWidth(modul));
        ((TextView)findViewById(R.id.text_zub_mez)).setText(getCogMarStr(modul));*/
    }

    private void setAllFieldsZero() {
        ConstraintLayout results = (ConstraintLayout) findViewById(R.id.constraintLayout);
        int count = results.getChildCount();
        for (int i = 0; i < count; i++) {
            ((TextView) results.getChildAt(i)).setText("0 mm");
        }
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        finish();
        return true;
    }
}
