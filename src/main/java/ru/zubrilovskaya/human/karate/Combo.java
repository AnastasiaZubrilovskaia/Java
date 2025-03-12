package ru.zubrilovskaya.human.karate;

import java.util.List;

public class Combo implements Kickable {
    String name;
    List<Kickable> kicks;

    public Combo(String name, List<Kickable> kicks) {
        this.name = name;
        this.kicks = kicks;
    }

    public void make(KarateBoy boy){
        for (Kickable x : kicks){
            x.make(boy);
        }
    }
}
