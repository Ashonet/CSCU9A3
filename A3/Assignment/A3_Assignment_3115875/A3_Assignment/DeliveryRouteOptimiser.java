package A3_Assignment;
import java.util.*;

/**
 * Uses brute force algorithm for solving the TSP
 */
public class DeliveryRouteOptimiser implements OptimisationAlgorithm {
    private double[][] distanceMatrix;
    private List<int[]> allPermutations;

    public DeliveryRouteOptimiser(int[][] coordinates) {
        this.distanceMatrix = calculateDistanceMatrix(coordinates);
        this.allPermutations = new ArrayList<>();
        generatePermutations(coordinates.length);
    }

    /**
     * Calculate the distance between each pair of locations
     * @param coordinates 
     * @return distances
     */
    private double[][] calculateDistanceMatrix(int[][] coordinates) {
        int n = coordinates.length;
        double[][] distances = new double[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                distances[i][j] = Math.sqrt(Math.pow(coordinates[i][0] - coordinates[j][0], 2)
                                          + Math.pow(coordinates[i][1] - coordinates[j][1], 2));
            }
        }
        return distances;
    }

    // Finds the best route from the list of cities
    @Override
    public DeliveryRoute findBestRoute(CityList cities) {
        List<int[]> allPermutations = generatePermutations(cities.size());
        double bestDistance = Double.MAX_VALUE;
        CityList bestRoute = null;

        for (int[] route : allPermutations) {
            double currentDistance = calculateRouteDistance(route);
            if (currentDistance < bestDistance) {
                bestDistance = currentDistance;
                bestRoute = new CityList();
                for (int city : route) {
                    bestRoute.add(city);
                }
            }
        }
        return new DeliveryRoute(bestRoute, bestDistance);
    }
    
    /**
     * Brute-force solution: try all permutations of the cities
     * @return
     */
    public double findShortestRoute() {
        double bestDistance = Double.MAX_VALUE;
        int[] bestRoute = null;
        
        for (int[] route : allPermutations) {
            double currentDistance = calculateRouteDistance(route);
            if (currentDistance < bestDistance) {
                bestDistance = currentDistance;
                bestRoute = route;
            }
        }
        // uncomment the line below if you want to see the best route
        //System.out.println("Best Route: " + Arrays.toString(bestRoute));
        return bestDistance;
    }

    /**
     * Calculate total distance of a specific route
     * @param route
     * @return
     */
    private double calculateRouteDistance(int[] route) {
        double totalDistance = 0;
        for (int i = 0; i < route.length - 1; i++) {
            totalDistance += distanceMatrix[route[i]][route[i + 1]];
        }
        totalDistance += distanceMatrix[route[route.length - 1]][route[0]];
        return totalDistance;
    }

    /**
     * Generate all possible permutations of cities
     * @param n
     */
    private List<int[]> generatePermutations(int n) {
        List<int[]> permutations = new ArrayList<>();
        int[] cities = new int[n];
        for (int i = 0; i < n; i++) {
            cities[i] = i;
        }
        permute(cities, 0, permutations);
        return permutations;
    }

    /**
     * A recursive method to generate all possible permutations of the 
     * @param arr the indexes of the cities
     * @param k the index of the starting point.
     */
    private void permute(int[] arr, int k, List<int[]> permutations) {
        if (k == arr.length) {
            permutations.add(arr.clone());
        } else {
            for (int i = k; i < arr.length; i++) {
                int temp = arr[k];
                arr[k] = arr[i];
                arr[i] = temp;
                permute(arr, k + 1, permutations);
                temp = arr[k];
                arr[k] = arr[i];
                arr[i] = temp;
            }
        }
    }
}
