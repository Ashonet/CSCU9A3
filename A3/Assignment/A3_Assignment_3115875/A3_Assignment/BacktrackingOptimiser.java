package A3_Assignment;

import java.util.ArrayList;
import java.util.List;

public class BacktrackingOptimiser implements OptimisationAlgorithm {

    private double[][] distanceMatrix; 
    private double shortestDistance; 
    private CityList bestRoute; 

    // Constructor initializes the optimizer with city coordinates
    public BacktrackingOptimiser(int[][] coordinates) {
        this.distanceMatrix = calculateDistanceMatrix(coordinates);
        this.shortestDistance = Double.MAX_VALUE; 
        this.bestRoute = new CityList();
    }

    // Method to calculate distance between each pair of cities
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
        int n = cities.size();
        boolean[] visited = new boolean[n]; 
        CityList currentRoute = new CityList(); 
        currentRoute.add(0); 
        visited[0] = true;

        // Start backtracking from the first city
        backtrack(0, visited, currentRoute, 0);

        // Return the best route found
        return new DeliveryRoute(bestRoute, shortestDistance);
    }

    // Backtracking helper method
    private void backtrack(int currentCity, boolean[] visited, CityList currentRoute, double currentDistance) {
        if (currentRoute.size() == visited.length) {
            // Add distance back to the starting city
            double totalDistance = currentDistance + distanceMatrix[currentCity][currentRoute.get(0)];
            if (totalDistance < shortestDistance) {
                shortestDistance = totalDistance; 
                bestRoute = new CityList(); 
                for (int i = 0; i < currentRoute.size(); i++) {
                    bestRoute.add(currentRoute.get(i)); // Copy cities from currentRoute to bestRoute
                }
            }
            return;
        }

        // Explore all unvisited cities
        for (int nextCity = 0; nextCity < visited.length; nextCity++) {
            if (!visited[nextCity]) {
                // Mark the city as visited and add it to the current route
                visited[nextCity] = true;
                currentRoute.add(nextCity);
                
                // Recur with the new city and updated distance
                backtrack(nextCity, visited, currentRoute,
                        currentDistance + distanceMatrix[currentCity][nextCity]);

                // Backtrack: remove the city and mark it as unvisited
                visited[nextCity] = false;
                currentRoute.remove(currentRoute.size() - 1);
            }
        }
    }

    // Print the best route found
    public void printRoute() {
        for (int i = 0; i < bestRoute.size(); i++) {
            System.out.print(bestRoute.get(i) + " -> ");
        }
        System.out.println("Start");
    }

    // Method to find the shortest route and return its total distance (Made it like this because it wouldn't execute)
    public double findShortestRoute() {
        CityList cities = new CityList();
        for (int i = 0; i < distanceMatrix.length; i++) {
            cities.add(i);
        }
        findBestRoute(cities);
        return shortestDistance;
    }
}
