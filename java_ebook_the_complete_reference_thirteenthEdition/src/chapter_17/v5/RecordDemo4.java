package chapter_17.v5;

public class RecordDemo4 {
    public static void main(String[] args) {
        Employee emp = new Employee("Jones, Robert", 1048);

        // Display the name component unmodified.
        System.out.println("Employee full name is " + emp.name());

        // Display only last name.
        System.out.println("Employee last name is " + emp.lastName());
    }
}
