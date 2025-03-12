package ru.zubrilovskaya.different.reflection;

import ru.zubrilovskaya.annotations.Default;

import java.lang.reflect.Field;
import java.util.*;

public class ResetClass {
    static DefaultValues defaultValues = new DefaultValues.BuilderDefault()
            .setInt(42)
            .setString("hello")
            .build();

    public static void reset(Object... objects){
        for (Object ob: objects){
            reset(ob);
        }
    }

    private static void reset(Object ob) {
        List<Field> fields = getAllFields(ob.getClass());
        try{
            if (ob.getClass().isAnnotationPresent(Default.class)){
                for(Field f: fields){
                    f.setAccessible(true);
                    f.set(ob, defaultValues.getDefaultValue(f.getType()));
                }
            }else{
                for(Field f: fields){
                    if(f.isAnnotationPresent(Default.class)){
                        f.setAccessible(true);
                        f.set(ob, defaultValues.getDefaultValue(f.getType()));
                    }
                }
            }
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }

    private static List<Field> getAllFields(Class<?> clazz){
        List<Field> fields = new ArrayList<>(Arrays.asList(clazz.getDeclaredFields()));
        while (clazz.getSuperclass()!=null){
            clazz = clazz.getSuperclass();
            fields.addAll(Arrays.asList(clazz.getDeclaredFields()));
        }
        return fields;
    }
}
