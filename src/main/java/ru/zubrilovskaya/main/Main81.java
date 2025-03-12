package ru.zubrilovskaya.main;

import ru.zubrilovskaya.annotations.Cache;
import ru.zubrilovskaya.annotations.Invoke;
import ru.zubrilovskaya.annotations.Two;
import ru.zubrilovskaya.different.reflection.Entity;
import ru.zubrilovskaya.different.reflection.ObjectsReader;
import ru.zubrilovskaya.different.reflection.ObjectsWriter;
import ru.zubrilovskaya.different.reflection.TestExecutor;
import ru.zubrilovskaya.geometry.ClosedLine;
import ru.zubrilovskaya.geometry.Line;
import ru.zubrilovskaya.geometry.Point;
import ru.zubrilovskaya.geometry.Point3D;
import ru.zubrilovskaya.human.Human;
import ru.zubrilovskaya.human.Name;
import ru.zubrilovskaya.weapons.Pistol;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.*;
import java.util.stream.Collectors;

@Two(first = "first", second = 23)
public class Main81 {
    public static void main(String[] args){
        //8.1.1
        ClosedLine closedLine=new ClosedLine();
        List<Field> fields1= getAllFields1(closedLine.getClass());
        Set<Field> fields2= getAllFields2(closedLine.getClass());
        System.out.println(fields1);
        System.out.println(fields2);

        Pistol p = new Pistol();
        System.out.println(getAllFields1(p.getClass()));
        System.out.println(getAllFields2(p.getClass()));

        //8.1.2
        Line<Point3D> line1 = new Line<>(new Point3D(12,34,7), new Point3D(6,23,45));
        Line<Point3D> line2 = new Line<>(new Point3D(2,3,4), new Point3D(8,33,5));
        lineConnector(line1,line2);
        System.out.println(line1 + " and " + line2);
        //8.1.3
        B b = new B();
        System.out.println(b);

        //8.1.4
        Human human = new Human(new Name("Ivanov", "Ivan", "Ivanich"), 190);
        TestExecutor.validation(human);

        //8.1.5
        List<Point> points = new ArrayList<>(List.of(new Point(12,4), new Point(45,8),
                new Point(0,0)));
        ObjectsWriter writer = new ObjectsWriter("D:\\Java_w\\Java\\src\\ru\\zubrilovskaya\\main\\text.txt");
        writer.toWrite(points);

        ObjectsReader<Point> reader = new ObjectsReader<>(
                "D:\\Java_w\\Java\\src\\ru\\zubrilovskaya\\main\\text.txt",
                ru.zubrilovskaya.geometry.Point.class);
        System.out.println(reader.toRead());

    }

    //8.1.1
    //1 var
    public static List<Field> getAllFields1(Class<?> clazz){
        List<Field> fields = new ArrayList<>(Arrays.asList(clazz.getDeclaredFields()));
        while (clazz.getSuperclass()!=null){
            clazz = clazz.getSuperclass();
            fields.addAll(Arrays.asList(clazz.getDeclaredFields()));
        }
        return fields;
    }
    //2 var
    public static Set<Field> getAllFields2 (Class<?> clazz){
        if(clazz.equals(Object.class)) return Set.of();
        Set<Field> fields = new HashSet<>();
        fields.addAll(Set.of(clazz.getDeclaredFields()));
        Class<?> clazzParent = clazz.getSuperclass();
        fields.addAll(getAllFields2(clazzParent));

        return fields;
    }

    //8.1.2
    @Invoke
    public static <T extends Point> void lineConnector(Line<T> line1, Line<T> line2) {
        try{
            Method methodGetEnd = line1.getClass().getMethod("getEnd");
            T point = (T) methodGetEnd.invoke(line1);
            Method methodSetBegin= line2.getClass().getMethod("setBegin", Point.class);
            methodSetBegin.invoke(line2, point);
        } catch (NoSuchMethodException | InvocationTargetException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }
}




//8.1.3
@Cache({"1", "2"})
class A extends Entity {
    String s="hello";
    int x =3;
}

class B extends A{
    String text = "B";
}




//вместо field.setAccessible(true) использовать get приватных полей
//т к setAccessible могут в проекте отключить js parsen:
//    private String getFieldValue(Field field) {
//        try{
//            Method m = getClass().getMethod("get");
//            return m.getName() + "=" + m.invoke(this) + " ";
//
//        } catch (NoSuchMethodException | InvocationTargetException | IllegalAccessException e) {
//            throw new RuntimeException(e);
//        }
//    }