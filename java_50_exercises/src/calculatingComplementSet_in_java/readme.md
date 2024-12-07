# Calculating the complement of a set in Java
Write a Java program that calculates the complement of a set of integers with respect to a given universal set. The user must enter the elements of the universal set, then the elements of the set whose complement is to be calculated, and the program must determine and display the elements that are present in the universal set but not in the given set (i.e. the complement).

You need to code the logic for calculating the complement of sets in Java and make sure that your program works correctly. You can also add comments to explain your code.
Example of a solution in Java :

In this example, we have used the findComplement function to calculate the complement of a set to a universal set. The program asks the user to enter the size and elements of both the universal set and the set whose complement is to be calculated, then uses the function to find the elements that are present in the universal set but not in the given set. The complement elements are stored in an ArrayList and displayed at the end. The contains method is used to check whether an element is present in the given set.