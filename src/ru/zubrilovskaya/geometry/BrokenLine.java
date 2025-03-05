package ru.zubrilovskaya.geometry;
import java.util.*;

//использвуется паттерн "Итератор"

public class BrokenLine implements Lengthable, BrokenLineable  {
    public List<Point> points = new ArrayList<>();
    int current = 0;

    public void setCurrent(int current) {
        if (current>=0 && current< points.size()) this.current = current;
    }

    public BrokenLine(List<Point> points) {
        this.points = points;
    }

    public BrokenLine(Point... points){
        this(new ArrayList<>(Arrays.asList(points)));
    }

    public BrokenLine() {}

    public boolean addPoints(List<Point> points2){
        return points.addAll(points2);
    }

    @Override
    public double length(){
        long res = 0;
        for (int i = 0; i < points.size() - 1; i++){
            res += Line.of(points.get(i), points.get(i+1)).length();
        }
        return res;
    }

    @Override
    public String toString() {
        return "Polyline " + points;
    }

    @Override
    public final boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof BrokenLine polyline)) return false;
        if (o.getClass() == this.getClass()) return Objects.equals(points, polyline.points);
        List<Point> other = new ArrayList<>(polyline.points);
        List<Point> my = new ArrayList<>(points);
        if (this.getClass() == ClosedLine.class) my.add(this.points.getFirst());
        if (polyline.getClass() == ClosedLine.class) other.add(polyline.points.getFirst());
        return Objects.equals(my, other);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(points);
    }

    @Override
    public BrokenLine getBroken() {
        return new BrokenLine(points);
    }

    public Iterator<Point> iterator(){
        return new Iterator<Point>() {
            int index = current;
            @Override
            public boolean hasNext() {
                return index < points.size();
            }

            @Override
            public Point next() {
                if(hasNext()) return points.get(index++);
                throw new IllegalArgumentException("Not points");
            }
        };
    }
}
