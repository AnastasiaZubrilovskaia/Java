package ru.zubrilovskaya.different.reflection.cach;

import java.lang.reflect.Proxy;

public class CacheProxyCreator {
    public CacheProxyCreator() {
    }
    @SuppressWarnings("unchecked")
    public static <T> T create(T o){
        if(o == null) return o;
        return (T) Proxy
                .newProxyInstance(
                        o.getClass().getClassLoader(),
                        o.getClass().getInterfaces(),
                        new ProxyHandler(o)
                );
    }
}
