package ru.zubrilovskaya.different.light;

public class Yellow2Light implements Signal{
    static final Signal YELLOW2 = new Yellow2Light();

    public Yellow2Light() {
    }

    @Override
    public void next(TrafficLight trafficLight) {
//        trafficLight.setColor(RedLight.RED);
    }

    @Override
    public String toString() {
        return "yellow";
    }
}
