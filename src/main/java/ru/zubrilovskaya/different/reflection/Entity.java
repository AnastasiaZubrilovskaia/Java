package ru.zubrilovskaya.different.reflection;

import ru.zubrilovskaya.annotations.ToString;
import ru.zubrilovskaya.annotations.Variant;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public abstract class Entity {
    private static List<Field> getAllFields(Class<?> clazz) {
        List<Field> fields = new ArrayList<>(Arrays.asList(clazz.getDeclaredFields()));
        while (clazz.getSuperclass() != null) {
            clazz = clazz.getSuperclass();
            fields.addAll(Arrays.asList(clazz.getDeclaredFields()));
        }
        return fields;
    }

    private boolean check(Field field){
        if(getClass().isAnnotationPresent(ToString.class) &&
                getClass().getAnnotation(ToString.class).value()== Variant.NO){
            return field.isAnnotationPresent(ToString.class) &&
                    field.getAnnotation(ToString.class).value()==Variant.YES;
        }
        return !field.isAnnotationPresent(ToString.class) || field.getAnnotation(ToString.class).value()==Variant.YES;
    }

    private String getFieldValue(Field field) {
        try {
            field.setAccessible(true);
            return field.getName() + "=" + field.get(this) + " ";
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }
    @Override
    public String toString() {
        return getClass().getSimpleName() + "{ "
                + getAllFields(getClass()).stream()
                .filter(this::check)
                .map(this::getFieldValue)
                .collect(Collectors.joining())
                + "}";
    }
}
