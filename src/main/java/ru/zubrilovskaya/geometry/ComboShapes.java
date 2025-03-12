package ru.zubrilovskaya.geometry;

import java.util.ArrayList;
import java.util.List;

public class ComboShapes implements Combable{
    public List<Combable> shapes;

    public ComboShapes(List<Combable> shapes) {
        this.shapes = shapes;
    }

    @Override
    public void shift(int n, String... strings) {
        for(Combable shape: shapes){
            shape.shift(n,strings);
        }
    }

}
