package com.javalearn.test.Air.Points;

/**
 * Created by Admin on 03.06.2015.
 */
public class TemporaryPoint extends Point
{
    double course;

    public TemporaryPoint(double latitude, double longitude, double height, double speed, double course)
    {
        super(latitude, longitude, height, speed);
        this.course = course;
    }
}
