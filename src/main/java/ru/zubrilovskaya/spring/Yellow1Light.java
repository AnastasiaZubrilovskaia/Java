package ru.zubrilovskaya.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component("yellow1Light")
public class Yellow1Light implements Signal2 {
    private final Signal2 REDLIGHT;

    @Autowired
    public Yellow1Light(@Lazy @Qualifier("redLight") Signal2 redLight) {
        this.REDLIGHT = redLight;
    }

    @Override
    public void next(TrafficLight2 trafficLight) {
        trafficLight.setColor(REDLIGHT);
    }

    @Override
    public String toString() {
        return "yellow";
    }
}