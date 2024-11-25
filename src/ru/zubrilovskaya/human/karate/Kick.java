package ru.zubrilovskaya.human.karate;

public class Kick implements Kickable {
    @Override
    public void make(KarateBoy boy) {
        boy.kick();
    }
}
