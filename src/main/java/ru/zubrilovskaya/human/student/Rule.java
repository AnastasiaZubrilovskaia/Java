package ru.zubrilovskaya.human.student;
public class Rule implements Checker{
    public boolean check (int mark){
        return mark>=2;
    }
}
