package com.example.challenge10;

import android.content.Context;
import android.graphics.Matrix;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

/**
 * Created by 지민 on 2016-12-10.
 */

public class ImageListView extends LinearLayout
{
    private Context mContext;

    private ImageView imgSide;
    private ImageView imgFront;

    public ImageListView(Context context)
    {
        super(context);

        mContext = context;

        init();
    }

    public ImageListView(Context context, AttributeSet attrs)
    {
        super(context, attrs);

        mContext = context;

        init();
    }

    public void setImage( int sideImageResources, int frontImageResource )
    {
        imgSide.setImageResource( sideImageResources );
        imgFront.setImageResource( frontImageResource );

//        imgSide.setRotationY(-90.0f);

//        imgSide.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
//        imgFront.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
    }

    public void visibleSide()
    {
        imgFront.setVisibility(GONE);
        imgSide.setVisibility(VISIBLE);
    }

    public void visibleFront()
    {
        imgFront.setVisibility(VISIBLE);
        imgSide.setVisibility(GONE);
    }

    private void init()
    {
        LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        inflater.inflate(R.layout.image_item, this, true);

        imgSide = (ImageView) findViewById(R.id.imgSide);
        imgFront = (ImageView) findViewById(R.id.imgFront);

        imgSide.setVisibility(VISIBLE);
        imgFront.setVisibility(GONE);
    }
}
