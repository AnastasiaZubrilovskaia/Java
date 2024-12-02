package ru.zubrilovskaya.geometry;

import java.util.Objects;

public class Point  implements Comparable<Point>, Cloneable{
    public int x;
    public int y;
    public Point(int x, int y){
        this.x = x;
        this.y = y;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Point point = (Point) o;
        return x == point.x && y == point.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }

    public double distance(Point point){
        return Math.sqrt(Math.pow(point.x-this.x, 2) + Math.pow(point.y-this.y, 2));
    }

    @Override
    public Point clone() {
        try{
            return (Point) super.clone();
        }catch (CloneNotSupportedException e){
            throw new RuntimeException(e);
        }

    }

    @Override
    public int compareTo(Point o) {
        if (this.x != o.x) return this.x-o.x;
        return this.y - o.y;
    }
    @Override
    public String toString(){
        return "{" + x + ";" + y + "}";
    }

}
