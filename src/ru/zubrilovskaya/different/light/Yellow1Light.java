package ru.zubrilovskaya.different.light;

public class Yellow1Light implements Signal{
    String color = "yellow";
    @Override
    public void next(TrafficLight trafficLight) {
        System.out.println(color);
        trafficLight.setColor(new GreenLight());
    }
}
