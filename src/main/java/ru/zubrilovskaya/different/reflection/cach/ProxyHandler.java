package ru.zubrilovskaya.different.reflection.cach;

import ru.zubrilovskaya.annotations.Cache;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.*;

public class ProxyHandler implements InvocationHandler {
    private Object obj;
    private Map<Key, Object> cacheMap = new HashMap<>();
    private Map<Field, Object> objectState = new HashMap<>();
    private Set<String> methodNames = new HashSet<>();

    public ProxyHandler(Object obj) {
        this.obj = obj;
        String[] nameMethods = obj.getClass().getAnnotation(Cache.class).value();
        methodNames.addAll(List.of(nameMethods));
    }

    private void checkState(){
        Class<?> clazz = this.obj.getClass();
            List<Object> f1List = Arrays.stream(clazz.getDeclaredFields())
                    .peek(f->f.setAccessible(true))
                    .map(f->{
                        try{
                            return f.get(obj);
                        }catch (IllegalAccessException e){
                            throw new RuntimeException(e);
                        }
                    })
                    .toList();
            List<Object> f2List = objectState.values().stream().toList();

        if (!f2List.equals(f1List)) {
            cacheMap.clear();
            objectState.clear();
            Arrays.stream(clazz.getDeclaredFields())
                    .forEach(f -> objectState.put(f, this.obj));
        }
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        checkState();
        if (!(methodNames.isEmpty() || methodNames.contains(method.getName()))) {
            return method.invoke(this.obj, args);
        }
        Key key = new Key(method.getName(), args);
        if (cacheMap.containsKey(key)){
            return cacheMap.get(key);
        }
        Object obj2 = method.invoke(this.obj, args);
        cacheMap.put(key, obj2);
        return obj2;
    }
}

record Key(String methodName, Object[] args) {
}

