package ru.zubrilovskaya.different.light;

public class RedLight implements Signal{
    String color = "red";
    @Override
    public void next(TrafficLight trafficLight) {
        System.out.println(color);
        trafficLight.setColor(new Yellow1Light());
    }
}
