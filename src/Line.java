public class Line {
    Point begin;
    Point end;

    public Line (int x1, int y1, int x2, int y2){
        this (new Point(x1, y1), new Point(x2, y2));
//        begin = new Point(x1, y1);
//        end = new Point(x2, y2);
    }
    public Line (Point begin, Point end){

        this.begin = begin;
        this.end = end;
    }

    public String toString(){
        return "Линия от " + begin + " до " + end;
    }
}
