package ru.zubrilovskaya.different.light;

public class TrafficLight {
    Signal color = Light.GREEN;

    void setColor(Light color){
        this.color = color;
    }

    public void next(){
        color.next(this);
        System.out.println(color);
    }
}
