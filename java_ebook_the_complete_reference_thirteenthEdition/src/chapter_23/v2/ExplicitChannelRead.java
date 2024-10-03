package chapter_23.v2;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.SeekableByteChannel;
import java.nio.file.Files;
import java.nio.file.InvalidPathException;
import java.nio.file.Path;

// A more compact way to open a channel.
public class ExplicitChannelRead {
    public static void main(String[] args) {
        int count;

        // Here, the channel is opened on the Path returned by Path.of().
        // There is no need for the filepath variable.
        try (SeekableByteChannel fChan = Files.newByteChannel(Path.of("test.txt"))) {
            // Allocate a buffer.
            ByteBuffer mBuf = ByteBuffer.allocate(128);

            do {
                // Read a buffer.
                count = fChan.read(mBuf);

                // Stop when end of file is reached.
                if (count != -1) {
                    // Rewind the buffer so that it can be read.
                    mBuf.rewind();

                    // Read bytes from the buffer and show
                    // them on the screen as characters.
                    for (int i=0; i<count; i++)
                        System.out.print((char) mBuf.get());
                }
            } while (count !=-1);
            System.out.println();
        } catch (InvalidPathException e) {
            System.out.println("Path Error " + e);
        } catch (IOException e) {
            System.out.println("I/O Error " + e);
        }
    }
}
