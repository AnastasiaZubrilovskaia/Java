package ru.zubrilovskaya.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.zubrilovskaya.human.student.Checker;
import ru.zubrilovskaya.human.student.Student;


import java.util.Arrays;
import java.util.List;

@Component
public class StudentBuilder {

    Checker range;
    @Autowired
    public StudentBuilder( Checker range) {
        this.range = range;
    }


    public Student build(String name, List<Integer> marks){
        return new Student(name, range, marks);
    }
    public Student build(String name, Integer... marks){
        return build(name, Arrays.asList(marks));
    }
}
