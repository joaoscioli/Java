package travellingSalesmanAlgorithmTSP_in_java;

import java.util.ArrayList;
import java.util.List;

/// # Travelling Salesman Problem (TSP) - Brute Force Approach
/// This program solves the **Travelling Salesman Problem (TSP)** using a **brute-force** method with permutations.
///
/// ## Problem Definition
/// Given a set of cities and the distances between them, find the shortest possible route that visits each city exactly once and returns to the starting city.
///
/// ## Approach
/// - Generate **all possible permutations** of the city order.
/// - Compute the total travel distance for each permutation.
/// - Keep track of the **optimal tour** with the minimum travel distance.
///
/// ## Complexity
/// - **Time Complexity**: **O(n!)** due to the factorial number of permutations.
/// - **Space Complexity**: **O(n)** for storing the tour.
///
/// ## Example
/// ```
/// Distance matrix:
///   {0, 29, 20, 21}
///   {29, 0, 15, 17}
///   {20, 15, 0, 28}
///   {21, 17, 28, 0}
///
/// Output:
///   Optimal tour: [0, 2, 1, 3]
///   Minimum total distance: 69
/// ```
public class TSPBruteForce {

    /// The main entry point of the program.
    ///
    /// - Initializes a **distance matrix** for 4 cities.
    /// - Generates all **permutations** of city orders.
    /// - Finds and prints the **optimal tour** with the shortest distance.
    ///
    /// @param args Command-line arguments (not used).
    public static void main(String[] args) {
        int[][] distances = {
                {0, 29, 20, 21},
                {29, 0, 15, 17},
                {20, 15, 0, 28},
                {21, 17, 28, 0}
        };

        List<Integer> tour = new ArrayList<>();
        for (int i = 0; i < distances.length; i++) {
            tour.add(i);
        }

        List<Integer> optimalTour = null;
        int minDistance = Integer.MAX_VALUE;

        // Generate all possible city permutations and find the shortest route
        do {
            int tourDistance = calculateTourDistance(tour, distances);
            if (tourDistance < minDistance) {
                minDistance = tourDistance;
                optimalTour = new ArrayList<>(tour);
            }
        } while (nextPermutation(tour));

        System.out.println("Optimal tour: " + optimalTour);
        System.out.println("Minimum total distance: " + minDistance);
    }

    /// Calculates the total distance of a given tour.
    ///
    /// ## Parameters
    /// - `tour`: List of cities representing a specific tour order.
    /// - `distances`: Distance matrix between cities.
    ///
    /// ## Returns
    /// - The **total distance** traveled in the given tour.
    ///
    /// ## Algorithm
    /// 1. Sum up distances between consecutive cities.
    /// 2. Add the return distance to the starting city.
    public static int calculateTourDistance(List<Integer> tour, int[][] distances) {
        int distance = 0;
        for (int i = 0; i < tour.size() - 1; i++) {
            distance += distances[tour.get(i)][tour.get(i + 1)];
        }
        distance += distances[tour.get(tour.size() - 1)][tour.get(0)]; // Return to the starting city
        return distance;
    }

    /// Generates the next lexicographical permutation of the tour.
    ///
    /// ## Parameters
    /// - `tour`: List of cities representing a permutation.
    ///
    /// ## Returns
    /// - `true` if there is a next permutation.
    /// - `false` if all permutations have been generated.
    ///
    /// ## Algorithm
    /// 1. Find the **rightmost ascent** (largest i where `tour[i] < tour[i+1]`).
    /// 2. Find the smallest element to swap with `tour[i]` from the right.
    /// 3. Swap them and **reverse** the suffix.
    public static boolean nextPermutation(List<Integer> tour) {
        int n = tour.size();
        int i = n - 2;

        while (i >= 0 && tour.get(i) >= tour.get(i + 1)) {
            i--;
        }

        if (i < 0) {
            return false; // No next permutation
        }

        int j = n - 1;
        while (tour.get(j) <= tour.get(i)) {
            j--;
        }

        swap(tour, i, j);
        reverse(tour, i + 1, n - 1);
        return true;
    }

    /// Swaps two elements in the tour list.
    ///
    /// ## Parameters
    /// - `tour`: List of cities.
    /// - `i`: First index to swap.
    /// - `j`: Second index to swap.
    public static void swap(List<Integer> tour, int i, int j) {
        int temp = tour.get(i);
        tour.set(i, tour.get(j));
        tour.set(j, temp);
    }

    /// Reverses a portion of the tour list.
    ///
    /// ## Parameters
    /// - `tour`: List of cities.
    /// - `start`: Starting index of the section to reverse.
    /// - `end`: Ending index of the section to reverse.
    public static void reverse(List<Integer> tour, int start, int end) {
        while (start < end) {
            swap(tour, start, end);
            start++;
            end--;
        }
    }
}
