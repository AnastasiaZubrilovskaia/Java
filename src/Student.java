import java.util.ArrayList;
import java.util.List;

public class Student {
    public String name;
//    public int[] marks;
    List <Integer> marks = new ArrayList<>();
    public Student(String name, int... marks){
        this.name = name;
//        this.marks = marks;
        for (int x: marks) this.marks.add(x);
    }
    public String toString(){
        String res = "имя: " + name + " [";
        int count = 0 ;
//        for (int i = 0; i < marks.length; i++){
//            res = res + marks[i];
//            if (i < marks.length - 1){
//                res = res + ", ";
//            }
//        }
        for (int x: marks){
            res= res + " " + x;
            count++;
            if (count < marks.size()) res = res + ",";
        }
        return res + "]";

    }
}
