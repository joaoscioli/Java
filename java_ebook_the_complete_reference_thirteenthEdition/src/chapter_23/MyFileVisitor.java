package chapter_23;
// A simple example that uses walkFileTree() to display a directory tree.

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.FileVisitor;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;

// Create a custom version of SimpleFileVisitor that overrides
// the visitFile() method.
public class MyFileVisitor extends SimpleFileVisitor<Path> {
    public FileVisitResult visitResult(Path path, BasicFileAttributes attribs) throws IOException {
        System.out.println(path);
        return FileVisitResult.CONTINUE;
    }
}
