package ru.zubrilovskaya.geometry;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class BrokenLine implements Lengthable, BrokenLineable {
    public List <Point> points ;

    public BrokenLine(List<Point> points){
        this.points = points;
    }
    public BrokenLine(Point... points){
        this(Arrays.asList(points));
    }

    public void addNewPoints(Point... dots) {
        for (Point p : dots) {
            points.add(p);
        }
    }
    @Override
    public double length(){
        double res = 0.0;
        for (int i = 0; i < points.size()-1; i++){
            Point p1 = new Point(points.get(i).x, points.get(i).y);
            Point p2 = new Point(points.get(i+1).x, points.get(i+1).y);
            res = res + new Line(p1, p2).length();
        }
        return res;
    }

    @Override
    public final boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof BrokenLine that)) return false;
        if(this.getClass() == o.getClass()) return Objects.equals(points, that.points);
        List<Point> other = new ArrayList<>(that.points);
        List<Point> my = new ArrayList<>(points);
        if (this.getClass() == ClosedLine.class) my.add(this.points.getFirst());
        if (that.getClass() == ClosedLine.class) other.add(this.points.getFirst());
        return Objects.equals(my, other);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(points);
    }

    public String toString (){
        int count = 0 ;
        String res = "Линия [";
        for (Point x: points){
            res = res + " " + x;
            count++;
            if (count < points.size()) res = res + ",";
        }
        return res + "]";
    }
    @Override
    public BrokenLine getBroken(){
        return new BrokenLine(points);
    }
}
