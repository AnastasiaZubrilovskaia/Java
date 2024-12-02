package ru.zubrilovskaya.main;

import ru.zubrilovskaya.box.Box;
import ru.zubrilovskaya.different.DataStream;
import ru.zubrilovskaya.different.Function;
import ru.zubrilovskaya.geometry.Line;
import ru.zubrilovskaya.geometry.Point;
import ru.zubrilovskaya.geometry.Point3D;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main62 {
    public static void main(String[] args){
        //6.2.1
        Line<Point> line = new Line<>(new Point(12,22), new Point(23,45));
        moveTo(line);
        System.out.println("6.2.1: "+ line);
        //6.2.2
        Box<Integer> num1 = new Box<>();
        Box<Double> num2 = new Box<>();
        num2.setObject(34.5);
        Box<Integer> num3 = new Box<>();
        num3.setObject(50);
        System.out.println("6.2.2: "+ max(List.of(num1, num2, num3)));
        //6.2.3
        Box<Point3D> box= new Box<>();
        putPoint3D(box);
        System.out.println("6.2.3: "+ box.getObject());
        //6.2.4
        List<Number> list = new ArrayList<>();
        fillList(list);
        System.out.println("6.2.4: "+ list);
        //6.3.1
        List<String> list1 = new ArrayList<>(List.of("qwerty", "asdfg", "zx"));
        List<Integer> list2 = DataStream.map(list1, a->a.length());
        System.out.println("6.3.1(1): "+list2);
        List<Integer> list3 = new ArrayList<>(List.of(1, -3, 7));
        List<Integer> list4 = DataStream.map(list3, a -> a>0?a:-a);
        System.out.println("6.3.1(2): "+ list4);
        int[] arr1 = {1,2,3,4};
        int[] arr2 = {1,2,3,40};
        int[] arr3 = {1,2,37,4};
        int[] arr4 = {-11,-2,-3,-14};
        List<int[]> list5 = new ArrayList<>(List.of(arr1,arr2,arr3,arr4));
        List<Integer> list6 = DataStream.map(list5, a-> Arrays.stream(a).max().orElse(0));
        System.out.println("6.3.1(3): "+list6);
        //6.3.2
        List<String> list7 = DataStream.filter(list1, a-> a.length()<3);
        System.out.println("6.3.2(1): "+list7);
        List<Integer> list8 = DataStream.filter(list3,a->a>0);
        System.out.println("6.3.2(2): "+list8);
        List<int[]> list9 = DataStream.filter(list5, a-> Arrays.stream(a).allMatch(num->num<0));
        for (int[] x: list9) System.out.println("6.3.2(3): "+Arrays.toString(x));
        //6.3.3
        String str = reduction(list1, (res,a)->res+a, "0");
        System.out.println("6.3.3(1): "+ str);
        int sum = reduction(list3, (res,a)->res+a, 0);
        System.out.println("6.3.3(2): "+ sum);
        List<Integer> list10 = new ArrayList<>(Arrays.asList(1,2,3));
        List<Integer> list11 = new ArrayList<>(Arrays.asList(1,22,3811,90));
        List<Integer> list12 = new ArrayList<>(Arrays.asList());
        List<List<Integer>> lists = new ArrayList<>(List.of(list10,list11,list12));
        List<Integer> list13 = DataStream.map(lists, a->a.size());
        int size = reduction(list13, (res,a)->res+a,0);
        System.out.println("6.3.3(3): "+ size);
        //6.3.4
//        List<List<Integer>> list14 = DataStream.collect(list3,
//                new ArrayList<>(List.of(new ArrayList<>(),new ArrayList<>())),
//                a-> a>0?a. :-a);
    }

    //6.2.1
    public static <T extends Point> void moveTo(Line<T> line){
        T begin = line.getBegin();
        begin.x +=10;
        line.setBegin(begin);
    }

    //6.2.2
    public static double max(List<Box<? extends Number>> number){
        if (number==null || number.isEmpty()) throw new RuntimeException();
        Double max = null;
        for(Box box: number){
            if(!box.isEmpty()){
                Number temp = (Number) box.getObject();
                if(max==null) max=temp.doubleValue();
                else max = Math.max(max, temp.doubleValue());
            }
        }
        if (max == null) throw new IllegalArgumentException("Все коробки пустые");
        return max;
    }

    //6.2.3
    public static void putPoint3D(Box<? super Point3D> box){
        Point3D point = new Point3D((int)(Math.random()*100),(int)(Math.random()*100), (int)(Math.random()*100));
        box.setObject(point);
    }

    //6.2.4
    public static void fillList(List<? super Integer> list){
        for(int i = 1; i <= 100; i++){
            list.add(i);
        }
    }

    //6.3.3
    public static <T> T reduction(List<T> values, Function<T> fun, T alternative){
        if (values.isEmpty()) return alternative;
        T res = values.get(0);
        for (T x: values.subList(1, values.size())){
            res= fun.apply(res,x);
        }
        return res;
    }

}
