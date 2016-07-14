package com.javalearn.test.Air;

/**
 * Created by Admin on 03.06.2015.
 */
public class Airplane
{
    private final double speedMax;
    private final double accelerationMax;

    private double  speedHight, speedCourseInRad;


    public Airplane(double speedMax, double accelerationMax)
    {
        this.speedMax = speedMax;
        this.accelerationMax = accelerationMax;
    }

    public double getSpeedMax()
    {
        return speedMax;
    }

    public double getAccelerationMax()
    {
        return accelerationMax;
    }

    public double getSpeedHight()
    {
        return speedHight;
    }

    public void setSpeedHight(double speedHight)
    {
        this.speedHight = speedHight;
    }

    public double getSpeedCourseInRad()
    {
        return speedCourseInRad;
    }

    public void setSpeedCourseInRad(double speedCourseInRad)
    {
        this.speedCourseInRad = speedCourseInRad;
    }
}
