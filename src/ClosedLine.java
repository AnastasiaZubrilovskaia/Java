import java.util.Arrays;
import java.util.List;

public class ClosedLine extends BrokenLine{
    public ClosedLine(Point2D... points2D){
        this(Arrays.asList(points2D));
    }
    public ClosedLine(List<Point2D> points2D){
        super(points2D);
    }
    @Override
    public double length() {
        return super.length() + new Line(points2D.getFirst(), points2D.getLast()).length();
    }
}
