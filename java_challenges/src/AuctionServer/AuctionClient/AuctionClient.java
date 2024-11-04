package AuctionServer.AuctionClient;

import javax.imageio.IIOException;
import java.io.*;
import java.net.IDN;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

public class AuctionClient {
    private static final int PORT = 8080;   // Port number to connect to the server
    private static final String SERVER_IP = "127.0.0.1";    // Server IP address

    private static Socket client;
    private static boolean isRunning = true;
    private static Thread receiverThread;

    public static void main(String[] args) {
        // Connect to the server
        try {
            client = new Socket(SERVER_IP, PORT);
            System.out.println("Connected to server.");
        } catch (Exception ex) {
            System.out.println("Connect failed: " + ex.getMessage());
            return;
        }

        // Start receive handle thread
        receiverThread = new Thread(AuctionClient::receiveHandle);
        receiverThread.start();

        // Send bids until the user quits
        try (BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(client.getOutputStream(), StandardCharsets.UTF_8))) {
            String bid;
            while (isRunning) {
                System.out.println("\nEnter your bid (or 'q' for quit): ");
                bid = consoleReader.readLine();

                if("q".equalsIgnoreCase(bid)) {
                    isRunning = false;
                    client.close();
                    receiverThread.interrupt();     // Interrupt the receive thread
                    break;
                }
                try {
                    writer.write(bid);
                    writer.newLine();
                    writer.flush();
                } catch (Exception ex) {
                    System.out.println("Send failed: " + ex.getMessage());
                    return;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Ensure client is closed
        try {
            client.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Handle incoming message from the server
    private static void receiveHandle() {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(client.getInputStream(),StandardCharsets.UTF_8))) {
            while (isRunning) {
                try {
                    if (Thread.interrupted()) {
                        break;  // Exit if the thread is interrupted
                    }
                    String message = reader.readLine();
                    if (message == null || message.isEmpty()) {
                        System.out.println("\nServer disconnected.");
                        break;
                    }
                    System.out.println("\nServver: " + message);
                    if (message.startsWith("Auction")) {
                        System.out.println("Auction ended. Exiting program.");
                        isRunning = false;
                        break;
                    }
                } catch (IOException eX) {
                    if (isRunning) {
                        // Check if still running to avoid printing
                        // error when stopping intentionally
                        System.out.println("Receive failed: " + eX.getMessage());
                    }
                    break;
                }
            }
        } catch (IOException e) {
            if (isRunning) {
                // Check if still running to avoid printing
                // error when stopping intentionally
                e.printStackTrace();
            }
        }
    }
}
