package chapter_17.v4;
// Use a non-canonical constructor in a record.
// Declare an employee record that explicitly declares both
// a canonical and non-canonical constructor.
public record Employee(String name, int idNum) {
    // Use a static field in a record.
    static int pendingID = -1;

    // Use a compact canonical constructor to remove any leading and
    // trailing spaces from the name string.
    public Employee {
        // Remove any leading and trailing spaces.
        name = name.trim();
    }

    // This is a non-canonical constructor. Notice that it is
    // not passed and ID number. Instead, it passes pendingID to the
    // canonical constructor to create the record.
    public Employee(String name) {
        this(name, pendingID);
    }
}
