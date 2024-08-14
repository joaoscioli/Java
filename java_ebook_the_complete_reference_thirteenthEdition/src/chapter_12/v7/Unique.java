package chapter_12.v7;
// Still another marker annotation that can be applied to a type.

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

@Target(ElementType.TYPE_USE)
@interface Unique {
}
