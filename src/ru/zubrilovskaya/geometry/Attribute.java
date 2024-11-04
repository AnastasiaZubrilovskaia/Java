package ru.zubrilovskaya.geometry;
public abstract class Attribute {
    private String title;
    private Object value;
    public Attribute(String title, Object value){
        this.title = title;
        this.value  = value;
    }
    public String getTitle(){
        return title;
    }
    public Object getValue(){
        return value;
    }
    public String toString(){
        return "Attribute {" + "name=" + title +
                "; value=" + value + "}";
    }

}
