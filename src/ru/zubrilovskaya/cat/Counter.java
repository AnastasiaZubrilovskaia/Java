package ru.zubrilovskaya.cat;

public class Counter implements Meowable{
    public int count;
    Meowable cat;

    public Counter(Meowable cat) {
        this.cat = cat;
    }

    public void meow(){
        cat.meow();
        count++;
    }
}
