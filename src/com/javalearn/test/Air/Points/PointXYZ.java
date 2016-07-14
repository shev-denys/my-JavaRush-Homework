package com.javalearn.test.Air.Points;

/**
 * Created by Admin on 06.06.2015.
 */
public class PointXYZ
{
    double x,y,z;

    public PointXYZ(double x, double y, double z)
    {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public PointXYZ(Point p)
    {

    }

    public double getX()
    {
        return x;
    }

    public void setX(double x)
    {
        this.x = x;
    }

    public double getY()
    {
        return y;
    }

    public void setY(double y)
    {
        this.y = y;
    }

    public double getZ()
    {
        return z;
    }

    public void setZ(double z)
    {
        this.z = z;
    }
}
