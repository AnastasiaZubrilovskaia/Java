package ru.zubrilovskaya.postprocesses;

import org.springframework.stereotype.Component;

@Component
public class NameCheck{
    String name;
    int num;
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    @Override
    public String toString() {
        return "NameCheck{" +
                "name='" + name + '\'' +
                ", num=" + num +
                '}';
    }
}
