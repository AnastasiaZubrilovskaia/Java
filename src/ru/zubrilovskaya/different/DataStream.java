package ru.zubrilovskaya.different;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

public class DataStream {

    public static <T> Optional<T> sum(List<T> lst, Function<T> fun){
        if(lst.isEmpty()) return Optional.empty();
        T res = lst.get(0);
        for (T x: lst.subList(1, lst.size())) {
            res = fun.apply(res, x);

        }
        return Optional.of(res);
    }

    public static <T> List<T> filter (List<T> values, FilterRule<T> rule){
        List<T> list = new ArrayList<>();
        for(T x: values){
            if(rule.check(x)) list.add(x);
        }
        return list;
    }

    public static <T,R> List<R> map(List<T> values, Method<T,R> fun){
        List<R> list = new ArrayList<>();
        for(T x: values){
             list.add(fun.apply(x));
        }
        return list;
    }

    public static  <C extends Collection<T>, T>  C collect(List<T> values, CreateCollect<T,C> createFunction, CollectFunction<T> fun){
        C result = createFunction.create();
        for(T x: values){
            result.add(fun.apply(x));
        }
        return result;
    }

}






