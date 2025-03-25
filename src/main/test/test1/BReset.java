package test1;

import ru.zubrilovskaya.annotations.Default;

public class BReset {
    public int x =100;
    @Default
    public int y = 200;
    @Default
    public String st = "gggg";

    public String toString() {
        return x+" "+y + " "+ st;
    }

}
