import java.util.ArrayList;
import java.util.List;

public class PointUniversal {
    private List<Attribute> attribute = new ArrayList<>();

    public PointUniversal(List<Attribute> attribute){
        setAttribute(attribute);
    }
    public PointUniversal(){}
    public void setAttribute(List<Attribute> attribute){
        this.attribute  = attribute;
    }
    public List<Attribute> getAttribute(){
        return new ArrayList<>(attribute);
    }
    public void addCoordinate2D(Coordinate2D coordinate){
        attribute.add(coordinate);
    }
    public void addColor(Color color){
        attribute.add(color);
    }
}
