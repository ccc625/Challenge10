package com.example.challenge10;

/**
 * Created by 지민 on 2016-12-10.
 */

public class ImageListItem
{
    private int sideResources;
    private int frontResources;

    private String name;
    private String publisher;
    private String day;
    private String writer;

    public void setSideResources( int resources )
    {
        sideResources = resources;
    }

    public int getSideResources()
    {
        return sideResources;
    }

    public void setFrontResources( int resources )
    {
        frontResources = resources;
    }

    public int getFrontResources()
    {
        return frontResources;
    }

    public String getName()
    {
        return name;
    }

    public String getPublisher()
    {
        return publisher;
    }

    public String getDay()
    {
        return day;
    }

    public String getWriter()
    {
        return writer;
    }

    public void setBookData(String name, String publisher, String day, String writer)
    {
        this.name = name;
        this.publisher = publisher;
        this.day = day;
        this.writer = writer;
    }

    public ImageListItem()
    {

    }
}
