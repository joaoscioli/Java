package chapter_15.v5;
// Use an instance method reference with different objects.
// A functional interface that takes two reference arguments
// and returns a boolean result.
public interface MyFunc<T> {
    boolean fun(T v1, T v2);
}
