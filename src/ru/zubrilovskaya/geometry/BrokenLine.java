package ru.zubrilovskaya.geometry;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class BrokenLine implements Lengthable, BrokenLineable {
    public List <Point> points2D = new ArrayList<>();

    public BrokenLine(List<Point> points2D){
        this.points2D = points2D;
    }
    public BrokenLine(Point... points2D){
        this(Arrays.asList(points2D));
    }

    public void addNewPoints(Point... dots) {
        for (Point p : dots) {
            points2D.add(p);
        }
    }
    @Override
    public double length(){
        double res = 0.0;
        for (int i = 0; i < points2D.size()-1; i++){
            res = res + new Line(points2D.get(i).x, points2D.get(i).y, points2D.get(i+1).x, points2D.get(i+1).y).length();
        }
        return res;
    }

    @Override
    public final boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof BrokenLine that)) return false;
        if(this.getClass() == o.getClass()) return Objects.equals(points2D, that.points2D);
        List<Point> other = new ArrayList<>(that.points2D);
        List<Point> my = new ArrayList<>(points2D);
        if (this.getClass() == ClosedLine.class) my.add(this.points2D.getFirst());
        if (that.getClass() == ClosedLine.class) other.add(this.points2D.getFirst());
        return Objects.equals(my, other);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(points2D);
    }

    public String toString (){
        int count = 0 ;
        String res = "Линия [";
        for (Point x: points2D){
            res = res + " " + x;
            count++;
            if (count < points2D.size()) res = res + ",";
        }
        return res + "]";
    }
    @Override
    public BrokenLine getBroken(){
        return new BrokenLine(points2D);
    }
}
