package ru.zubrilovskaya.cat;

//паттерн Адаптер (Adapter)

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
