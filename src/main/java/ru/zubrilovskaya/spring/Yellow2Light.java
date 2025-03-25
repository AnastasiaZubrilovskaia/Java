package ru.zubrilovskaya.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component("yellow2Light")
public class Yellow2Light implements Signal2 {
    private final Signal2 GREENLIGHT;

    @Autowired
    public Yellow2Light(@Lazy @Qualifier("greenLight") Signal2 greenLight) {
        this.GREENLIGHT = greenLight;
    }

    @Override
    public void next(TrafficLight2 trafficLight) {
        trafficLight.setColor(GREENLIGHT);
    }

    @Override
    public String toString() {
        return "yellow";
    }
}