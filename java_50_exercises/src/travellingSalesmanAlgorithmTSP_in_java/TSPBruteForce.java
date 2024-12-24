package travellingSalesmanAlgorithmTSP_in_java;

import java.util.ArrayList;
import java.util.List;

public class TSPBruteForce {
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
    public static int calculateTourDistance(List<Integer> tour, int[][] distances) {
        int distance = 0;
        for (int i = 0; i < tour.size() - 1; i++) {
            distance += distances[tour.get(i)][tour.get(i + 1)];
        }
        distance += distances[tour.get(tour.size() - 1)][tour.get(0)]; // Return to the starting city
        return distance;
    }
    public static boolean nextPermutation(List<Integer> tour) {
        int n = tour.size();
        int i = n - 2;
        while (i >= 0 && tour.get(i) >= tour.get(i + 1)) {
            i--;
        }
        if (i < 0) {
            return false;
        }
        int j = n - 1;
        while (tour.get(j) <= tour.get(i)) {
            j--;
        }
        swap(tour, i, j);
        reverse(tour, i + 1, n - 1);
        return true;
    }
    public static void swap(List<Integer> tour, int i, int j) {
        int temp = tour.get(i);
        tour.set(i, tour.get(j));
        tour.set(j, temp);
    }
    public static void reverse(List<Integer> tour, int start, int end) {
        while (start < end) {
            swap(tour, start, end);
            start++;
            end--;
        }
    }
}