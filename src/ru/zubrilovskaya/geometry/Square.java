package ru.zubrilovskaya.geometry;
public class Square extends Shape implements BrokenLineable {
    private int side;
    public Square(Point leftTop, int side){
        super(leftTop);
        setSide(side);
    }


    public Square(int x, int y, int side){
        this(new Point(x,y), side);
    }

    public void setSide(int side){
        if(side <= 0) throw new IllegalArgumentException(" side must be positive");
        this.side = side;
    }
    public int getSide(){
        return side;
    }

    public  String toString(){
        return  "Квадрат в точке " + leftTop + "со стороной " + side;
    }
    @Override
    public BrokenLine getBroken(){
        Point rightTop = new Point(leftTop.x + side, leftTop.y);
        Point rightBottom = new Point(leftTop.x + side, leftTop.y - side);
        Point leftBottom = new Point(leftTop.x, leftTop.y-side);
        return new ClosedLine(leftTop,rightTop, rightBottom, leftBottom);
    }
    public double area(){
        return (double)side*side;
    }
}
