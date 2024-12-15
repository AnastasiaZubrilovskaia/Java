package ru.zubrilovskaya.different.light;

public class GreenLight implements Signal {
    String color = "green";
    @Override
    public void next(TrafficLight trafficLight) {
        System.out.println(color);
        trafficLight.setColor(new Yellow2Light());
    }
}
