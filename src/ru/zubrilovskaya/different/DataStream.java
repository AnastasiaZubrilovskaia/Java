package ru.zubrilovskaya.different;

import java.util.*;

public class DataStream <T>{

    private List<T> values;
    private List<DeferredCalculations<T,T>> deferred;

    private DataStream(List<T> values) {
        this.values = values;
        this.deferred = new ArrayList<>();
    }

    public static  <T> DataStream<T> of(List<T> values){
        return new DataStream(values);
    }

    public Optional<T> reduce(Function<T> fun){
        if (values.isEmpty()) return Optional.empty();
        T res = values.get(0);
        up:
        for (T x : values.subList(1, values.size())) {
            for (DeferredCalculations<T, T> deferred : deferred) {
                if (deferred.apply(x) != null) {
                    x = deferred.apply(x);
                } else continue up;
            }

            res = fun.apply(res, x);
        }
        return Optional.of(res);
    }

    public DataStream<T> filter(FilterRule<T> rule){
        deferred.add(new DeferredCalculations<T, T>() {
            boolean res;
            @Override
            public T apply(T fun) {
                res = rule.check(fun);
                return fun;
            }

            @Override
            public boolean isEnd() {
                return !res;
            }
        });
        return this;
    }

    @SuppressWarnings("unchecked")
    public <R> DataStream<R> map(Method<T, R> fun){
        deferred.add(new DeferredCalculations<T, T>() {
            @Override
            public T apply(T f) {
                return (T) fun.apply(f);
            }

            @Override
            public boolean isEnd() {
                return false;
            }
        }) ;
        return (DataStream<R>)this;
    }

    public <P> P collect(CreateCollect<P> supplier, CollectFunction<P, T> adder) {
        P result = supplier.create();
        up: for (T x : values) {
            for(DeferredCalculations<T,T> deferred : deferred){
                if(deferred.apply(x)!=null){
                    adder.accept(result, deferred.apply(x));
                }
                else continue up;
            }
        }
        return result;
    }
}



//filter
//        List<T> list = new ArrayList<>();
//        for (T x: values){
//            if (rule.check(x)){
//                list.add(x);
//            }
//        }
//        this.values = list;
//        return this;

//map
//        List list = new ArrayList<>();
//        for(T x: values){
//            list.add(fun.apply(x));
//        }
//        DataStream<R> res = (DataStream<R>) this;
//        res.values = list;
//        return res;

//collect
//        P result = supplier.create();
//        for (T x : values) {
//            adder.accept(result, x);
//        }
//        return result;

