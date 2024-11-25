package ru.zubrilovskaya.human.karate;

public class Jump implements Kickable {

    @Override
    public void make(KarateBoy boy) {
        boy.jump();
    }
}
