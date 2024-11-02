import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Student {
    private String name;
    private List <Integer> marks = new ArrayList<>();
    public Checker rule;
    public Student(String name, Integer... marks){
        this (name, Arrays.asList(marks));
    }
    public Student(String name, List<Integer> marks){
//        if (name == null || name.isBlank()) throw new IllegalArgumentException("Error");
//        this.name = name;
//        this.marks = marks;
        setName(name);
        setMark(marks);
    }
    public Student(String name){
        setName(name);
    }
    public void setName(String name) {
        if (name == null || name.isBlank()) throw new IllegalArgumentException("Error");
        this.name = name;
    }
    public void setMark(List<Integer> marks) {
        for (int x: marks){
            if (!rule.check(x)) throw new IllegalArgumentException("Error");
        }
        this.marks.addAll(marks);
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
}
