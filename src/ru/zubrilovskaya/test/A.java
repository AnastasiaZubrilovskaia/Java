package ru.zubrilovskaya.test;

import java.util.Objects;

public class A {
    public int x;
    public int y;
    public String s;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        A a = (A) o;
        return Objects.equals(s, a.s);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(s);
    }
}
