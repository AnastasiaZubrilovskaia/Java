package ru.zubrilovskaya.cat;

public class Alertor implements Meowable{
    Meowable cat;
    public Alertor(Meowable cat) {
        this.cat = cat;
    }
    public void meow(){
        System.out.println("Allert");
        cat.meow();
    }
}