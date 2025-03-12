package ru.zubrilovskaya.storage;


import java.util.function.Supplier;

public class TmpObject {
    public static  Storage<Integer> count(int x1, int x2){
        Supplier<Integer> computation = () -> {
            int x = x1 + x2;
            System.out.println("res: " + x); // Выводим результат только при вызове
            return x;
        };
        return Storage.of(computation.get()); // Возвращаем Storage с Supplier
    }
}
