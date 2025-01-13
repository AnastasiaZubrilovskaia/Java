package ru.zubrilovskaya.different;

import ru.zubrilovskaya.geometry.Lengthable;

public class CoverForString implements Lengthable {
     String string;

    public CoverForString(String string) {
        this.string = string;
    }

    public String getString() {
        return string;
    }

    @Override
    public double length() {
        return string.length();
    }
}
