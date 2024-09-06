package chapter_17;
// A simple Record example.
// Declare an employee record. This automatically creates a
// record class with private, final fields called name and idNum,
// and with read-only accessors called name() and idNum().
public record Employee(String name, int idNum) {
}
