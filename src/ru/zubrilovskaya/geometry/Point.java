package ru.zubrilovskaya.geometry;

public class Point extends Point1D implements Comparable<Point>{
    public int y;
    public Point(int x, int y){
        super(x);
        this.y = y;
    }
    @Override
    public String toString(){
        return "{" + x + ";" + y + "}";
    }

    @Override
    public int compareTo(Point o) {
        if (this.x != o.x) return this.x-o.x;
        return this.y - o.y;
    }

}
