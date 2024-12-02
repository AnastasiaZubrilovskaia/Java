package ru.zubrilovskaya.different;

public interface Method <T,R>{
    R apply(T arg);
}
