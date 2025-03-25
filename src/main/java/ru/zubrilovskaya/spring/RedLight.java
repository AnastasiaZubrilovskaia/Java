package ru.zubrilovskaya.spring;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

@Component("redLight")
public class RedLight implements Signal2 {
    private final Signal2 YELLOWLIGHT;

    @Autowired
    public RedLight(@Lazy @Qualifier("yellow2Light") Signal2 yellowLight) {
        this.YELLOWLIGHT = yellowLight;
    }

    @Override
    public void next(TrafficLight2 trafficLight) {
        trafficLight.setColor(YELLOWLIGHT);
    }

    @Override
    public String toString() {
        return "red";
    }
}