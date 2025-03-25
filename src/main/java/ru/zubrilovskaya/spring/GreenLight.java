package ru.zubrilovskaya.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component("greenLight")
public class GreenLight implements Signal2 {
    private final Signal2 YELLOWLIGHT;

    @Autowired
    public GreenLight(@Lazy @Qualifier("yellow1Light") Signal2 yellowLight) {
        this.YELLOWLIGHT = yellowLight;
    }

    @Override
    public void next(TrafficLight2 trafficLight) {
        trafficLight.setColor(YELLOWLIGHT);
    }

    @Override
    public String toString() {
        return "green";
    }
}
