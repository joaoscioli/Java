package chapter_12.v7;
// An annotation that can be applied to a field declaration.

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

@Target(ElementType.FIELD)
@interface EmptyOK {

}
