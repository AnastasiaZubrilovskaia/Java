package ru.zubrilovskaya.main;

import ru.zubrilovskaya.geometry.*;
import ru.zubrilovskaya.test.A;

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
        //
        Point dot1 = new Point(12,56);
        Point dot2 = new Point(2,6);
        Point dot3 = new Point(-5,5);
        Point dot4 = new Point(10,11);
        BrokenLine brokenLine = new BrokenLine(dot1, dot2, dot3, dot4);
        ClosedLine closedLine = new ClosedLine(dot1, dot2, dot3, dot4);
        GetPoints getPoints1 = new GetPoints(brokenLine);
        getPoints1.setCurrentIndex(1);
        while (getPoints1.hasNext()) System.out.println("broken line: " + getPoints1.next());

        GetPoints getPoints2 = new GetPoints(closedLine);
        for (int i = 0; i<10; i++)System.out.println("closed line: " + getPoints2.next());
    }
}
