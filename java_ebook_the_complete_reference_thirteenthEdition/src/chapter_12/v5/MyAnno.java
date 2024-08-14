package chapter_12.v5;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

// Show all annotations for a class and a method.

@Retention(RetentionPolicy.RUNTIME)
@interface MyAnno {
    String str();
    int val();
}

