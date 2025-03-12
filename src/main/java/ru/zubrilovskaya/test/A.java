package ru.zubrilovskaya.test;

import java.util.Objects;

public class A {
    public int x;
    public int y;
    public String s1;
    public String s2;

    public A(int x, int y, String s2, String s1) {
        this.x = x;
        this.y = y;
        this.s2 = s2;
        this.s1 = s1;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        A a = (A) o;
        if(this.x!=a.x || this.y!=a.y) return false;
        return true;
    }

//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        A a = (A) o;
//        return x == a.x && y == a.y;
//    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }
}
