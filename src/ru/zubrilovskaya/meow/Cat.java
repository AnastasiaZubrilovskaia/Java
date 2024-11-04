package ru.zubrilovskaya.meow;
public class Cat implements Meowable {
    public String name;
    public Cat(String name){
        this.name = name;
    }
    @Override
    public void meow(){
        System.out.println(name + ": мяу!");
    }
    public void meow(int count){
        String res = name + ": ";
        for (int i = 0; i < count; i++){
            res= res + "мяу";
            if (i < count-1) res= res + "-";
            else res= res + "!";
        }
        System.out.println(res); ;
    }
    public String toString(){
        return "кот: " + name;
    }
}