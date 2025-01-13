package ru.zubrilovskaya.different.converter;

public class Writer implements Writable {
    @Override
    public void write(String data, String name) {
        System.out.println(name + ": " + data);
    }
}
