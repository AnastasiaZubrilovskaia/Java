package ru.zubrilovskaya.main;

import java.awt.Point;
import java.math.BigInteger;

import ru.zubrilovskaya.geometry.Point2D;
import ru.zubrilovskaya.numbers.Fraction;

import static java.lang.Integer.parseInt;
import static java.lang.Math.pow;
import static ru.zubrilovskaya.main.Main33.sum;


public class Main41 {
    public static void main (String[] args){
        //4.1.3
        Fraction num2 = new Fraction(11,3);
        BigInteger num4 = new BigInteger("12345678912345678912");
        System.out.printf("%.3f%n", sum(7, num2, 3.21, num4));
        //4.1.4
        System.out.println(power(args[0], args[1]));
        //4.1.5
        Point2D dot1 = new Point2D(23,45);
        Point dot3 = new Point(100,100);
        System.out.println(dot1);
        System.out.println(dot3);
//        java.awt.Point dot2 = new java.awt.Point(12,22);
    }
    //4.1.4
    public static double power (String x, String y){
        int newX = parseInt(x);
        int newY = parseInt(y);
        return pow(newX, newY);
    }

}
