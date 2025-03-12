package ru.zubrilovskaya.different.light;

public class RedLight implements Signal{
    static final Signal RED = new RedLight();

    public RedLight() {
    }

    @Override
    public void next(TrafficLight trafficLight) {
//        trafficLight.setColor(Yellow1Light.YELLOW1);
    }

    @Override
    public String toString() {
        return "red";
    }
}
