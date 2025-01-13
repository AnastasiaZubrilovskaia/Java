package ru.zubrilovskaya.geometry;

import java.util.Objects;

public class Line <T extends Point> implements Lengthable, BrokenLineable, Cloneable, Combable {
    private T begin;
    private T end;

    public static Line<Point> of(int x1, int y1, int x2, int y2){
        return new Line<> (new Point(x1, y1), new Point(x2, y2));
    }
    public static <V extends Point>Line<V> of(V begin, V end){
        return new Line<> (begin,end);
    }

    public Line (T begin, T end){
        if(begin.getClass() != end.getClass()) throw new RuntimeException();
        setBegin(begin);
        setEnd(end);
    }
    public T getBegin(){
        return begin;
    }
    public T getEnd(){
        return  end;
    }
    @SuppressWarnings("unchecked")
    public void setBegin(T begin){
        if( end != null && begin.getClass() != end.getClass()) throw new RuntimeException();
        this.begin = (T) begin.clone();
    }
    @SuppressWarnings("unchecked")
    public void setEnd(T end){
        if(begin!=null && begin.getClass() != end.getClass()) throw new RuntimeException();
        this.end = (T) end.clone();
    }

    @Override
    public double length(){
        return  begin.distance(end);
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
    public void shift(int n, String... strings) {
        begin.shift(n,strings);
        end.shift(n, strings);
    }
}
