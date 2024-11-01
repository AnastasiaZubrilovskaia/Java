import java.awt.*;

public class Point2D extends Point1D {
    public int y;
    public Point2D(int x, int y){
        super(x);
        this.y = y;
    }
    @Override
    public String toString(){
        return "{" + x + ";" + y + "}";
    }
}
