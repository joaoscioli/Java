package AuctionServer;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.Timer;
import java.util.TimerTask;

public class AuctionServer {
    // Client class representing each client connected to the server
    static class Client {
        private final Socket socket;
        private final BufferedWriter writer;
        private final int id;

        // Constructor for the Client class
        public Client(Socket socket, int id)throws IOException {
            this.socket = socket;
            // Setting up writer to send data to the client
            this.writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream(), StandardCharsets.UTF_8));
            this.id = id;
        }

        public Socket getSocket() {
            return socket;
        }

        public BufferedWriter getWriter() {
            return writer;
        }

        public int getId() {
            return id;
        }
    }

    // Constants
    private static final int PORT = 8080;   // Port number for the server

    private static final int MAX_CLIENTS = 5;   // Maximum number of clients

    // Server and clients
    private static ServerSocket server;

    private static Client[] clients = new Client[MAX_CLIENTS];  // Array to hold clients

    // Auction details
    private static int bestBid = 0;     // Highest bid received

    private static int winningClient;   // Client ID of the highest bidder

    // Timer for auction end
    private static Timer timer;

    public static void main(String[] args) {
        try {
            server = new ServerSocket(PORT);    // Setting up the server socket
            System.out.println("Server listening on port " + PORT);
            // Start the timer
            timer = new Timer();
            timer.schedule(new TimerTask() {
                @Override
                public void run() {
                    timerCompletionRoutine();
                }
            }, 20000, 20000);   // Schedule the timer to trigger every 20 seconds
            while (true) {
                // Accept a new client connection
                Socket clientSocket = server.accept();
                System.out.println("Client connected: " + clientSocket.getRemoteSocketAddress());

                // Find an available slot for the client
                int clientId = -1;
                for (int i = 0; i < MAX_CLIENTS; i++) {
                    if (clients[i] == null) {
                        clientId = i;
                        clients[i] = new Client(clientSocket, clientId + 1);
                        System.out.println("Client no." + clientId + 1 + " connected.");
                        break;
                    }
                }
                // Handle client in a separate thread
            }
        }
    }
}
