package ru.zubrilovskaya.geometry;

public class Line implements Lengthable, BrokenLineable {
    private Point2D begin;
    private Point2D end;

    public Line (int x1, int y1, int x2, int y2){
        this (new Point2D(x1, y1), new Point2D(x2, y2));
    }
    public Line (Point2D begin, Point2D end){
        setBegin(begin);
        setEnd(end);
    }
    public Point2D getBegin(){
        return begin;
    }
    public Point2D getEnd(){
        return  end;
    }
    public void setBegin(Point2D begin){
        this.begin = new Point2D(begin.x, begin.y);
    }
    public void setEnd(Point2D end){
        this.end = new Point2D(end.x, end.y);
    }
    @Override
    public double length(){
        int x = end.x - begin.x;
        int y = end.y - begin.y;
        return  Math.sqrt(x*x + y*y);
    }

    public String toString(){
        return "Линия от " + begin + " до " + end;
    }

    @Override
    public BrokenLine getBroken(){
        return new BrokenLine(begin,end);
    }
}
