package ru.zubrilovskaya.database;

import ru.zubrilovskaya.geometry.Point;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DataBase {
    List<String> list = new ArrayList<>();
    final int N;
    int connect = 0;
    public DataBase(int N) {
         list.addAll(Arrays.asList("note1", "note2", "note3", "note4", "note5", "note6",
                 "note7", "note8", "note9", "note10"));
         this.N = N;
    }
    boolean toConnect(){
        if (connect< N){
            connect++;
            return true;
        }
        return false;
    }


    public Connection getConnections(){
        if (connect< N){
            return new Connection(this);
        }
        return null;
    }
    public <T> T get(int index, Class<T> clas) {
        if (index < 0 || index >= list.size()) {
            throw new IndexOutOfBoundsException("Нет индекса " + index);
        }
        String value = list.get(index);
        return convert(value, clas);
    }


    private <T> T convert(String value, Class<T> clas) {
        if (clas == String.class) {
            return (T) value;
        } else if (clas == Integer.class) {
            return (T) Integer.valueOf(value);
        } else if (clas == Point.class) {
            String[] coords = value.split(",");
            if (coords.length == 2) {
                int x = Integer.parseInt(coords[0].trim());
                int y = Integer.parseInt(coords[1].trim());
                return (T) new Point(x, y);
            }
            throw new IllegalArgumentException("Не может быть данным классом");
        }
        throw new IllegalArgumentException("Нельзя конвертировать в данный объект ");
    }
}
