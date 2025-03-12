package ru.zubrilovskaya.different.reflection;

import ru.zubrilovskaya.annotations.Test;
import ru.zubrilovskaya.annotations.Validate;
import ru.zubrilovskaya.human.ValidateException;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;

public class TestExecutor {
    public static void validation(Object... ob){
        for(Object o: ob){
            try{
                validation(o);
            }catch (InvocationTargetException | IllegalAccessException |
                    InstantiationException | NoSuchMethodException e){
                throw new RuntimeException(e);
            }
        }
    }
    private static void validation(Object ob) throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        Class<?> clazz = ob.getClass();

        Class<?>[] validateClasses = getValidate(clazz).value();

        if (validateClasses == null) return;

        for(Class<?> testClass: validateClasses){
            validation(ob, testClass);
        }
    }

    private static Validate getValidate(Class<?> clazz) {
        if (clazz.isAnnotationPresent(Validate.class)) {
            return clazz.getAnnotation(Validate.class);
        }

        for (Annotation a : clazz.getAnnotations()) {
            if (a.annotationType().isAnnotationPresent(Validate.class)) {
                return a.annotationType().getAnnotation(Validate.class);
            }
        }
        return null;
    }

    private static void validation (Object  ob, Class<?> clazz) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        Constructor<?> constructor = clazz.getDeclaredConstructor();
        constructor.setAccessible(true);
        Object testObj = constructor.newInstance();

        List<Method> tests = Arrays.stream(clazz.getDeclaredMethods())
                .filter(m->m.isAnnotationPresent(Test.class))
                .filter(m->m.getParameterCount()==1)
                .filter(m->m.getParameterTypes()[0].isAssignableFrom(ob.getClass()))
                .peek(m-> m.setAccessible(true))
                .toList();

        for(Method m: tests){
            try{
                m.invoke(testObj, ob);
            } catch (InvocationTargetException e) {
                Throwable t1 = e.getCause();
                if(t1 instanceof ValidateException w){
                    throw w;
                }
            }
        }
    }
}
