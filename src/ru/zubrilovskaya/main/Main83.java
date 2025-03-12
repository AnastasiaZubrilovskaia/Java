package ru.zubrilovskaya.main;

import ru.zubrilovskaya.annotations.Default;
import ru.zubrilovskaya.annotations.Invoke;
import ru.zubrilovskaya.annotations.ToString;
import ru.zubrilovskaya.annotations.Variant;
import ru.zubrilovskaya.different.reflection.Entity;
import ru.zubrilovskaya.different.reflection.ResetClass;
import ru.zubrilovskaya.different.reflection.TestExecutor;
import ru.zubrilovskaya.different.reflection.cach.CacheProxyCreator;
import ru.zubrilovskaya.different.reflection.cach.ProxyHandler;
import ru.zubrilovskaya.different.reflection.cach.Testable;
import ru.zubrilovskaya.human.Human;
import ru.zubrilovskaya.human.Name;

import java.lang.reflect.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main83 {
    public static void main(String[] args){
        //8.3.1
        System.out.println(collect(TestA.class, TestB.class));
        //8.3.2
        TestA a = new TestA();
        ResetClass.reset(a);
        System.out.println(a);
        //8.3.3
        TestB b = new TestB();
        System.out.println(b);
        //8.3.5
        Human human = new Human(new Name("Ivanov", "Ivan", "Ivanich"), 190);
        TestExecutor.validation(human);
        //8.3.6
        C c = new C("string");
        Testable proxyC = CacheProxyCreator.create(c);
        System.out.println(proxyC.cacheTest());
        c.str = "change";
        System.out.println(proxyC.cacheTest());
        System.out.println(proxyC.cacheTest());

    }

    public static Map<String, List<Object>> collect(Class<?>... objects) {
        Map<String, List<Object>> map = new HashMap<>();
        for(Class<?> clazz: objects){
            Method[] methods = clazz.getDeclaredMethods();
            for (Method m: methods) {
                m.setAccessible(true);
                if (m.isAnnotationPresent(Invoke.class) && m.getParameterCount() == 0 && m.getReturnType() != void.class) {
                    try {
                        Object object;
                        if (Modifier.isStatic(m.getModifiers())) {
                            object = m.invoke(null);
                        } else {
                            Constructor<?> constructor = clazz.getDeclaredConstructor();
                            constructor.setAccessible(true);
                            Object newObj = constructor.newInstance();
                            object = m.invoke(newObj);
                        }
                        map.computeIfAbsent(m.getName(), ob ->new ArrayList<>()).add(object);

                    } catch (NoSuchMethodException | InvocationTargetException
                             | InstantiationException | IllegalAccessException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        }
        return map;
    }

}


@Default
class TestA {
    int x =100, y = 200;
    String st = "gggg";

    @Invoke
    public int getX() {
        return x;
    }
    @Invoke
    public void newY() {
        y*=300;
    }
    public  int getNewX(){
        return x*100;
    }
    @Invoke
    public  int getNewY(){
        return y*200;
    }
    @Invoke
    public static int numb(){
        return 5555;
    }
    @Invoke
    private String text(){
        return  "text";
    }

    @Override
    public String toString() {
        return x+" "+y + " "+ st;
    }
}


class TestB extends Entity {
    int x =1000,y = 30;
    String str1 = "note1";
    @ToString(value = Variant.NO)
    String str2 = "note2";

    @Invoke
    public int getX() {
        return x;
    }
    @Invoke
    public int newY() {
        return y*=300;
    }
    public  int getNewX(){
        return x*100;
    }
    @Invoke
    public  int getNewY(){
        return y*200;
    }
    @Invoke
    public static int numb(){
        return 5555;
    }
    @Invoke
    private String text(){
        return  "no";
    }
}

class C implements Testable {
    String str;

    public C(String str) {
        this.str = str;
    }
    public int cacheTest(){
        System.out.println("hhh");
        return 23;
    }
}