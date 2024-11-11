package ru.zubrilovskaya.geometry;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
