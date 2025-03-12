package ru.zubrilovskaya.different.temperature;

//паттерн Singleton (одиночка)

public class Temperature2 {
    final String temp;
    final int min;
    final int max;
    final static Temperature2 HOT = new Temperature2("hot", 25, 60);
    final static Temperature2 COLD = new Temperature2("cold", -50, 10);
    final static Temperature2 NORMAL = new Temperature2("normal", 11, 24);

    Temperature2(String temp, int min, int max) {
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
    public String toString(){
        return temp;
    }

    public static Temperature2 getTemperature(int number){
        if (number >= HOT.getMin() && number <= HOT.getMax()) return HOT;
        if (number >= NORMAL.getMin() && number <= NORMAL.getMax()) return NORMAL;
        if (number >= COLD.getMin() && number <= COLD.getMax()) return COLD;
        throw new IllegalArgumentException("Температура не входит ни в один из диапазонов");
    }
}
