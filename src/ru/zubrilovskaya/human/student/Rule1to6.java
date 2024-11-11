package ru.zubrilovskaya.human.student;
public class Rule1to6 implements Checker{
    public boolean check (int mark){
        return mark>=1 && mark<=6;
    }
}
