# HTTP Server with Caching
In this exercise, we will create a simple HTTP server that will serve static content (only HTML files). The web server will make use of a cache mechanism that will keep the most recently served content, in order to boost the server’s performance.

## Proposed Solution
The web server cache is a structure that stores the content that was previously sent to the client browser. The cache has limited space, so when it is filled up, we will need to empty the least recently used (LRU) entry in order to make space for the new entry. Moreover, when an entry is used by the server to send content to the client, then this entry is moved to the head of the list, as it is the more recently used entry.
Let’s see the cache definition:

### Listing 16-1: LRUCache.java
The cache is implemented as a doubly linked list. In this kind of linked list, we can move to both directions, forward and backward. The doubly linked list is beneficial in our case as we can efficiently remove and insert nodes anywhere in the list without needing to traverse the list from the beginning. The same effect could be achieved with simple linked lists, or even arrays, but with lower performance.
Let’s skip the rest of the cache definition for now, and jump to the main() method of our program:

### Listing 16-2: WebServerCache.java
Here, we create an object of the HttpServer class, that will handle the connections with the clients. Let’s see how it is implemented:

### Listing 16-3: WebServerCache.java
Here we create a ServerSocket object that continuously accepts HTTP connections from web browsers at port 8080. When a connection is accepted, then the handleRequest() method is called.
Initially, the web request stream is received into the buffer byte array. Then we create a string object that will contain the request. The string is split in order to retrieve the request type and the URL; only GET requests are handled by our server.
We then use the request URL to search in the cache for a previously stored response for this URL. If such an entry is not found in the cache, then we open the requested HTML file (The HTML files are stored in the same folder as our executable), and we transmit its HTML content in the response. Note that, before sending the content, we must send the header of the response:
HTTP/1.1 200 OK\nContent-Type: text/html
If the URL is found in the cache, then we get the content from there and we send it with the response.
Let’s see how we do this, in method getContent() from the LRUCache class:

### Listing 16-4: LRUCache.java
We start from the head of the list, and we search for the URL in the cache’s nodes. If we find the URL, then we move the node to the head of the cache (the most recently used entry) and we return the stored HTML content. The method returns an empty string if the URL is not found in the cache.
When a page is read from its file, then we store its content into the cache, with putContent():

### Listing 16-5: LRUCache.java
If we have reached the maximum cache size, then the LRU algorithm kicks in: we delete the least recently used entry (the node at the tail of the list) and we make space for the insertion of the new entry (at the head of the list).
Now we can examine the methods that handle the cache operations. First, let’s see how we can create a new node:

### Listing 16-6: LRUCache.java
Next, we see how to insert a new node at the head of the cache:

### Listing 16-7: LRUCache.java
Note that in all operations we have to take care of all four references: head, tail, next, prev.
As part of the LRU algorithm, we have to move a node to the head of the list

### Listing 16-8: LRUCache.java
Finally, here is the code for node deletion:

### Listing 16-9: LRUCache.java
You can find this project in GitHub:
https://github.com/htset/java_exercises_dsa/tree/master/WebServerCache