
# Flights
Let’s create a console application that will maintain a list of flights between cities and that will find the best combination of flights in terms of ticket cost.

## Proposed Solution
This problem involves creating a graph between the cities. This graph will be weighted, with the cost of the respective ticket. We will use Dijkstra’s algorithm to find the cheapest path between two of those cities.
First, we define the City class that will store a map of the connected cities and the respective costs:

## Listing 14-1: Flights.java
Next, we define the FlightGraph class:

## Listing 14-2: Flights.java
This class contains all the cities objects in a map along with their names. We can add cities and flights to our graph with the following methods:

## Listing 14-3: Flights.java
Note that we assume that flights are bidirectional, and that they have the same price in both directions.
Next, we calculate the cheapest route between two cities using Dijkstra’s algorithm:

## Listing 14-4: Flights.java
Initially, we initialize a dictionary to store the distances from the source city to every other city, marking the source city's distance as 0 and all other cities as infinity. We use a priority queue to process cities based on their distance from the source, dequeuing the city with the shortest distance first.
For each dequeued city, we examine its neighboring cities, updating their distances if a shorter path through the current city is found. This process continues until all cities are visited or until the destination city is reached.
Upon completion, we reconstruct the shortest path from the source to the destination using the information stored in the previous node map, facilitating the determination of the total price of the route.
To avoid getting stuck in loops during the graph traversal, we keep track of the cities visited in the current path (dist map). If a city has already been visited in the current path, we skip exploring flights from that city to prevent loops.
We can calculate and print all the possible flights between two cities using Depth-First Search (DFS):

## Listing 14-5: Flights.java
We see that method displayAllFlights() calls the recursive dfs() method:

## Listing 14-6: Flights.java
The dfs() method in the FlightGraph class implements Depth-First Search (DFS) recursively to find all possible flights between a source and a destination city within a flight network.
It begins by marking the current city as visited and checks if it matches the destination city. If the destination is reached, it prints the current path. Otherwise, it explores all neighboring cities not yet visited by recursively calling itself for each neighbor.
During exploration, it pushes the neighboring city onto the path stack and continues the search until all possible paths from the current city are explored or until the destination is reached.
Upon backtracking, it removes the current city from the path stack and marks it as unvisited, allowing exploration of alternative paths. This process is repeated until all cities in the network are explored.
We use the aforementioned stack to print the final path in PrintPath() method:

## Listing 14-7: Flights.java
Finally in main(), we add cities and flights to the graph and we ask the user to select a pair of cities to calculate the best (cheapest) combination of flights:

## Listing 14-8: Flights.java
You can find this project in GitHub:
https://github.com/htset/java_exercises_dsa/tree/master/Flights