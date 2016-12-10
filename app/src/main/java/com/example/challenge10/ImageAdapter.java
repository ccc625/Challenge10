package com.example.challenge10;

import android.content.Context;
import android.graphics.drawable.BitmapDrawable;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.io.FileInputStream;
import java.util.ArrayList;

/**
 * Created by 지민 on 2016-12-10.
 */

public class ImageAdapter extends BaseAdapter
{
    private Context mContext;
    private ArrayList<ImageListItem> listData;

    public ImageAdapter(Context context)
    {
        mContext = context;
    }

    @Override
    public int getCount()
    {
        return listData.size();
    }

    @Override
    public Object getItem(int position)
    {
        return position;
    }

    @Override
    public long getItemId(int position)
    {
        return position;
    }

    @Override
    public View getView(int position, View view, ViewGroup viewGroup)
    {
        ImageListView img = new ImageListView(mContext);
        img.setImage( listData.get(position).getSideResources(), listData.get(position).getFrontResources() );

        return img;
    }

    public void setListData( ArrayList<ImageListItem> inData )
    {
        listData = inData;
    }
}
