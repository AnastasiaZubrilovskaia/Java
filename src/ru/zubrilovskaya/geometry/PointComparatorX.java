package ru.zubrilovskaya.geometry;
import java.util.Comparator;


public class PointComparatorX implements Comparator<Point>{
    @Override
    public int compare(Point o1, Point o2) {
        return o1.x-o2.x;
    }
}
