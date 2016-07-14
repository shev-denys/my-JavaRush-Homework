package com.javalearn.test.Air.Points;

/**
 * Created by Admin on 03.06.2015.
 */
public class Point
{
    double latitude,longitude, height, speed;

    public Point(double latitude, double longitude, double height, double speed)
    {
        this.latitude = latitude;
        this.longitude = longitude;
        this.height = height;
        this.speed = speed;
    }

    public double getLatitude()
    {
        return latitude;
    }

    public void setLatitude(double latitude)
    {
        this.latitude = latitude;
    }

    public double getLongitude()
    {
        return longitude;
    }

    public void setLongitude(double longitude)
    {
        this.longitude = longitude;
    }

    public double getHeight()
    {
        return height;
    }

    public void setHeight(double height)
    {
        this.height = height;
    }

    public double getSpeed()
    {
        return speed;
    }

    public void setSpeed(double speed)
    {
        this.speed = speed;
    }
}
