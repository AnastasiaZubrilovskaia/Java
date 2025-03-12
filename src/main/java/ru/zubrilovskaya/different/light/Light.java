package ru.zubrilovskaya.different.light;

public enum Light implements Signal{
    GREEN("green"){
        @Override
        public void next(TrafficLight trafficLight) {
            trafficLight.setColor(YELLOW1);
        }
    },
    YELLOW1("yellow"){
        @Override
        public void next(TrafficLight trafficLight) {
            trafficLight.setColor(RED);
        }
    },
    RED ("red"){
        @Override
        public void next(TrafficLight trafficLight) {
            trafficLight.setColor(YELLOW2);
        }
    },
    YELLOW2("yellow"){
        @Override
        public void next(TrafficLight trafficLight) {
            trafficLight.setColor(GREEN);
        }
    };

    String color;

    Light(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "Light{" +
                "color='" + color + '\'' +
                '}';
    }
}
