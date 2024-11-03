# Distributed Auction
 In this exercise, we will create a distributed auction, that will consist of an auction server that receives bids from multiple clients. The clients will communicate with the server via sockets. The server will wait for 20 seconds (using a timer) for a new bid, or else the auction is over and the maximum bid wins. The timer will be reset upon timely submission of new bid.

## Proposed Solution
Let’s start wih the auction server. The server should be able to accommodate multiple clients. For this reason, each client will be served in a separate thread, that will be spawned when the server socket accepts a new connection:

### Listing 17-1: AuctionServer.java
Here we define the Client class as a static class inside the AuctionServer class. Client stores information about the connected client (its ID and the corresponding Socket and BufferedWriter objects).
Next, we have the definition of some constants and the class properties:

### Listing 17-2: AuctionServer.java
Now we present the main() method:

