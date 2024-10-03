package chapter_24;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

// Demonstrate URL.
public class URLDemo {
    public static void main(String[] args) throws URISyntaxException, MalformedURLException {
        URL hp = new URI("https://en.wikipedia.org:443/wiki/Java").toURL();

        System.out.println("Protocol: " + hp.getProtocol());
        System.out.println("Port: " + hp.getPort());
        System.out.println("Host: " + hp.getHost());
        System.out.println("File: " + hp.getFile());
        System.out.println("Ext: " + hp.toExternalForm());

    }
}
