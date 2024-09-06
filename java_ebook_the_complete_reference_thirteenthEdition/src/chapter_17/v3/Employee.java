package chapter_17.v3;
// Use a compact record constructor.
// Declare an employee record.
public record Employee(String name, int idNum) {
    // Use a compact canonical constructor to remove any leading and
    // trailing spaces from the name string.
    public Employee {
        // Remove any leading and trailing spaces.
        name = name.trim();
    }
}
