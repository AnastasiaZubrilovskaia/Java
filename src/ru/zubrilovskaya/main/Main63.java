package ru.zubrilovskaya.main;
import ru.zubrilovskaya.different.DataStream;
import ru.zubrilovskaya.different.Function;
import ru.zubrilovskaya.storage.Storage;

import java.util.ArrayList;
import java.util.List;


public class Main63 {
    public static void main(String[] args){
        System.out.println(sum(List.of()).getOb(-1));
        int x = DataStream.sum(List.of(1,2,3), (res, y)->res+y).orElse(-1);
        int max = DataStream.sum(List.of(1,2,3), Math::max).orElse(-1);
        System.out.println(x);
        System.out.println(max);

        List<Integer> list1 = new ArrayList<>(List.of(1,2,3,4, -6));
        List<Integer> list2 = DataStream.filter(list1, a->a>0);
        System.out.println(list2);

        List<String> list3 = new ArrayList<>(List.of("aaa", "hhh", "abb"));
        List<String> list4 = DataStream.filter(list3, a-> a.startsWith("a"));
        System.out.println(list4);

        List<Integer> list5 = DataStream.map(list3, a->a.length());
        System.out.println(list5);

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
