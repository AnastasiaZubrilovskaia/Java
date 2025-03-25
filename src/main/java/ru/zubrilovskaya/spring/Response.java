package ru.zubrilovskaya.spring;



public class Response implements Comparable<Response>{
    String text;
    int mark;

    public Response(String text, int mark) {
        this.text = text;
        this.mark = mark;
    }

    @Override
    public String toString() {
        return "Response{" +
                "text='" + text + '\'' +
                ", mark=" + mark +
                '}';
    }

    @Override
    public int compareTo(Response o) {
        return this.mark - o.mark;
    }

}
