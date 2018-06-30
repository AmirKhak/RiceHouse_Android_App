package com.example.amir.ricehouse;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import static java.lang.Math.round;


public class ImageAdapter extends BaseAdapter {

    private String[] avatars;
    private Context context;

    public ImageAdapter(Context context, String[] avatars) {
        this.context = context;
        this.avatars = avatars;
    }

    @Override
    public int getCount() {
        return (avatars == null) ? 0 : avatars.length;
    }

    @Override
    public Object getItem(int i) {
        return (avatars == null) ? 0 : avatars[i];
    }

    @Override
    public long getItemId(int i) {
        return round(i / 3);
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ImageView imageView;
        if (view == null) {
            // if it's not recycled, initialize some attributes
            imageView = new ImageView(context);
            imageView.setLayoutParams(new GridView.LayoutParams(150, 150));
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            imageView.setPadding(10, 10, 10, 10);
        } else {
            imageView = (ImageView) view;
        }
        Picasso.with(context).load(avatars[i]).into(imageView);
        return imageView;
    }

}
