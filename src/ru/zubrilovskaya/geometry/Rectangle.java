package ru.zubrilovskaya.geometry;
public class Rectangle extends Square{
    private int side2;
    public Rectangle(Point2D leftTop, int side1, int side2){
        super(leftTop, side1);
        setSide2(side2);
    }

    public void setSide2(int side2){
        if(side2 <= 0) throw new IllegalArgumentException(" side must be positive");
        this.side2 = side2;
    }

    public int getSide2(){
        return side2;
    }
    @Override
    public double area(){
        return (double) getSide()*side2;
    }
    @Override
    public BrokenLine getBroken(){
        Point2D rightTop = new Point2D(leftTop.x + getSide(), leftTop.y);
        Point2D rightBottom = new Point2D(leftTop.x + getSide(), leftTop.y - side2);
        Point2D leftBottom = new Point2D(leftTop.x, leftTop.y-side2);
        return new BrokenLine(leftTop,rightTop, rightBottom, leftBottom);
    }
}
