package com.example.challenge10;

import android.content.Context;
import android.graphics.Camera;
import android.graphics.Color;
import android.graphics.Matrix;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.Transformation;
import android.widget.Gallery;
import android.widget.ImageView;
import android.widget.SpinnerAdapter;

/**
 * Created by 지민 on 2016-12-10.
 */

public class CoverFlow extends Gallery
{
    private ImageListView currentFrontListView;
    private int centerPoint;

    public CoverFlow(Context context)
    {
        super(context);

        init();
    }

    public CoverFlow(Context context, AttributeSet attrs)
    {
        super(context, attrs);

        init();
    }

    public CoverFlow(Context context, AttributeSet attrs, int defStyle)
    {
        super(context, attrs, defStyle);

        init();
    }

    public ImageListView getCurrentFrontListView()
    {
        return currentFrontListView;
    }

    private void init()
    {
        this.setStaticTransformationsEnabled( true );

        this.setBackgroundColor(Color.GRAY);
    }

    private int getCenterOfCoverflow()
    {
        return (getWidth() - getPaddingLeft() - getPaddingRight()) / 2 + getPaddingLeft();
    }

    private static int getCenterOfView(View view)
    {
        return view.getLeft() + view.getWidth() / 2;
    }

    @Override
    protected boolean getChildStaticTransformation(View child, Transformation t) {
        int childCenter = getCenterOfView(child);
        ImageListView listViewChild = (ImageListView) child;

        if (centerPoint + (getWidth() / 10) > childCenter && centerPoint - (getWidth() / 10) < childCenter)
        {
            if (currentFrontListView != null) {
                int currentFrontListViewCenter = getCenterOfView(currentFrontListView);

                if (centerPoint + (getWidth() / 10) > currentFrontListViewCenter && centerPoint - (getWidth() / 10) < currentFrontListViewCenter) {
                    return true;
                }
            }

            if (currentFrontListView != listViewChild) {
                if (currentFrontListView != null)
                    currentFrontListView.visibleSide();
                listViewChild.visibleFront();

                currentFrontListView = listViewChild;
            }
        }

        return true;
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh)
    {
        centerPoint = getCenterOfCoverflow();
        super.onSizeChanged(w, h, oldw, oldh);
    }
}
