package com.example.amir.ricehouse;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class Products extends AppCompatActivity {

    private Data[] data;
    private String[] avatars;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_products);
        setUpToolbar();
        setUpGridView();
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

    public void fetchData(View view) {
        TextView textView = findViewById(R.id.textView3);
        RiceHouseService riceHouseService = RiceHouseRetrofitClass.getRiceHouseService();
        Observable<RiceHouseResponse> observable = riceHouseService.getAllProducts()
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread());

        //Button button = findViewById(R.id.button);
        observable.subscribe(new Observer<RiceHouseResponse>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(RiceHouseResponse riceHouseResponse) {
                data = riceHouseResponse.getData();
                avatars = riceHouseResponse.getAvatar();
            }

            @Override
            public void onError(Throwable e) {
                    Toast.makeText(Products.this, e.getMessage(), Toast.LENGTH_SHORT);
            }

            @Override
            public void onComplete() {

            }
        });



    }

    private void setUpToolbar() {
        Toolbar toolbar = findViewById(R.id.products_toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Products");
    }

    private void setUpGridView() {
        GridView gridview = findViewById(R.id.grid_view);
        gridview.setAdapter(new ImageAdapter(this, avatars));
        gridview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(adapterView.getContext(), "Image number: " + i,
                        Toast.LENGTH_SHORT).show();
            }
        });
    }
}
