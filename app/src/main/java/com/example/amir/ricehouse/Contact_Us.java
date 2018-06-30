package com.example.amir.ricehouse;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.TextView;

public class Contact_Us extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact__us);
        setUpToolbar();
        setUpTextView();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        switch (menuItem.getItemId()) {
            case R.id.homeAsUp:
                this.finish();
                break;
        }
        return super.onOptionsItemSelected(menuItem);
    }

    private void setUpToolbar() {
        Toolbar toolbar = findViewById(R.id.contact_us_toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Contact Us");
    }

    private void setUpTextView() {
        TextView textView = findViewById(R.id.textView2);
        textView.setText("Founded on mid 2018, we have come up with loads of great ideas to revolutionize rice industry.\n" +
                "We are focused at delivering diffrent vareities of high quality natural and pure rice to people.\n" +
                "We have great passion and enthusiasm.");
    }

}
