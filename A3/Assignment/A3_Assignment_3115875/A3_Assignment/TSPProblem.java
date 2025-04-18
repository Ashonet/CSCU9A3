package A3_Assignment;

import java.io.*;

public class TSPProblem {
    private CityList cities;

    public TSPProblem(String fileName) {
        this.cities = loadCitiesFromFile(fileName);
    }

    private CityList loadCitiesFromFile(String fileName) {
        CityList cityList = new CityList();
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(" ");
                int x = Integer.parseInt(parts[0]);
                int y = Integer.parseInt(parts[1]);
                cityList.add(cityList.size()); // Add city index
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return cityList;
    }

    public double calculateTotalDistance(DeliveryRoute route) {
        CityList routeCities = route.getRoute();
        double distance = 0;
        for (int i = 0; i < routeCities.size() - 1; i++) {
            int from = routeCities.get(i);
            int to = routeCities.get(i + 1);
            // Calculate distance here using a provided distance matrix or coordinates
        }
        return distance;
    }
}
