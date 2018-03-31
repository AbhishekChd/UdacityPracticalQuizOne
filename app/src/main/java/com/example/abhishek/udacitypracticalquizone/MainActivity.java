package com.example.abhishek.udacitypracticalquizone;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


public class MainActivity extends AppCompatActivity {

    private EditText et_name;
    private EditText et_email;
    private EditText et_about;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar mainToolbar = findViewById(R.id.main_toolbar);
        setSupportActionBar(mainToolbar);

        et_name = findViewById(R.id.et_name);
        et_email = findViewById(R.id.et_email);
        et_about = findViewById(R.id.et_about);


        if (savedInstanceState != null) {
            String name = savedInstanceState.getString(getString(R.string.key_name));
            String email = savedInstanceState.getString(getString(R.string.key_email));
            String about = savedInstanceState.getString(getString(R.string.key_about));

            et_name.setText(name);
            et_email.setText(email);
            et_about.setText(about);
        }

        Button button = findViewById(R.id.btn_next);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(MainActivity.this);

                String name = et_name.getText().toString();
                String email = et_email.getText().toString();
                String about = et_about.getText().toString();

                preferences
                        .edit()
                        .putString(getString(R.string.key_name), name)
                        .putString(getString(R.string.key_email), email)
                        .putString(getString(R.string.key_about), about)
                        .apply();

                et_name.getText().clear();
                et_email.getText().clear();
                et_about.getText().clear();
                startDetailsActivity();
            }
        });
    }

    @Override
    public void onSaveInstanceState(Bundle outState, PersistableBundle outPersistentState) {
        String name = et_name.getText().toString();
        String email = et_email.getText().toString();
        String about = et_about.getText().toString();

        outState.putString(getString(R.string.key_name), name);
        outState.putString(getString(R.string.key_email), email);
        outState.putString(getString(R.string.key_about), about);

        super.onSaveInstanceState(outState, outPersistentState);
    }

    private void startDetailsActivity() {
        Intent intent = new Intent(MainActivity.this, DetailsActivity.class);
        startActivity(intent);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.details_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch (id) {
            case R.id.action_details:
                startDetailsActivity();
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}