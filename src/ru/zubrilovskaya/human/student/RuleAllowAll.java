package ru.zubrilovskaya.human.student;

public class RuleAllowAll extends Rule{
    @Override
    public boolean check (int mark){
        return true;
    }
}
