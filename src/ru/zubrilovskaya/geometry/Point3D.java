package ru.zubrilovskaya.geometry;

import java.util.Objects;

public class Point3D extends Point{
    public int z;
    public Point3D(int x, int y, int z){
        super(x,y);
        this.z = z;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Point3D point3D = (Point3D) o;
        return z == point3D.z;
    }

    @Override
    public void shift(int n, String... strings) {
        for(String str: strings){
            if (str == "X" || str == "x") x+=n;
            else if (str == "Y" || str == "y") y+=n;
            else if (str == "Z" || str == "z") z+=n;
            else throw new IllegalArgumentException("Такой координаты нет");
        }
    }

    @Override
    public double distance(Point point) {
        Point3D point3D = (Point3D) point;
        return Math.sqrt(Math.pow(point3D.x-this.x, 2) + Math.pow(point3D.y-this.y, 2) + Math.pow(point3D.z-this.z, 2));
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), z);
    }

    @Override
    public Point3D clone() {
       Point3D p3D = (Point3D) super.clone();
       p3D.z = this.z;
       return p3D;
    }

    @Override
    public String toString(){
        return "{" + x + ";" + y + ";" + z +"}";
    }
}
