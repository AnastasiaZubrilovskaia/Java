package ru.zubrilovskaya.main;

import ru.zubrilovskaya.human.student.Save;
import ru.zubrilovskaya.human.student.Student;

import java.util.List;

public class Main64 {
    public static void main(String[] args) {
        Student student = new Student("Vasya");
        student.addMark(List.of(4));
        student.addMark(List.of(3));
        student.addMark(List.of(6));
        System.out.println(student);

        Save save = student.save();

        student.setName("Nastya");
        student.addMark(List.of(5,4));
        student.addMark(List.of(5,5,5));
        student.addMark(List.of(5));

        System.out.println(student);

//       возвращаемся к начальному состоянию
        save.loadSave(student);
        System.out.println(student);

        // откат на опреацию назад
        student.addMark(List.of(5,5,7));
        student.removeMark(2);
        student.setName("Cat");
        System.out.println(student);
        student.undo();
        System.out.println(student);
        student.undo();
        System.out.println(student);
        student.undo();
        System.out.println(student);

    }
}
