package com.example.bptestingapp.activities;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;

import com.example.bptestingapp.R;

import static com.example.bptestingapp.MainActivity.MESSAGE_MAIN;

public class Material extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_material);

        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }

        Intent intent = getIntent();
        String id = intent.getStringExtra(MESSAGE_MAIN);
        ((TextView) findViewById(R.id.material_id)).setText(id);
        String max_tens = getResources().getString(getResources().getIdentifier("max" + id, "string", getPackageName()));
        ((TextView) findViewById(R.id.max_tens)).setText(max_tens);
        String material_info = getResources().getString(getResources().getIdentifier("text" + id, "string", getPackageName()));
        ((TextView) findViewById(R.id.material_text)).setText(material_info);


    }

    public boolean onOptionsItemSelected(MenuItem item) {
        finish();
        return true;
    }
}
