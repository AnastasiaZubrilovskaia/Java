package ru.zubrilovskaya.birds;
public abstract class Bird {
    public String name;
    public Bird(String name){
        this.name = name;
    }
    public abstract void toSing();
}