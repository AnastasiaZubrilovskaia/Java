package ru.zubrilovskaya.geometry;
import java.util.Arrays;
import java.util.List;

public class ClosedLine extends BrokenLine{
    public ClosedLine(Point... points2D){
        this(Arrays.asList(points2D));
    }
    public ClosedLine(List<Point> points2D){
        super(points2D);
    }
    @Override
    public double length() {
        return super.length() + new Line(points2D.getFirst(), points2D.getLast()).length();
    }
}
