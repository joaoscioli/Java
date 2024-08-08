# Social Network
A social network is essentially a graph of nodes that depicts the users of the network along with their connections to their friends. In this exercise, we will create such a graph and we will implement the functionality to recommend new friends according to a user’s current connections.

## Proposed Solution
There are various ways to implement the users’ graph, for example using sparse two-dimensional matrices. Here we will construct the graph with the use of a one-dimensional array of users, where the connections are stored in a linked list:

### Listing 13-1: SocialNetwork.java
The User class contains the name of the user as well as a linked list of the user’s friends.
Next, we define a queue class that will be used by the friend recommendation algorithm. For learning purposes, we will make our own queue instead of using the one from java.util package:

### Listing 13-2: SocialNetwork.java
The queue contains the indexes of the users, as they will appear inside the users’ array (see below in the Graph class). We define the class for the queue nodes, and methods to enqueue and dequeue user indexes inside the queue, as well as to check whether it is empty or not.
Now, let’s see how we will insert users into the graph and how we will define the connections with their friends. We define the Graph class, that essentially contains an array of all the users of the social network:

### Listing 13-3: SocialNetwork.java
Next, we provide the functionality to add a new user to the graph:

### Listing 13-4: SocialNetwork.java
We use the following method to add a new connection to a user:

### Listing 13-5: SocialNetwork.java
Note that when we add a new connection, we make it bidirectional. That is, we insert a friend node for each one of the connection’s ends.
Next, we proceed to the more interesting stuff, the recommender method:

### Listing 13-6: SocialNetwork.java
The recommendFriends() method uses breadth-first search (BFS) to traverse the social network graph, starting from the specified user and visiting all connected users to recommend friends. It marks users as visited (using the visited[] array) to avoid recommending the same friend multiple times and enqueues each friend to ensure all potential friends are discovered and recommended.
The BFS algorithm makes use of a queue, where we store the indexes of the user’s friends as we follow the linked list. We then use the queue to get the friends of the user’s friends, and in this way, we are able to travel through the connections of the graph and find all the connected people to the specific user.
Finally, here is the main() method: