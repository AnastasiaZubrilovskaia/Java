package ru.zubrilovskaya.main;

import ru.zubrilovskaya.test.A;
import ru.zubrilovskaya.geometry.Point;

public class Test {
    public static void main(String[] args){
        int[] arr={1,2,3};
        int[] arr2={1,2,3};
        String str1 = "hello";
        String str2 = "hello";
        String str3 = new String("hello");
        System.out.println(arr==arr2);
        System.out.println(str1 == str2);
        System.out.println(str1 == str3);
        A a1 = new A(1,2,"tre","ghj");
        A a2 = new A(1,2,"kj","hy");
        System.out.println(a1.equals(a2));
        System.out.println(a1.getClass());
        //
        Point p = new Point(1,2);
        Point p1 = p;
        p = null;
        p1 = null;
        System.out.println(p);
        System.out.println(p1);
    }
}
