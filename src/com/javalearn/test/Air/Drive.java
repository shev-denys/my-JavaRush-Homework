package com.javalearn.test.Air;

import com.javalearn.test.Air.Points.TemporaryPoint;
import com.javalearn.test.Air.Points.WayPoint;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by Admin on 03.06.2015.
 */
public class Drive
{
    public static void main(String[] args)
    {
        List<WayPoint> wpl = new LinkedList<>();
        wpl.add(new WayPoint(40,40,5000,88));
        wpl.add(new WayPoint(40,42,7500,95));
        wpl.add(new WayPoint(42,45,300,50));

        List<TemporaryPoint> points = planeCalculation.calculateRoute(new Airplane(100.0,5.0),wpl);
    }
}
