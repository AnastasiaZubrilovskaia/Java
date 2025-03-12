package ru.zubrilovskaya.main;
import ru.zubrilovskaya.different.DataStream;
import ru.zubrilovskaya.different.Function;
import ru.zubrilovskaya.geometry.BrokenLine;
import ru.zubrilovskaya.geometry.Point;
import ru.zubrilovskaya.storage.Storage;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;


public class Main63 {
    public static void main(String[] args){

        List<Point> initList = List.of(new Point(1,2),
                new Point(-3,4),
                new Point(5,6));
        BrokenLine polyline = DataStream.of(initList)
                .filter(p -> p.x>0 && p.y>0)
                .map(p -> new Point(p.x+5, p.y))
                .collect(BrokenLine::new, (poly,p) -> poly.points.add(p));
        System.out.println(polyline);
    }
    public static Storage<Integer> sum(List<Integer> num){
        int res  = 0;
        if (num == null || num.isEmpty()) return Storage.empty();
        for (int i=0; i<num.size(); i++){
            res= res+num.get(i);
        }
        return Storage.of(res);
    }
    public static Storage<String> sum2(List<String> strings){
        String res ="";
        if (strings == null || strings.isEmpty()) return Storage.empty();
        for (int i=0; i<strings.size(); i++){
            res= res+strings.get(i);
        }
        return Storage.of(res);
    }
    public static <T> T reduce(List<T> integers, Function<T> fun, T init){
        if (integers.isEmpty()) return init;
        T res = init;
        for (T x: integers.subList(1, integers.size())){
            res= fun.apply(res,x);
        }
        return res;
    }
}
