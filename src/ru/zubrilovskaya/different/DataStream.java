package ru.zubrilovskaya.different;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class DataStream <T>{

    private List<T> values;

    private DataStream(List<T> values) {
        this.values = values;
    }

    public static  <T> DataStream<T> of(List<T> values){
        return new DataStream(values);
    }

    public Optional<T> reduce(Function<T> fun){
        if (values.isEmpty()) return Optional.empty();
        T res = values.get(0);
        for (T x: values.subList(1, values.size())){
            res = fun.apply(res, x);
        }
        return Optional.of(res);
    }
    public DataStream<T> filter(FilterRule<T> rule){
        List<T> list = new ArrayList<>();
        for (T x: values){
            if (rule.check(x)){
                list.add(x);
            }
        }
        this.values = list;
        return this;
    }
    @SuppressWarnings("unchecked")
    public <R> DataStream<R> map(Method<T, R> fun){
        List list = new ArrayList<>();
        for(T x: values){
            list.add(fun.apply(x));
        }
        DataStream<R> res = (DataStream<R>) this;
        res.values = list;
        return res;
    }

    public <P> P collect(CreateCollect<P> supplier, CollectFunction<P, T> adder){
        P result = supplier.create();
        for (T x: values){
            adder.accept(result, x);
        }
        return result;
    }
}







