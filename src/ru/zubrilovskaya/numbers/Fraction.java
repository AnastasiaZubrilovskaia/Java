package ru.zubrilovskaya.numbers;
public final class Fraction extends Number{
    final int numerator;
    final int denominator;
    public Fraction(int numerator, int denominator){
        if (denominator <= 0) throw new IllegalArgumentException("denominator must be positive and greater than 0 ");
        this.numerator = numerator;
        this.denominator = denominator;
    }
    @Override
    public String toString (){
        return numerator + "/" + denominator;
    }
    private int nod(int num1, int num2){
        return num2 == 0 ? num1 : nod(num2, num1%num2);
    }
    private int[] drob(int numerator, int denominator){
        int nod = nod (numerator, denominator);
        int[] arr = new int[2];
        arr[0] = numerator / nod;
        arr[1] = denominator / nod;
        return arr;
    }
    public Fraction sum(Fraction number){
        int newNumerator = numerator * number.denominator + number.numerator * denominator;
        int newDenominator = denominator * number.denominator;
        int[] arr = drob(newNumerator, newDenominator);
        return  new Fraction(arr[0], arr[1]);
    }
    public Fraction minus(Fraction number){
        int newNumerator = numerator * number.denominator - number.numerator * denominator;
        int newDenominator = denominator * number.denominator;
        int[] arr = drob(newNumerator, newDenominator);
        return  new Fraction(arr[0], arr[1]);
    }
    public Fraction composition(Fraction number){
        int newNumerator = numerator * number.numerator;
        int newDenominator = denominator * number.denominator;
        int[] arr = drob(newNumerator, newDenominator);
        return  new Fraction(arr[0], arr[1]);
    }
    public Fraction div (Fraction number){
        int newNumerator = numerator * number.denominator;
        int newDenominator = denominator * number.numerator;
        int[] arr = drob(newNumerator, newDenominator);
        return  new Fraction(arr[0], arr[1]);
    }
    public Fraction sum(int number){
        return  sum(new Fraction(number, 1));
    }
    public Fraction minus(int number){
        return  minus(new Fraction(number, 1));
    }
    public Fraction composition(int number){
        return  composition(new Fraction(number, 1));
    }
    public Fraction div (int number){
        return  div(new Fraction(number, 1));
    }

    @Override
    public int intValue() {
        return numerator / denominator;
    }

    @Override
    public long longValue() {
        return numerator / denominator;
    }

    @Override
    public float floatValue() {
        return (float) numerator / denominator;
    }

    @Override
    public double doubleValue() {
        return (double) numerator / denominator;
    }
}
