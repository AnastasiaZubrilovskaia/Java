package ru.zubrilovskaya.geometry;

//паттерн Factory Method(Фабричный метод)

public class PointGenerator {

    public static Point toGenerate (int x, int y){
        return new Point(x,y);
    }
    public static Point toGenerate (int x, int y, int z){
        return new Point3D(x,y,z);
    }

}
