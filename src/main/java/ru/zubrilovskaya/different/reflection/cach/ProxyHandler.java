package ru.zubrilovskaya.different.reflection.cach;

import ru.zubrilovskaya.annotations.Cache;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class ProxyHandler implements InvocationHandler {
    private Object obj;
    private Map<Method, Object> cacheMap = new LinkedHashMap<>();
    private Map<Field, Object> objectState = new LinkedHashMap<>();

    public ProxyHandler(Object obj) {
        this.obj = obj;
    }

    private void checkState(){
        Class<?> clazz = this.obj.getClass();
        if(objectState.containsValue(obj)){
            List<Field> f1List = Arrays.stream(clazz.getDeclaredFields()).distinct().toList();
            List<Field> f2List = objectState.keySet().stream().distinct().toList();
            mapChecker(f1List.equals(f2List));
            return;
        }
        Arrays.stream(clazz.getDeclaredFields())
                .forEach(f -> objectState.put(f, this.obj));
        System.out.println("Добавлен в Map");
    }

    private void mapChecker(boolean eq){
        if(!eq){
            System.out.println("cacheMap clear");
            cacheMap.clear();
            checkState();
        }
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        method = obj.getClass().getMethod(method.getName());
        checkState();

        String[] nameMethods = obj.getClass().getAnnotation(Cache.class).value();
        boolean isContain = false;
        if (nameMethods!=null){
            Method copyMethod = method;
            isContain = Arrays.stream(nameMethods).anyMatch(m->m.equals(copyMethod.getName()));
        }
        if(nameMethods==null || isContain){
            if (!cacheMap.containsKey(method)) {

                Object obj2 = method.invoke(this.obj, args);
                cacheMap.put(method, obj2);
                return obj2;
            }
            return cacheMap.get(method);
        }
        return method.invoke(this.obj, args);
    }
}
