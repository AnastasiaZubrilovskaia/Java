package ru.zubrilovskaya.geometry;
import java.util.Arrays;
import java.util.List;

public class ClosedLine extends BrokenLine{
    public ClosedLine(Point... points){
        this(Arrays.asList(points));
    }
    public ClosedLine(List<Point> points){
        super(points);
    }
    @Override
    public double length() {
        return super.length() + new Line(points.getFirst(), points.getLast()).length();
    }
}
