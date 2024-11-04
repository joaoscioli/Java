# Distributed Auction
 In this exercise, we will create a distributed auction, that will consist of an auction server that receives bids from multiple clients. The clients will communicate with the server via sockets. The server will wait for 20 seconds (using a timer) for a new bid, or else the auction is over and the maximum bid wins. The timer will be reset upon timely submission of new bid.

## Proposed Solution
Let’s start wih the auction server. The server should be able to accommodate multiple clients. For this reason, each client will be served in a separate thread, that will be spawned when the server socket accepts a new connection:

### Listing 17-1: AuctionServer.java
Here we define the Client class as a static class inside the AuctionServer class. Client stores information about the connected client (its ID and the corresponding Socket and BufferedWriter objects).
Next, we have the definition of some constants and the class properties:

### Listing 17-2: AuctionServer.java
Now we present the main() method:

### Listing 17-3: AuctionServer.java
We open a new ServerSocket, and we listen for new connections.
We also start a timer with 20 seconds duration. When the timer expires, then the timerCompletionRoutine() method will be called, ending the auction process.
When a new connection arrives, we store the client details in the clients’ array, and we spawn a new thread. The thread will run the handleClient() method, that will handle the communication with the specific client.
Now, let’s see the handleClient() method:

### Listing 17-4: AuctionServer.java
This method takes care of the communication with the client. It gets as input the client’s ID, that was passed in main():
new Thread(() -> handleClient(finalClientId)).start();
Then, in an endless while loop, it blocks in the reader.readLine() method, waiting for input from the client. When a message arrives, the method is unblocked and continues to check the input. If the bid is null, then the client has disconnected.
If the client has actually sent a valid bid, we compare it with the current maximum bid, and we update this value if we got a higher bid. We also proceed with informing all clients about the submitted bid. We also reset the timer to get a new 20 seconds’ period.
Here, bestBid and winningClient are shared resources that might be accessed and modified by multiple client handler threads. To protect these shared resources, we synchronize the critical sections where these variables are read or written.
Next, we define the broadcastMessage() method, that sends messages to the clients:

### Listing 17-5: AuctionServer.java
When the timer eventually expires, the timerCompletionRoutine() method will be called:

### Listing 17-6: AuctionServer.java
After informing all clients about the winning bid, we exit the program. The client sockets will be closed by the respective clients when they receive the message of the auction completion.
Now for the auction client, we first implement the main() method:

### Listing 17-7: AuctionClient.java
Here, we create a Socket object, and we connect to the server. If the connection is successful, we spawn a new thread that will be used to receive and print the information from the server.
The sending part of the communication, i.e. the submission of bids to the server, will be performed by the main thread. If we had the same thread handle sending and receiving of data, we would have a problem, as the readLine() method would block and would not let the user send a new bid.
Here is the callback method for the thread handler:

### Listing 17-6: AuctionClient.java
This thread receives messages from the auction server and prints them in the console. When the final message, starting with “Auction” arrives, then it closes down the resources and exits the program.
You can find this project in GitHub:
https://github.com/htset/java_exercises_dsa/tree/master/AuctionServer
https://github.com/htset/java_exercises_dsa/tree/master/AuctionClient

[1] http://www.cse.yorku.ca/~oz/hash.html
[2] https://en.wikipedia.org/wiki/Locality-sensitive_hashing