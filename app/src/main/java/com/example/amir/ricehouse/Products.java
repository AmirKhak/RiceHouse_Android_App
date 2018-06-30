package com.example.amir.ricehouse;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;


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
        fetchData();
        setUpGridView();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.product, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        switch (menuItem.getItemId()) {
            case R.id.homeAsUp:
                this.finish();
                break;
            case R.id.refresh:
                fetchData();
                setUpGridView();
                break;
        }
        return super.onOptionsItemSelected(menuItem);
    }

    private void fetchData() {
        RiceHouseService riceHouseService = RiceHouseRetrofitClass.getRiceHouseService();
        Observable<RiceHouseResponse> observable = riceHouseService.getAllProducts()
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread());
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
                Toast.makeText(adapterView.getContext(), data[i].getTitle(),
                        Toast.LENGTH_SHORT).show();
            }
        });
    }
}
