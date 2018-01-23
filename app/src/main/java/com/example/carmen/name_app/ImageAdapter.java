package com.example.carmen.name_app;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

/**
 * Created by Carmen on 15.01.2018.
 */

public class ImageAdapter extends BaseAdapter {

    private Context mContext;
    private saveFileHandler sfh;

    public ImageAdapter(Context c, String[] imageNames, String imagePath) {
        mContext = c;
        sfh = new saveFileHandler(c);
        setupmBitmapImages(imageNames,imagePath);

    }

    public int getCount() {

        return mBitmapImages.length;
    }

    public Object getItem(int position) {
        return null;
    }

    public long getItemId(int position) {
        return 0;
    }

    // create a new ImageView for each item referenced by the Adapter
    public View getView(int position, View convertView, ViewGroup parent) {
        ImageView imageView;
        if (convertView == null) {
            // if it's not recycled, initialize some attributes
            imageView = new ImageView(mContext);
            imageView.setLayoutParams(new GridView.LayoutParams(300, 300));
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            imageView.setPadding(8, 8, 8, 8);
        } else {
            imageView = (ImageView) convertView;
        }

        imageView.setImageBitmap(mBitmapImages[position]);
        return imageView;
    }

    private Bitmap[] mBitmapImages;

    private void setupmBitmapImages(String[] imageNames, String imagePath){
        mBitmapImages = new Bitmap[imageNames.length];
        for(int i = 0; i < imageNames.length; i++) {
            mBitmapImages[i] = sfh.getImage(imageNames[i]);

        }
    }



}
