package A3_Assignment;

import java.util.Arrays;

public class HeuristicOptimiser implements OptimisationAlgorithm {

    private CityList route;  
    private boolean[] visited;  
    private double[][] distanceMatrix;  

    // Constructor initialises the optimiser with city coordinates
    public HeuristicOptimiser(int[][] coordinates) {
        this.distanceMatrix = calculateDistanceMatrix(coordinates); 
        this.visited = new boolean[coordinates.length]; 
        this.route = new CityList();  
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
        // Reset visited array
        Arrays.fill(visited, false);
        route = new CityList();
        buildRoute(0);
        twoOptRefinement();
        double totalDistance = calculateTotalDistance(route);
        return new DeliveryRoute(route, totalDistance); // Return the refined route and total distance
    }

    // Main method to build the route using the nearest city heuristic
    private void buildRoute(int startCity) {
        Arrays.fill(visited, false);
        visited[startCity] = true;
        route.add(startCity);

        int currentCity = startCity;

        // Continue finding the nearest unvisited city and adding it to the route
        for (int i = 1; i < visited.length; i++) {
            int nearestCity = findNearestCity(currentCity);
            if (nearestCity != -1) {
                visited[nearestCity] = true;
                route.add(nearestCity);
                currentCity = nearestCity;
            }
        }
    }

    // Method to find the nearest unvisited city from the current city
    private int findNearestCity(int currentCity) {
        double shortestDistance = Double.MAX_VALUE;
        int nearestCity = -1;

        for (int i = 0; i < distanceMatrix.length; i++) {
            if (!visited[i] && distanceMatrix[currentCity][i] < shortestDistance) {
                shortestDistance = distanceMatrix[currentCity][i];
                nearestCity = i;
            }
        }
        return nearestCity;
    }

    // Method to apply the 2-opt heuristic to refine the current route
    private void twoOptRefinement() {
        boolean improvement = true;
        while (improvement) {
            improvement = false;

            for (int i = 1; i < route.size() - 1; i++) {
                for (int j = i + 1; j < route.size(); j++) {
                    if (isImprovement(i, j)) {
                        reverseSegment(i, j);
                        improvement = true;
                    }
                }
            }
        }
    }

    // Check if swapping improves the route
    private boolean isImprovement(int i, int j) {
        int a = route.get(i - 1);
        int b = route.get(i);
        int c = route.get(j);
        int d = route.get((j + 1) % route.size());

        // Check if swapping reduces the total distance
        return (distanceMatrix[a][b] + distanceMatrix[c][d]) >
               (distanceMatrix[a][c] + distanceMatrix[b][d]);
    }

    // Reverse a segment of the route between two indices
    private void reverseSegment(int i, int j) {
        // Convert the route to an array
        int[] routeArray = new int[route.size()];
        for (int k = 0; k < route.size(); k++) {
            routeArray[k] = route.get(k);
        }

        // Perform the reversal on the array
        while (i < j) {
            int temp = routeArray[i];
            routeArray[i] = routeArray[j];
            routeArray[j] = temp;
            i++;
            j--;
        }

        // Rebuild the CityList from the modified array
        route = new CityList();
        for (int city : routeArray) {
            route.add(city);
        }
    }



    // Calculate the total distance of the current route
    public double calculateTotalDistance(CityList route) {
        double totalDistance = 0;

        // Sum the distances between consecutive cities in the route
        for (int i = 0; i < route.size() - 1; i++) {
            totalDistance += distanceMatrix[route.get(i)][route.get(i + 1)];
        }

        // Add the distance to return to the start city
        if (route.size() > 1) {
            totalDistance += distanceMatrix[route.get(route.size() - 1)][route.get(0)];
        }

        return totalDistance;
    }

    // Print the current route
    public void printRoute() {
        for (int i = 0; i < route.size(); i++) {
            System.out.print(route.get(i) + " -> ");
        }
        System.out.println("Start");
    }
    
    public double findShortestRoute() {
    	buildRoute(0);
    	return calculateTotalDistance(route);
    }
}