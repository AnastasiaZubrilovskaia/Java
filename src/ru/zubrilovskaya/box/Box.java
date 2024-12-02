package ru.zubrilovskaya.box;

public class Box <T>{
    T ob;

    public void setObject(T ob){
        if (this.ob != null) throw new IllegalArgumentException("Коробка не пуста");
        this.ob = ob;
    }

    public T getObject(){
        T ob2 = ob;
        ob = null;
        return ob2;
    }

    public boolean isEmpty(){
        return ob == null;
    }

}
