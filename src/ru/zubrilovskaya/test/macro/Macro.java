package ru.zubrilovskaya.test.macro;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class Macro<T> {
    String name;
    List<T> data = new ArrayList<>();
    List<Function<T,T>> functions = new ArrayList<>();

    public Macro(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public List<T> getData() {
        return new ArrayList<>(data);
    }

    public void setData(List<T> data) {
        this.data = data;
    }

    public void addData(T data){
        this.data.add(data);
    }

    public void setFunctions(List<Function<T,T>> functions) {
        this.functions = functions;
    }
    public void runFunction(){
        for (Function<T, T> function : functions) {
            for (int i = 0; i < data.size(); i++) {
                T tmp = data.get(i);
                tmp = function.apply(tmp);
                data.set(i, tmp);
            }
        }
    }

    public static Macro<?> find(List<Macro<?>> macros, String name){
        for(Macro<?> macro: macros){
            if(name.equals(macro.name)) return macro;
        }
        return null;
    }
}
