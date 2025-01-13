package ru.zubrilovskaya.different.temperature;

//паттерн Singleton (одиночка)

public enum Temperature {
    HOT("жарко", 25, 50){
        public String toString(){
            return temp;
        }
    }, COLD("холодно", -50, 10){
        public String toString(){
            return temp;
        }
    }, NORMAL("нормально", 11, 24){
        public String toString(){
            return temp;
        }
    };

    String temp;
    int min;
    int max;
    public abstract String toString();

    Temperature(String temp, int min, int max) {
        this.temp = temp;
        this.min = min;
        this.max = max;
    }

    public String getTemp() {
        return temp;
    }

    public int getMin() {
        return min;
    }

    public int getMax() {
        return max;
    }

    public static Temperature getTemperature(int number){
        if (number >= HOT.getMin() && number <= HOT.getMax()) return HOT;
        if (number >= NORMAL.getMin() && number <= NORMAL.getMax()) return NORMAL;
        if (number >= COLD.getMin() && number <= COLD.getMax()) return COLD;
        throw new IllegalArgumentException("Температура не входит ни в один из диапазонов");
    }
}
