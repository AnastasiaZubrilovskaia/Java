package ru.zubrilovskaya.geometry;
public class Color extends  Attribute{
    public Color(String value){
        super("Color", value);
    }
    @Override
    public String getValue(){
        return  ((String) super.getValue());
    }
}
