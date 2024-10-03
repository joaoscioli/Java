package chapter_24.v2;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class Whois {
    // Use try-with-resources to close a socket.
    public static void main(String[] args) throws Exception {
        int c;

        // Create a socket connected to internic.net, port 43. Manage this
        // socket with a try-with-resources block.
        try (Socket s = new Socket("whois.internic.net", 43)) {
            // Obtain input and output streams.
            InputStream in = s.getInputStream();
            OutputStream out = s.getOutputStream();

            // Construct a request string.
            String str = (args.length == 0 ? "MHProfessional.com" : args[0]) + "\n";
            // Convert to bytes.
            byte[] buf = str.getBytes();

            // Send request.
            out.write(buf);

            // Read and display response.
            while ((c = in.read()) != -1) {
                System.out.println((char) c);
            }
        }
        // The socket is now closed.
    }
}
