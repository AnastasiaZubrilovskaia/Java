package ru.zubrilovskaya.annotations;

import ru.zubrilovskaya.human.TestHuman;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Validate({TestHuman.class})
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface AValidate {
}
