public class Square extends Shape implements BrokenLineable {
    private int side;
    public Square(Point2D leftTop, int side){
        super(leftTop);
        setSide(side);
    }
    public Square(int x, int y, int side){
        this(new Point2D(x,y), side);
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
        Point2D rightTop = new Point2D(leftTop.x + side, leftTop.y);
        Point2D rightBottom = new Point2D(leftTop.x + side, leftTop.y - side);
        Point2D leftBottom = new Point2D(leftTop.x, leftTop.y-side);
        return new ClosedLine(leftTop,rightTop, rightBottom, leftBottom);
    }
    public double area(){
        return (double)side*side;
    }
}
