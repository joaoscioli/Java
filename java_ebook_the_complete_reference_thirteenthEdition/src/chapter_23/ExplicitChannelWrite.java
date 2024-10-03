package chapter_23;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Files;
import java.nio.file.InvalidPathException;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;

// Write to a file using NIO.
public class ExplicitChannelWrite {
    public static void main(String[] args) {
        // Obtain a channel to a file within a try-with-resources block.
        try (FileChannel fChan = (FileChannel) Files.newByteChannel(Path.of("test.txt"),
                                                                                StandardOpenOption.WRITE,
                                                                                StandardOpenOption.CREATE)) {
            // Create a buffer.
            ByteBuffer mBuf = ByteBuffer.allocate(26);

            // Write some bytes to the buffer.
            for (int i=0; i<26; i++)
                mBuf.put((byte) ('A' + i));

            // Reset the buffer so that it can be written.
            mBuf.rewind();

            // Write the buffer to the output file.
            fChan.write(mBuf);
        } catch (InvalidPathException e) {
            System.out.println("Path Error " + e);
        } catch (IOException e) {
            System.out.println("I/O Error: " + e);
            System.exit(1);
        }
    }
}
