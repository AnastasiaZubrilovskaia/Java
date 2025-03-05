package ru.zubrilovskaya.different.reflection;

import ru.zubrilovskaya.annotations.Default;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.LinkedHashMap;
import java.util.Map;

@Default(String.class)
public class StorageClass<T> {
    Map<Method,Object> map = new LinkedHashMap<>();
    Object object;

    public StorageClass(T ob) {
        object = ob;
    }

    public Object check(String methodName){
        Class<?> clazz = object.getClass();
        try {
            Method method = clazz.getMethod(methodName);
            if (method.getParameterCount() == 0) {
                if (map.containsKey(method)) {
                    Class<?> save = map.get(method).getClass();
                    Field[] saveFields = save.getDeclaredFields();
                    Field[] fields = clazz.getDeclaredFields();
                    for (int i = 0; i < saveFields.length; i++) {
                        Field f1 = saveFields[i];
                        f1.setAccessible(true);
                        Field f2 = fields[i];
                        f2.setAccessible(true);
                        if (!f1.equals(f2)) {
                            map.remove(method);
                            map.put(method, object);
                            return map.get(method);
                        } else {
                            Object temp = map.get(method);
                            return temp;
                        }
                    }
                } else {
                    map.put(method, object);
                    return map.get(method);
                }

            }
        } catch (NoSuchMethodException e) {
            throw new RuntimeException();
        }
        return null;
    }

}
