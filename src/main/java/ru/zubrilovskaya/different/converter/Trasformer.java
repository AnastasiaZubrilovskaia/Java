package ru.zubrilovskaya.different.converter;

public class Trasformer implements Transformable{
    Function fun;

    public Trasformer(Function fun) {
        this.fun = fun;
    }

    @Override
    public String trans(String string) {
        return fun.make(string);
    }
}
