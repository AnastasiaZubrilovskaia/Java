package ru.zubrilovskaya.main;

import ru.zubrilovskaya.box.Box;
import ru.zubrilovskaya.geometry.Line;
import ru.zubrilovskaya.geometry.Point3D;
import ru.zubrilovskaya.human.student.Student;
import ru.zubrilovskaya.stack.Stack;
import ru.zubrilovskaya.storage.Storage;

public class Main61 {
    public static void main(String[] args){
        //6.1.1
        Box<Integer> box1 = new Box<>();
        box1.setObject(3);
        test1(box1);
        //6.1.2
//        Storage<Integer> storage1 = new Storage<>(null);
//        test2(storage1,0);
//
//        Storage<Integer> storage2 = new Storage<>(99);
//        test2(storage2, -1);
//
//        Storage<String> storage3 = new Storage<>(null);
//        test2(storage3, "default");
//
//        Storage<String> storage4 = new Storage<>("hello");
//        test2(storage4, "hello world");
        //6.1.4
        Student student1 = new Student("Oleg", 4, 5,5);
        Student student2 = new Student("Ivan", 4, 5,5);
        System.out.println(student1.compareTo(student2));
        //6.1.5
        Point3D dot1 = new Point3D(12,34,56);
        Point3D dot2 = new Point3D(22,45,67);
        Line<Point3D> line = new Line<>(dot1,dot2);
        System.out.println(line);

        //6.1.6
        Stack<String> stack1 = new Stack<>();
        stack1.push("apple");
        stack1.push("orange");
        stack1.push("lemon");
        System.out.println(stack1.pop());
        System.out.println(stack1.peek());
        System.out.println(stack1);

    }

    //6.1.1
    public static void  test1(Box<Integer> ob){
        System.out.println(ob.getObject());
    }

    //6.1.2
    public static <T> void test2(Storage<T> ob, T alt){
        System.out.println(ob.getOb(alt));
    }

}
