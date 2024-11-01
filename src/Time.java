public class Time {
    private int seconds, second, minutes, hours;

    public Time(int seconds){
        setSeconds(seconds);
    }
    public Time(int hours, int minutes, int second){
        setSecond(hours, minutes, second);
    }

    public int getSeconds(){
        return seconds;
    }
    public int getSecond(){
        return second;
    }

    public void setSeconds(int seconds) {
        if (seconds < 0) throw new IllegalArgumentException(" seconds must be positive");
        this.seconds = seconds%(3600*24);
    }
    public void setSecond(int hours, int minutes, int second) {
        if (second < 0 || minutes < 0 || hours < 0) throw new IllegalArgumentException(" seconds, hours and minutes must be positive");
        this.second = second;
        this.hours = hours;
        this.minutes = minutes;
    }
    public void count(){
        if (hours == 0 && minutes == 0){
            hours = seconds / 3600;
            minutes = seconds % 3600 / 60;
            second = seconds % 60;
        }
    }
    public int whatHours (){
        count();
        return hours;
    }
    public int whatMinutes (){
        count();
        return minutes;
    }
    public int whatSeconds (){
        count();
        return second;
    }


    public String toString(){
        count();
        String res = "";
        if (hours/10 == 0) res = res + "0" + hours + ":";
        else res = res +  hours + ":";
        if (minutes/10 == 0) res = res + "0" +  minutes + ":";
        else res = res +  minutes + ":";
        if (second/10 == 0) res = res + "0" + second;
        else res = res +  second;
        return res;
    }
}
