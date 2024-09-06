package chapter_17.v5;
// Use an instance method in a record
// This version of Employee provides a method called lastName()
// that returns only the last name of the name component.
// It also includes the version of the compact constructor that
// checks for the conventional lastname, firstname format.
public record Employee(String name, int idNum) {
    // Use a compact canonical constructor to remove any leading
    // and trailing spaces in the name component. Also perform
    // a basic check that the required format of lastname, firstname.
    // is passed to the name parameter.
    public Employee {
        // Remove any leading and trailing spaces.
        name = name.trim();

        // Perform a minimalist check that name follows the
        // lastname, firstname format.
        //
        // First, confirm that name contains only one comma.
        int i = name.indexOf(',');  // look for comma separating names.
        int j = name.lastIndexOf(',');
        if (i != j) throw new IllegalArgumentException("Multiple commas found.");

        // Next, confirm that a comma is present after
        // at least one leading character, and that at least one
        // character follows the comma.
        if (i < 1 | name.length() == i+1) throw new IllegalArgumentException("Required format: last, first");
    }

    // An instance method that returns only the last name
    // without the first name.
    String lastName() {
        return name.substring(0, name.trim().indexOf(','));
    }
}