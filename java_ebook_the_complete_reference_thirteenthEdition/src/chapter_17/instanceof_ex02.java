package chapter_17;

public class instanceof_ex02 {
    public static void main(String[] args) {
        Number myOb = Integer.valueOf(9);
        // Use a traditional instanceof.
        if (myOb instanceof Integer) {
            // Use an explicit cast to obtain iObj.
            Integer iObj = (Integer) myOb;
            System.out.println("iObj refers to an integer: " + iObj);
        }
    }
}
