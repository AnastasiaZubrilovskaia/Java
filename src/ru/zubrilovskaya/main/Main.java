package ru.zubrilovskaya.main;

import ru.zubrilovskaya.human.karate.Combo;
import ru.zubrilovskaya.human.karate.Jump;
import ru.zubrilovskaya.human.karate.KarateBoy;
import ru.zubrilovskaya.human.karate.Kick;

import java.util.List;

public class Main {
    public static void main (String[] args){
            KarateBoy k = new KarateBoy("Ivan");
            k.kick();
            k.jump();
            k.punch();
        System.out.println("2");
        Combo combo = new Combo("combo", List.of(new Kick(), new Jump()));
        combo.make(k);


    }

}
