package ru.zubrilovskaya.main;

import ru.zubrilovskaya.different.stock.Bot;
import ru.zubrilovskaya.different.stock.Printer;
import ru.zubrilovskaya.different.stock.Stock;
import ru.zubrilovskaya.geometry.*;
import ru.zubrilovskaya.test.A;
import ru.zubrilovskaya.test.bank.Operation;
import ru.zubrilovskaya.test.compartment.Compartment;
import ru.zubrilovskaya.test.compartment.Person;
import ru.zubrilovskaya.test.macro.Macro;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class Test {
    public static void main(String[] args){
        int[] arr={1,2,3};
        int[] arr2={1,2,3};
        String str1 = "hello";
        String str2 = "hello";
        String str3 = new String("hello");
        String str4 = new String("hello");
        System.out.println(arr==arr2);
        System.out.println(str1 == str2);
        System.out.println(str1 == str3);
        System.out.println(str4 == str3);
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

        //
        Stock stock1 = new Stock("ORCL", 75);
        Stock stock2 = new Stock("TSLA", 696);
        Printer printer = new Printer("Printer", List.of(stock1, stock2));
        Bot bot = new Bot("Bot", stock1);
        stock2.setCost(700);
        stock1.setCost(71);
        stock1.setCost(69);
        //
        Operation op = Operation.SUM;
        System.out.println(op.action(23,56));
        //
        Person person1 = new Person("Alex", "man");
        Person person2 = new Person("Ivan", "man");
        Person person3 = new Person("Anton", "man");
        Person person4 = new Person("Ivan", "man");
        Person person5 = new Person("Lena", "woman");
        Person person6 = new Person("Petr", "man");
        Compartment compartment = new Compartment();
        compartment.payPlace(person1,1);
        compartment.payPlace(person4,4);
        compartment.payPlace(person2, 3);
        compartment.payPlace(person3, 2);
        System.out.println(compartment.getPeople());
        System.out.println(compartment.getPlaces());
        //
        Macro<Integer> macro = new Macro<>("Macro1");
        macro.setData(Arrays.asList(1,2,3,4,5));
        macro.setFunctions(List.of(x->x+10));
        macro.runFunction();
        System.out.println(macro.getData());
        Macro<String> macro1 = new Macro<>("Macro2");
        macro1.setData(Arrays.asList("cat","dog", "puppy"));
        macro1.setFunctions(List.of(x->x.toUpperCase(), x->x.toLowerCase()));
        macro1.runFunction();
        System.out.println(macro1.getData());
       Macro<String> m = (Macro<String>) Macro.find(List.of(macro, macro1), "Macro2");
        System.out.println(m.getData());
    }
}
