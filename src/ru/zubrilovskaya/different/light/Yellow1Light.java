package ru.zubrilovskaya.different.light;

public class Yellow1Light implements Signal{
    static final Signal YELLOW1 = new Yellow1Light();

    public Yellow1Light() {
    }

    @Override
    public void next(TrafficLight trafficLight) {
//        trafficLight.setColor(GreenLight.GREEN);
    }

    @Override
    public String toString() {
        return "yellow";
    }
}
