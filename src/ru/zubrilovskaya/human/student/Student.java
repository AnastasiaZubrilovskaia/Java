package ru.zubrilovskaya.human.student;

import ru.zubrilovskaya.comparison.Comparable;

import java.util.*;

//используется паттерн "Хранитель" для сохрнения текущего состояния

public class Student implements  Comparable<Student> {
    private String name;
    private List <Integer> marks = new ArrayList<>();
    Checker rule;
    private Deque<UndoOperation> operations = new ArrayDeque<>();

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
        String temp = this.name;
        operations.push(()->this.name = temp);
        if (name == null || name.isBlank()) throw new IllegalArgumentException("Error");
        this.name = name;
    }

    public void addMark(List<Integer> marks) {
        for (int x: marks){
            if (!rule.check(x)) throw new IncorrectMarkException(x);
        }
        this.marks.addAll(marks);
        int size = marks.size();
        operations.push(()-> {
            for(int i = 0; i < size; i++) this.marks.removeLast();
        });
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

    @Override
    public int compareTo(Student st) {
        if (this.averageValue() > st.averageValue()) return 1;
        else if (this.averageValue() == st.averageValue()) return 0;
        else return -1;
    }

    public Iterator<Integer> iterator(){
        return new Iterator<>() {
            int currentMark = 0;
            @Override
            public boolean hasNext() {
                return currentMark < marks.size();
            }

            @Override
            public Integer next() {
                return marks.get(currentMark++);
            }
        };
    }

    public void removeMark(int index){
        if(index < 0 || index >= marks.size()) throw new ArrayIndexOutOfBoundsException();
        int mark = marks.get(index);
        operations.push(()->this.marks.add(index, mark));
        marks.remove(index);
    }

    public Save save(){
        SaveStudent student = new SaveStudent(this.getName(), new ArrayList<>(this.getMarks()));
        return student;
    }

    public void undo(){
        operations.pop().make();
    }

    class SaveStudent implements Save{
        private String name;
        private List<Integer> marks;

        public SaveStudent(String name, List<Integer> grades) {
            this.name = name;
            this.marks = grades;
        }

        @Override
        public void loadSave(Student student) {
            Student.this.marks = new ArrayList<>(this.marks);
            Student.this.name = this.name;
        }
    }
}



