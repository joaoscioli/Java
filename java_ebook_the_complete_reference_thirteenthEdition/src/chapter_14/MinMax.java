package chapter_14;
// A generic interface example.

// A Min/Max interface.
public interface MinMax <T extends Comparable<T>> {
    T min();
    T max();
}
