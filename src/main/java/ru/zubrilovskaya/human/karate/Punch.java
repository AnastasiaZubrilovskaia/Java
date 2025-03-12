package ru.zubrilovskaya.human.karate;

public class Punch implements Kickable {

    @Override
    public void make(KarateBoy boy) {
        boy.punch();
    }
}
