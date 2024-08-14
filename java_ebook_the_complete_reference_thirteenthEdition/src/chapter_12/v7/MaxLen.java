package chapter_12.v7;
// A parameterized annotation that can be applied to a type.

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

@Target(ElementType.TYPE_USE)
@interface MaxLen {
    int value();
}
