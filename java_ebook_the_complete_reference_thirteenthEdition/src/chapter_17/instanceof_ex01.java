package chapter_17;

public class instanceof_ex01 {
    public static void main(String[] args) {
        Number myOb = Integer.valueOf(9);

        // Use the pattern matching version of instanceof.
        if(myOb instanceof Integer iObj) {
            // iObj is known and in scope here.
            System.out.println("iObj refers to an integer: " + iObj);
        }
    }
    // iObj does not exist here
}
