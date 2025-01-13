package ru.zubrilovskaya.geometry;
public abstract class Shape implements Combable{
    public Point leftTop;
    public Shape(Point leftTop){
        this.leftTop = leftTop;
    }
    public abstract double area();
    public  void shift(int n, String... strings){
        leftTop.shift(n, strings);
    }

}
