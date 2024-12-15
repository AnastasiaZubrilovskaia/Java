package ru.zubrilovskaya.different;


public interface DeferredCalculations<T, V>{
    V apply(T fun);
    boolean isEnd();
}
