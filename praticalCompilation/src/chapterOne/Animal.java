package chapterOne;

/* Animal class
*  fields Name
* */

/**
 * @author JoaoScioli
 * @version 1.0
 */

public class Animal {
    String name;
    public String getName() {
        return name;
    }
    public void setName(String newName) {
        this.name = newName;
    }
    // void method
    public static void main(String... args) {
        Animal animal = new Animal();
        animal.name = "Rebeca";
        System.out.println(animal.getName());
    }
}
