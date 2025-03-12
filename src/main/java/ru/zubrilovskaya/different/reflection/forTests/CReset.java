package ru.zubrilovskaya.different.reflection.forTests;

public class CReset {
    private int x =100;
    private int y = 200;
    private String st = "gggg";

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public String getSt() {
        return st;
    }

    public String toString() {
        return x+" "+y + " "+ st;
    }
}
