package ru.zubrilovskaya.geometry;
public class Triangle extends Shape implements BrokenLineable {
    public Point point2;
    public Point point3;
    public Triangle(Point point1, Point point2, Point point3){
        super(point1);
        if (point3.x == point2.x && leftTop.x == point2.x ||
                point3.y == point2.y && leftTop.y == point2.y) throw new IllegalArgumentException("not Triangle");
        this.point2 = point2;
        this.point3 = point3;
    }
    @Override
    public BrokenLine getBroken(){
        return new BrokenLine(leftTop,point2, point3);
    }
    public double area(){
        double a = new Line(leftTop, point2).length();
        double b = new Line(point2, point3).length();
        double c = new Line(point3, leftTop).length();
        double p = (double) (a + b + c) /2;
        return Math.sqrt(p*(p-a)*(p-b)*(p-c));
    }

}
