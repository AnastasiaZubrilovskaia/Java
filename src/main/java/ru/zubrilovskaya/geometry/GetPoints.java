package ru.zubrilovskaya.geometry;

import java.util.Iterator;

public class GetPoints implements Iterator<Point> {
    BrokenLine line;
   int  currentIndex = 0;

    public void setCurrentIndex(int currentIndex) {
        this.currentIndex = currentIndex;
    }

    public GetPoints(BrokenLine line) {
        this.line = line;
    }

    @Override
    public boolean hasNext() {
        if(line.getClass() == BrokenLine.class){
            return currentIndex < line.points.size();
        }
        return true;
    }

    @Override
    public Point next() {
        if(line.getClass() == BrokenLine.class){
            return line.points.get(currentIndex++);
        }
        if (currentIndex == line.points.size()) currentIndex=0;
        return line.points.get(currentIndex++);
    }

}
