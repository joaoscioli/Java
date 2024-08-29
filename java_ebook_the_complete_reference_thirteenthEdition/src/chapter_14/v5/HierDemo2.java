package chapter_14.v5;
// Create a Gen object.
public class HierDemo2 {
    public static void main(String[] args) {
        // Create a Gen object for String.
        Gen<String> w = new Gen<String>("Hello", 47);

        System.out.print(w.getOb() + " ");
        System.out.println(w.getnum());
    }
}
