package chapter_17.v4;

public class RecordDemo3 {
    public static void main(String[] args) {
        Employee[] empList = new Employee[4];

        // Create a list of employee that uses the Employee record.
        empList[0] = new Employee("Doe, John", 1047);
        empList[1] = new Employee("Jones, Robert", 1048);
        empList[2] = new Employee("Smith, Rachel", 1049);

        // Here, the ID number is pending.
        empList[3] = new Employee("Martin, Dave");

        // Display names and IDs.
        for (Employee e : empList) {
            System.out.print("The employee ID for " + e.name() + " is " );
            if (e.idNum() == Employee.pendingID) System.out.println("Pending");
            else System.out.println(e.idNum());
        }
    }
}
