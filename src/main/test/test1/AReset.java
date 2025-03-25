package test1;

import ru.zubrilovskaya.annotations.Default;

@Default
public class AReset {
    private int x =100, y = 200;
    private String st = "gggg";

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public String getSt() {
        return st;
    }
    public String toString() {
        return x+" "+y + " "+ st;
    }
}

