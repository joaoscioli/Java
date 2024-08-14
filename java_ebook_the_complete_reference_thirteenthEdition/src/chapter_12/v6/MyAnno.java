package chapter_12.v6;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
// An annotation type declaration that includes defaults.

@Retention(RetentionPolicy.RUNTIME)
@interface MyAnno {
    String str() default "Testing";
    int val() default 9000;
}
