package ru.zubrilovskaya.numbers;

//паттерн Singleton (одиночка)
public final class FractionGenerator {
    static final FractionGenerator INSTANCE = new FractionGenerator();

    FractionGenerator() {
    }

    public static FractionGenerator getInstance() {
        return INSTANCE;
    }

    public static Fraction toGenerate(int num, int den) {
        return new Fraction(num, den);
    }

}
