public class Time {
    private int seconds;
    public Time(int seconds){
        if (seconds < 0) throw new IllegalArgumentException(" seconds must be positive");
        this.seconds = seconds%(3600*24);
    }
    public int getSeconds(){
        return seconds;
    }

    public void setSeconds(int seconds) {
        if (seconds < 0) throw new IllegalArgumentException(" seconds must be positive");
        this.seconds = seconds;
    }

    public String toString(){
        int second;
        int minutes;
        int hours;
        String res = "";
        hours = seconds / 3600;
        if (hours/10 == 0) res = res + "0" + hours + ":";
        else res = res +  hours + ":";
        minutes = seconds % 3600 / 60;
        if (minutes/10 == 0) res = res + "0" +  minutes + ":";
        else res = res +  minutes + ":";
        second = seconds % 60;
        if (second/10 == 0) res = res + "0" + second;
        else res = res +  second;

        return res;
    }
}
