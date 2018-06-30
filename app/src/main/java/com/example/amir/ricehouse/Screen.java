package com.example.amir.ricehouse;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.ViewFlipper;

import io.reactivex.Flowable;

public class Screen extends AppCompatActivity {

    private ViewFlipper viewFlipper;
    private int[] images;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_screen);
        viewFlipper = findViewById(R.id.viewflipper);
        setUpToolbar();
        setFlipperImages();
        for (int image : images) {
            addImageToFlipper(image);
        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        Intent intent = null;
        switch (menuItem.getItemId()) {
            case R.id.about_us:
                intent = new Intent(this, About_Us.class);
                this.startActivity(intent);
                break;
            case R.id.contact_us:
                intent = new Intent(this, Contact_Us.class);
                this.startActivity(intent);
                break;
            case R.id.products:
                intent = new Intent(this, Products.class);
                this.startActivity(intent);
                break;
        }
        return true;
    }

    private void setUpToolbar() {
        Toolbar toolbar = findViewById(R.id.app_toolbar);
        setSupportActionBar(toolbar);
    }

    private void addImageToFlipper(int image) {
        ImageView imageView = new ImageView(this);
        imageView.setScaleType(ScaleType.FIT_XY);
        imageView.setImageResource(image);
        viewFlipper.addView(imageView);
        viewFlipper.setFlipInterval(4000);
        viewFlipper.setAutoStart(true);
        viewFlipper.setInAnimation(this, android.R.anim.slide_in_left);
        viewFlipper.setOutAnimation(this, android.R.anim.slide_out_right);
    }

    private void setFlipperImages() {
        images = new int[3];
        images[0] = R.drawable.ricefarmer;
        images[1] = R.drawable.ricetypes;
        images[2] = R.drawable.bakedrice;
    }

}
