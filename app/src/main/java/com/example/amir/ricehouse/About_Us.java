package com.example.amir.ricehouse;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.TextView;

public class About_Us extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about__us);
        setUpToolbar();
        setUpTextView();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        switch (menuItem.getItemId()) {
            case R.id.home:
                this.finish();
                break;
        }
        return super.onOptionsItemSelected(menuItem);
    }

    private void setUpToolbar() {
        Toolbar toolbar = findViewById(R.id.about_us_toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("About Us");
    }

    private void setUpTextView() {
        TextView textView = findViewById(R.id.textView);
        textView.setText("Founded on mid 2018, we have come up with loads of great ideas to revolutionize rice industry.\n" +
                "We are focused at delivering diffrent vareities of high quality natural and pure rice to people.\n" +
                "We have great passion and enthusiasm.");
    }

}
