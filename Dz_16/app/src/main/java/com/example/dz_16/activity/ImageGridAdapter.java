package com.example.dz_16.activity;

import android.content.Context;
import android.net.Uri;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

import java.util.ArrayList;

public class ImageGridAdapter extends BaseAdapter {

    private Uri uri = null;

    private ArrayList<Uri> arrayList = new ArrayList<>();

    private Context mContext;

    public ImageGridAdapter(Context c) {
        this.mContext = c;
    }

    @Override
    public int getCount() {
        return arrayList.size();
    }

    @Override
    public Object getItem(int position) {
        return arrayList.get(position);
    }

    public void setUri(Uri uri) {
        this.uri = uri;
        arrayList.add(uri);
    }

    public ArrayList<Uri> getArrayList() {
        return arrayList;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }


    public View getView(int position, View convertView, ViewGroup parent) {


        ImageView imageView;
        if (convertView == null) {
            imageView = new ImageView(mContext);
            imageView.setLayoutParams(new GridView.LayoutParams(250, 250));
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            imageView.setPadding(8, 8, 8, 8);
        } else {
            imageView = (ImageView) convertView;
        }

        if(uri != null) {
            imageView.setImageURI(uri);
        }

        imageView.setImageURI(arrayList.get(position));

        return imageView;
    }
}
