package ru.zubrilovskaya.spring;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class TrafficLight2 {
    private Signal2 color;

    @Autowired
    public TrafficLight2(@Qualifier("greenLight") Signal2 initialColor) {
        this.color = initialColor;
    }

    public void setColor(Signal2 color) {
        this.color = color;
    }

    public void next() {
        color.next(this);
        System.out.println("color: " + color);
    }
}