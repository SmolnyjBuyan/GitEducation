package ru.smolny.homework_08;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface RecoverException {
    Class<? extends RuntimeException>[] noRecoverFor() default {};
}
