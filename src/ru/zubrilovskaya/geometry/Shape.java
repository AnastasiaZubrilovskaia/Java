package ru.zubrilovskaya.geometry;
public abstract class Shape {
    public Point leftTop;
    public Shape(Point leftTop){
        this.leftTop = leftTop;
    }
     public abstract double area();
}
