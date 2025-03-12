package ru.zubrilovskaya.stack;

import java.util.ArrayList;
import java.util.List;

public class Stack <T>{
    List<T> stack = new ArrayList<>();

    public void push(T ob){
           stack.addFirst(ob);
    }

    public T pop(){
        if (stack.isEmpty()) throw new IllegalArgumentException("stack is empty");
        return stack.removeFirst();
    }

    public T peek(){
        if (stack.isEmpty()) throw new IllegalArgumentException("stack is empty");
        return stack.getFirst();
    }

    public String toString(){
        String str = "[ ";
        if (stack.isEmpty()) return "[ ]";
        for (T ob: stack){
            str += ob + " ";
        }
        return str + "]";
    }


}
