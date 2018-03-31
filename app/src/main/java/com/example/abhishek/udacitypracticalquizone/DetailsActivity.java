package com.example.abhishek.udacitypracticalquizone;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;

public class DetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        Toolbar mainToolbar = findViewById(R.id.main_toolbar);
        setSupportActionBar(mainToolbar);

        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }

        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this);

        ((TextView) findViewById(R.id.tv_name))
                .setText(preferences.getString(getString(R.string.key_name), getString(R.string.demo_name)));
        ((TextView) findViewById(R.id.tv_email))
                .setText(preferences.getString(getString(R.string.key_email), getString(R.string.demo_email)));
        ((TextView) findViewById(R.id.tv_about))
                .setText(preferences.getString(getString(R.string.key_about), getString(R.string.demo_about)));

    }
}
