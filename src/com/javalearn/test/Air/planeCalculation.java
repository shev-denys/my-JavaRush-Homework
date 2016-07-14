package com.javalearn.test.Air;

import com.javalearn.test.Air.Points.Point;
import com.javalearn.test.Air.Points.PointXYZ;
import com.javalearn.test.Air.Points.TemporaryPoint;
import com.javalearn.test.Air.Points.WayPoint;

import java.util.List;

/**
 * Created by Admin on 03.06.2015.
 */
public class planeCalculation
{
    static double inOneDegree = 111000; //metters in one degree
    static double dacc = 0.5;

    public static List<TemporaryPoint> calculateRoute(Airplane characteristics, List<WayPoint> wayPoints)
    {
        return null;
    }

    private static TemporaryPoint GetOptimalPoint(Airplane plane, TemporaryPoint currentPoint, WayPoint wayPoint)
    {

        return GetOptimalPoint(plane, currentPoint, wayPoint, currentPoint);
    }

    private static TemporaryPoint GetOptimalPoint(Airplane plane, TemporaryPoint currentPoint, WayPoint wayPoint, Point ZeroPoint)
    {
        final double dist = Distance(currentPoint, wayPoint);
        double curSpeed = currentPoint.getSpeed();

        for (double acc = -plane.getAccelerationMax(); acc <= plane.getAccelerationMax(); acc += dacc)

        {
            double deltaX,deltaY,deltaZ;
            deltaX = Math.sqrt(Math.pow(curSpeed,2)-Math.pow(plane.getSpeedHight(),2))*Math.sin(plane.getSpeedCourseInRad()) + acc*plane.getSpeedHight()*Math.sin(plane.getSpeedCourseInRad())/(2* curSpeed);
            deltaY = Math.sqrt(Math.pow(curSpeed,2)-Math.pow(plane.getSpeedHight(),2))*Math.cos(plane.getSpeedCourseInRad()) + acc*plane.getSpeedHight()*Math.cos(plane.getSpeedCourseInRad())/(2* curSpeed);
            deltaZ = curSpeed + acc* plane.getSpeedHight()/(2* curSpeed);


        }
            return null;
    }

    private static double Distance(Point from, Point to)
    {
        double xdis = from.getLongitude() - to.getLongitude();
        double ydis = from.getLatitude() - to.getLatitude();
        double zdis = from.getHeight() - to.getHeight();

        return Math.sqrt(Math.pow(xdis * inOneDegree, 2) + Math.pow(ydis * inOneDegree, 2) + Math.pow(zdis, 2));
    }

    private static double Distance(Point from, Point to,double dX,double dY,double dZ)
    {
        double xdis = from.getLongitude() - to.getLongitude();
        double ydis = from.getLatitude() - to.getLatitude();
        double zdis = from.getHeight() - to.getHeight();

        return Math.sqrt(Math.pow(xdis * inOneDegree+dX, 2) + Math.pow(ydis * inOneDegree+dY, 2) + Math.pow(zdis+dZ, 2));
    }

}
