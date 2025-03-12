package ru.zubrilovskaya.different.light;

public class GreenLight implements Signal {
    static final Signal GREEN = new GreenLight();

    public GreenLight() {
    }

    @Override
    public void next(TrafficLight trafficLight) {
//        trafficLight.setColor(Yellow2Light.YELLOW2);
    }

    @Override
    public String toString() {
        return "green";
    }
}
