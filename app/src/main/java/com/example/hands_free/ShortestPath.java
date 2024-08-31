package com.example.hands_free;

import java.util.ArrayList;
import java.util.List;


import java.util.ArrayList;
import java.util.List;

public class ShortestPath {
    public List<Point> displayShortestPath(){
        return calculateShortestPath(storesToVisit());
    }

    public List<Point> storesToVisit() {
        List<Point> pointsToVisit = new ArrayList<>();
        //start point is always location of office
        pointsToVisit.add(new Point(4.9, 9, "office"));
        //add stores position to list
        pointsToVisit.add(new Point(8.8, 10.5, "Store10"));
        pointsToVisit.add(new Point(6.6, 10.5, "Store11"));
        pointsToVisit.add(new Point(3.5, 9, "Store28"));
        pointsToVisit.add(new Point(8.3, 4.7, "Store23"));
        pointsToVisit.add(new Point(4.4, 5, "Store30"));
        return pointsToVisit;
    }

    private double calculateDistance(Point p1, Point p2) {
        double xDiff = p2.getX() - p1.getX();
        double yDiff = p2.getY() - p1.getY();
        //formula of distance between the two points.
        return Math.sqrt(xDiff * xDiff + yDiff * yDiff);
    }

    private List<Point> calculateShortestPath(List<Point> pointsToVisit) {
        List<Point> shortestPath = new ArrayList<>();
        //after each node was visited we need to remove it from the list
        List<Point> remainingPoints = new ArrayList<>(pointsToVisit);

        //method remove return will return the element that remove it
        Point currentPoint = remainingPoints.remove(0);
        shortestPath.add(currentPoint);

        //nearest neighbor algorithm
        while (!remainingPoints.isEmpty()) {
            Point nearestPoint = null;
            double shortestDistance = Double.MAX_VALUE;

            for (Point point : remainingPoints) {
                double distance = calculateDistance(currentPoint, point);
                if (distance < shortestDistance) {
                    shortestDistance = distance;
                    nearestPoint = point;
                }
            }
            shortestPath.add(nearestPoint);
            remainingPoints.remove(nearestPoint);
            currentPoint = nearestPoint;
        }
        return shortestPath;
    }
}


class Point {
    //in next version should get stores from database
    private double x;
    private double y;
    private String store;

    public Point(double x, double y, String store) {
        this.store = store;
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return x;
    }
    public double getY() {
        return y;
    }
    public String getStore(){
        return store;
    }
}