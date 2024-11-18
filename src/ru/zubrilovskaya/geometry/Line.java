package ru.zubrilovskaya.geometry;

import java.util.Objects;

public class Line implements Lengthable, BrokenLineable, Cloneable {
    private Point begin;
    private Point end;

    public Line (int x1, int y1, int x2, int y2){
        this (new Point(x1, y1), new Point(x2, y2));
    }
    public Line (Point begin, Point end){
        setBegin(begin);
        setEnd(end);
    }
    public Point getBegin(){
        return begin;
    }
    public Point getEnd(){
        return  end;
    }
    public void setBegin(Point begin){
        this.begin = new Point(begin.x, begin.y);
    }
    public void setEnd(Point end){
        this.end = new Point(end.x, end.y);
    }
    @Override
    public double length(){
        int x = end.x - begin.x;
        int y = end.y - begin.y;
        return  Math.sqrt(x*x + y*y);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Line line = (Line) o;
        return Objects.equals(begin, line.begin) && Objects.equals(end, line.end) ||
                Objects.equals(begin, line.end) && Objects.equals(end, line.begin);
    }

    @Override
    public int hashCode() {
        Point start = begin.hashCode() < end.hashCode() ? begin : end;
        Point finish = begin.hashCode() < end.hashCode() ? end : begin;
        return Objects.hash(start, finish);
    }

    @Override
    public Line clone(){
        try{
            Line line = (Line) super.clone();
            line.begin = this.begin.clone();
            line.end = this.end.clone();
            return line;
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }

    }

    public String toString(){
        return "Линия от " + begin + " до " + end;
    }

    @Override
    public BrokenLine getBroken(){
        return new BrokenLine(begin,end);
    }
}
