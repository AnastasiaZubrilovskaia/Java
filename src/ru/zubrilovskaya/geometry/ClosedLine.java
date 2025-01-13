package ru.zubrilovskaya.geometry;
import java.util.Arrays;
import java.util.Iterator;
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

    @Override
    public Iterator<Point> iterator() {
        return new Iterator<Point>() {
            int index = current;
            @Override
            public boolean hasNext() {
                return true;
            }

            @Override
            public Point next() {
                if(index == points.size()) index = 0;
                return points.get(index++);
            }
        };
    }
}
