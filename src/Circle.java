public class Circle extends Shape{
    private int radius;
    public Circle(Point2D point, int radius){
        super(point);
        setRadius(radius);
    }
    public void setRadius(int radius){
        if(radius <= 0) throw new IllegalArgumentException(" radius must be positive");
        this.radius = radius;
    }
    public int getRadius(){
        return radius;
    }

    @Override
    public double area() {
        return Math.PI*radius*radius;
    }
}
