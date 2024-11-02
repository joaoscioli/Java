# 12. Inventory with AVL Tree
In this exercise, we will create an inventory program, that will store information about the company’s products in an AVL tree structure.
Proposed Solution
An AVL (Adelson-Velsky and Landis) tree is a self-balancing binary search tree structure. With the term balanced, we mean that both branches of the tree have the same depth or differ by one level at the most. To achieve this, a process called rebalancing is occasionally performed, that changes the tree structure in way that the tree is closer to be balanced.
The AVL tree has almost the same structure as a simple binary search tree (BST); the difference lies in the rebalancing algorithm. Let’s see the structure:

## Listing 12-1: Inventory.java
The InventoryNode class contains a product object and two references to the tree’s branches. Most importantly, it also contains the height property, which is used to track the tree’s height.
Next, we define the Inventory class, which contains a reference that is the root of the AVL tree. We also define two internal methods of the tree:

## Listing 12-2: Inventory.java
The former gives us the height of the tree, while the latter checks whether the tree is balanced or not.
Afterwards, we add code for the creation of a new node in the tree:

## Listing 12-3: Inventory.java
Note that the height of the node is set to 1.
Next, we proceed with the definition of two methods for the rotation of the tree to the left or to the right:

## Listing 12-4: Inventory.java
Those two methods will be used when we will try to insert a new node into the tree:

## Listing 12-5: Inventory.java
The idea here is to check for the tree balance after inserting a new node to it. If the tree becomes unbalanced, then we will have to rotate it either to the left or to the right.
Next, we present the methods to traverse the tree while printing its contents, as well as the code to search for a specific product in the tree:

## Listing 12-6: Inventory.java
Traversing the tree means visiting each node in the tree, and this is performed recursively, first for the left branch and then for the right branch.
Searching for a product in the tree works in similar fashion: we visit a node, and we check the product’s ID. If it matches the search ID, then we print the product details, and the method returns. Otherwise, we visit the left or the right branch of the tree recursively, depending on the search ID.
All the methods we have defined so far are private. We also define three public methods that will call those private methods:

## Listing 12-7: Inventory.java
We use this convention because the respective private methods with the same name (insertProduct, traverseTree and searchProduct) are called recursively. In this way, we provide a clean interface to programmers that will use our code.
Finally, here is the main() method:

## Listing 12-8: Inventory.java
We create 100 products with random quantities and prices and place them in an array. Then we shuffle the array in a random order. Afterwards, we insert the products into the AVL tree, and we print its contents.
Finally, a search is performed for a specific product ID. During the search process we print the visited nodes to get an idea of how fast we will find the specific ID inside the AVL tree.
