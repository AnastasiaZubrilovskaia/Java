package ru.zubrilovskaya.main;

import ru.zubrilovskaya.database.Connection;
import ru.zubrilovskaya.database.DataBase;
import ru.zubrilovskaya.different.temperature.Temperature;
import ru.zubrilovskaya.different.temperature.Temperature2;
import ru.zubrilovskaya.geometry.Point;
import ru.zubrilovskaya.geometry.Point3D;
import ru.zubrilovskaya.geometry.PointGenerator;
import ru.zubrilovskaya.numbers.Fraction;
import ru.zubrilovskaya.numbers.FractionGenerator;
import ru.zubrilovskaya.storage.Storage;
import ru.zubrilovskaya.storage.TmpObject;

public class Main71 {
    public static void main(String[] args){
        //7.1.2-7.1.3
        FractionGenerator fractionGenerator = FractionGenerator.getInstance();
        Fraction f1 = FractionGenerator.toGenerate(12,34);
        System.out.println(f1);
        Fraction f2 = new Fraction(12,34);
        System.out.println(f1.equals(f2));
        //7.1.5
        Temperature t1 = Temperature.getTemperature(12);
        Temperature t2 = Temperature.getTemperature(30);
        Temperature t3 = Temperature.getTemperature(9);
        Temperature t4 = Temperature.getTemperature(16);
        System.out.println(t1 + "; " + t2+ "; " + t3+ "; " + t4);
        Temperature2 t5 = Temperature2.getTemperature(12);
        Temperature2 t6 = Temperature2.getTemperature(30);
        System.out.println(t5 + "; " + t6);
        //7.1.6
        DataBase dataBase = new DataBase(2);
        Connection connection1 = dataBase.getConnections();
        Connection connection2 = new Connection(dataBase);
        Connection connection3 = new Connection(dataBase);
        Connection connection4 = dataBase.getConnections();
        System.out.println(connection4);
        connection2.setData("111");
        System.out.println(connection1.getData(10));
        System.out.println(connection3.getData(2));
        //7.1.7
        Point point1 = PointGenerator.toGenerate(122,1);
        Point point2 = PointGenerator.toGenerate(122,1,4);
        System.out.println(point1);
        System.out.println(point2);
        Point p = point2.clone();
        System.out.println(p);
        //7.1.8
        Storage object = TmpObject.count(12,23);
        System.out.println(object.getOb(333));
    }
}
