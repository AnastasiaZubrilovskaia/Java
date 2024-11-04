package ru.zubrilovskaya.birds;
public class Parrot extends Bird{
    public String text;
    public Parrot(String name, String text){
        super(name);
        this.text = text;
    }
    public void toSing(){
        String[] word = text.split(" ");
        String res = "";
        for (String w : word){
            char[] str = w.toCharArray();
            for (int i = 0; i < str.length; i++) {
                int index = (int) (Math.random()*str.length);
                char temp = str[i];
                str[i] = str[index];
                str[index] = temp;
            }
            res = res + new String(str) + " ";

        }

        System.out.println(name + ": " + res);
    }
}
