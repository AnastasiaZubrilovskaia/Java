public class Coordinate2D extends  Attribute{
    public Coordinate2D(int x, int y){
        super("Coordinate2D", new int[]{x,y});
    }
    public int getX(){
        return ((int[])super.getValue())[0];
    }
    public int getY(){
        return ((int[])super.getValue())[1];
    }
}
