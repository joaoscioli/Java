package chapter_17;
// Use double quotes in a text block.
public class TextBlockDemo2 {
    public static void main(String[] args) {
        String str = """
                     A text block can use double quotes without
                     the need for scape sequences. For example:
                     
                     He said, "The cat is on the roof."
                     She asked, "How did it get up there?"
                     """;
        System.out.println(str);
    }
}
