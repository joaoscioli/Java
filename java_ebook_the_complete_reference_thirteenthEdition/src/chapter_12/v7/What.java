package chapter_12.v7;
// An annotation that can be applied to a type parameter.

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

@Target(ElementType.TYPE_PARAMETER)
@interface What {
    String description();
}
