package ru.zubrilovskaya.different.light;

public class TrafficLight {
    Signal color;

    public TrafficLight( ) {
        this.color = new GreenLight();
    }

    void setColor(Signal color){
        this.color = color;
    }

    public void next(){
        color.next(this);
    }
}
