package chapter_12.v7;
// Demonstrate several type annotations.

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;
// A maker annotation thar can be applied to a type.

@Target(ElementType.TYPE_USE)
@interface TypeAnno {}

