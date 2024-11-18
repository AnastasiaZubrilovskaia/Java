package ru.zubrilovskaya.cat;

public class Dog {
    public String name;

    public Dog(String name) {
        this.name = name;
    }
    public void gav(){
        System.out.println(name + ": gav!");
    }
    public String toString(){
        return "dog: " + name;
    }
}
