package ru.zubrilovskaya.human.student;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class Student implements Cloneable{
    private String name;
    private List <Integer> marks = new ArrayList<>();
    private Checker rule;

    public Student(String name, Integer... marks){
        this (name, new RuleAllowAll(), Arrays.asList(marks));
    }
    public Student(String name, List<Integer> marks){
        this (name, new RuleAllowAll(), marks);
    }
    public Student(String name, Checker rule, Integer... marks){this (name, rule, Arrays.asList(marks));}

    public Student(String name, Checker rule, List<Integer> marks){
        setName(name);
        setRule(rule);
        addMark(marks);
    }
    public Student(Student st){
        this.name = st.name;
        this.rule = st.rule;
        this.marks = new ArrayList<>(st.marks);
    }

     void setRule(Checker rule){
        if (rule == null) throw new IllegalArgumentException("rule can not be null");
        this.rule = rule;
    }
    public Checker getRule(){
        return rule;
    }

    public void setName(String name) {
        if (name == null || name.isBlank()) throw new IllegalArgumentException("Error");
        this.name = name;
    }

    public void addMark(List<Integer> marks) {
        for (int x: marks){
            if (!rule.check(x)) throw new IncorrectMarkException(x);
        }
        this.marks.addAll(marks);
    }

    public void addMark(Integer... marks){
        addMark(Arrays.asList(marks));
    }

    public String getName(){
        return name;
    }
    public List<Integer> getMarks(){
        return new ArrayList<>(marks);
    }

    public double averageValue(){
        if (marks.isEmpty()) return 0;
        int res = 0;
        for (int x: marks) res+=x;
        return (double) res /marks.size();
    }


    public boolean isExcellentStudent(){
        return averageValue() == 5;
    }

//    @Override
//    public Student clone() throws CloneNotSupportedException {
//        Student st = (Student) super.clone();
//        st.marks = new ArrayList<>(this.marks);
//        st.rule = rule.clone();
//        return st;
//    }

    public String toString(){
        String res = "имя: " + name + " [";
        int count = 0 ;

        for (int x: marks){
            res= res + " " + x;
            count++;
            if (count < marks.size()) res = res + ",";
        }
        return res + "]";
    }
}
