package chapter_17;
// Demonstrate indentation in a text block.
public class TextBlockDemo {
    public static void main(String[] args) {
        String str = """
                    Text blocks support strings that
                    span two or more lines and preserve
                        indentation. They reduce the
                            tedium associated with the
                        entry of long or complicated
                    strings int a program.
                    """;
        System.out.println(str);

        String str1 = """
            A
                B
            C
        """;    // this will determine the start of indent

        String str2 = """
              A
                    B
              C  
                """;    // this has no effect

        String str3 = """
             A
                B
             C     
          """;  // this removes whitespace up to the """

        System.out.println(str1);
        System.out.println(str2);
        System.out.println(str3);
    }
}
