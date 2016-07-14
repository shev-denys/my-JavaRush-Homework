package com.javalearn.test.level21.lesson16.big01;



/**
 * Created by Admin on 04.01.2015.
 */
public class Horse
{
    public Horse(String name, double speed, double distance)
    {
        this.name = name;
        this.speed = speed;
        this.distance = distance;
    }

    public void move()
    {
        speed *=  Math.random();
        distance += speed;
    }

    public void print()
    {
        for(int distanceInt = (int)distance;distanceInt>0;distanceInt--)
        {
            System.out.print(".");
        }
        System.out.println(getName());


    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public double getSpeed()
    {
        return speed;
    }

    public void setSpeed(double speed)
    {
        this.speed = speed;
    }

    public double getDistance()
    {
        return distance;
    }

    public void setDistance(double distance)
    {
        this.distance = distance;
    }

    String name;
    double speed;
    double distance;
}
