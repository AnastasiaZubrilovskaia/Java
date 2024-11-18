package ru.zubrilovskaya.cat;

public class Doger implements Meowable{
    Dog dog;

    public Doger(Dog dog) {
        this.dog = dog;
    }

    @Override
    public void meow() {
        dog.gav();
    }
}
