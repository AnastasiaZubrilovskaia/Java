package ru.zubrilovskaya.human.karate;

public class KarateBoy {
    String name;

    public KarateBoy(String name) {
        this.name = name;
    }

    public void kick(){
        System.out.println(name + "kyaaaaa");
    }
    public void punch(){
        System.out.println(name + "uuuuuuuuu");
    }

    public void jump(){
        System.out.println(name + "AAAAA");
    }
}
