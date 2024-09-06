package chapter_17.v2;
// Notice that MyIF is added to the permits clause.
public sealed interface MySealedIF permits Alpha, Beta, MyIF {
    void myMeth();
}
