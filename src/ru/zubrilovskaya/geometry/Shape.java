package ru.zubrilovskaya.geometry;
public abstract class Shape {
    public Point2D leftTop;
    public Shape(Point2D leftTop){
        this.leftTop = leftTop;
    }
     public abstract double area();
}
