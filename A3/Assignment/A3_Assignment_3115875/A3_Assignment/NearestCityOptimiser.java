package A3_Assignment;

import java.util.Arrays;
import java.util.HashMap;

public class NearestCityOptimiser implements OptimisationAlgorithm {

    private boolean[] visited; 
    private HashMap<String, Double> distanceMap; 
    private int[] route; 
    private int numCities; 

    // Constructor initializes the optimiser with city coordinates
    public NearestCityOptimiser(int[][] coordinates) {
        this.numCities = coordinates.length;
        this.distanceMap = calculateDistanceMap(coordinates); 
        this.visited = new boolean[numCities]; 
        this.route = new int[numCities];
    }

    // Method to calculate distance between each pair of cities and store in a HashMap
    private HashMap<String, Double> calculateDistanceMap(int[][] coordinates) {
        HashMap<String, Double> distances = new HashMap<>();
        for (int i = 0; i < coordinates.length; i++) {
            for (int j = 0; j < coordinates.length; j++) {
                double distance;
                if (i == j) {
                    distance = 0.0;
                } else {
                    distance = Math.sqrt(
                        Math.pow(coordinates[i][0] - coordinates[j][0], 2) +
                        Math.pow(coordinates[i][1] - coordinates[j][1], 2)
                    );
                }
                distances.put(getKey(i, j), distance);
            }
        }
        return distances;
    }


    // Helper method to create a unique key for city pairs
    private String getKey(int city1, int city2) {
        return city1 + "," + city2;
    }

    // Build the route starting from a specific city
    public void buildRoute(int startCity) {
        Arrays.fill(visited, false);
        visited[startCity] = true;
        route[0] = startCity;

        if (numCities == 1) { // Edge case for single city
            return;
        }

        int currentCity = startCity;

        for (int i = 1; i < numCities; i++) {
            int nearestCity = findNearestCity(currentCity);
            visited[nearestCity] = true;
            route[i] = nearestCity;
            currentCity = nearestCity;
        }
    }


    // Find the nearest unvisited city
    private int findNearestCity(int currentCity) {
        int nearestCity = -1;
        double shortestDistance = Double.POSITIVE_INFINITY;

        // Iterate through all cities to find the nearest unvisited city
        for (int i = 0; i < numCities; i++) {
            if (!visited[i]) {
                double distance = distanceMap.getOrDefault(getKey(currentCity, i), Double.POSITIVE_INFINITY);
                if (distance < shortestDistance) {
                    shortestDistance = distance;
                    nearestCity = i;
                }
            }
        }

        return nearestCity;
    }

    // Calculate the total distance of the route
    private double calculateTotalDistance() {
        if (numCities == 1) { // Edge case for single city
            return 0.0;
        }
        double totalDistance = 0;
        // Sum the distances between consecutive cities in the route
        for (int i = 0; i < numCities - 1; i++) {
            totalDistance += distanceMap.get(getKey(route[i], route[i + 1]));
        }
        // Add the distance to return to the starting city
        totalDistance += distanceMap.get(getKey(route[numCities - 1], route[0]));

        return totalDistance;
    }


    // Finds the best route from the list of cities (implements OptimisationAlgorithm interface)
    @Override
    public DeliveryRoute findBestRoute(CityList cityList) {
        if (cityList.size() == 0) {
            return new DeliveryRoute(new CityList(), 0.0);
        }

        buildRoute(cityList.get(0)); // Builds from the first city in the list

        // Convert the route array to CityList
        CityList cityRoute = new CityList();
        for (int city : route) {
            cityRoute.add(city);
        }

        double totalDistance = calculateTotalDistance();
        return new DeliveryRoute(cityRoute, totalDistance);
    }

    // Find the shortest route and calculate its total distance 
    public double findShortestRoute() {
        buildRoute(0);
        return calculateTotalDistance(); 
    }
}
