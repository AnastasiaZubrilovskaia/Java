package ru.zubrilovskaya.main;

import ru.zubrilovskaya.different.CoverForString;
import ru.zubrilovskaya.geometry.*;
import ru.zubrilovskaya.numbers.Fraction;

import java.io.Serializable;
import java.util.List;

public class Main72 {
    public static void main(String[] args){
        //7.2.1
        System.out.println(sum(12,12.2,"hello!", new Fraction(12,4)));
        //7.2.2
        Line line = new Line(new Point(2,4),new Point(5,6));
        BrokenLine brokenLine = new BrokenLine(new Point(2,5), new Point(5,5), new Point(10,10));
        System.out.printf("%.3f%n",sumLength(new CoverForString("hello!"), line, brokenLine));
        //7.2.6
        ComboShapes group1 = new ComboShapes(List.of(new Point(12,5), new Point(34,70)));
        Line line1 = new Line(new Point(2,4),new Point(5,6));
        Line line2 = new Line(new Point(24,46),new Point(25,60));
        ComboShapes group2 = new ComboShapes(List.of(line1, line2));
        ComboShapes group3 = new ComboShapes(List.of(group1, group2));
        ComboShapes group4 = new ComboShapes(List.of(new Square(13,56,10), group3));
        group4.shift(10, "x");

    }
    //7.2.1
    public static double sum(Serializable... numbers){
        double sum = 0.0;
        for (Serializable num: numbers){
            if (num instanceof String){
                sum+=((String) num).length();
            }
            else sum+=((Number)num).doubleValue();
        }
        return sum;
    }
    //7.2.2
    public static double sumLength(Lengthable... lengths){
        double len = 0.0;
        for (Lengthable l : lengths){
            if (l != null) len+=l.length();
        }
        return len;
    }
}
