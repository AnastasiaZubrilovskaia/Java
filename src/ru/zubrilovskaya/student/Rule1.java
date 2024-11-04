package ru.zubrilovskaya.student;
public class Rule1 implements Checker{
    public boolean check (int mark){
        return mark>=1 && mark<=6;
    }
}
