package ru.zubrilovskaya.postprocesses;

import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

import java.lang.reflect.Field;

@Component
public class NameControl implements BeanPostProcessor {
    public Object postProcessBeforeInitialization(Object bean, String name){
        try {
            Field field = bean.getClass().getDeclaredField("name");
            field.setAccessible(true);
            if(field.getType() == String.class && field.get(bean)==null){
                field.set(bean, "vasia");
            }

        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (NoSuchFieldException e) {

        }
        return bean;
    }

    public Object postProcessAfterInitialization(Object bean, String name){
        return bean;
    }
}


