package ru.zubrilovskaya.different;

public interface FilterRule <T>{
    boolean check(T value);
}
