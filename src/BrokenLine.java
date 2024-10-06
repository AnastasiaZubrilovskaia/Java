import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BrokenLine {
    List <Point> points = new ArrayList<>();

    public BrokenLine(List<Point> points){
        this.points = points;
    }
    public BrokenLine(Point... points){
//        for (Point x: points) this.points.add(x);
        this(Arrays.asList(points));
    }

    public String toString (){
        int count = 0 ;
        String res = "Линия [";
        for (Point x: points){
            res = res + " " + x;
            count++;
            if (count < points.size()) res = res + ",";
        }
        return res + "]";
    }
}
