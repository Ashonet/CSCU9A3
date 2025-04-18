package A3_Assignment;

import static org.junit.Assert.*;
import org.junit.Test;

public class TSPTests {

    // Test CityList: adding, retrieving, and removing cities
    @Test
    public void testCityListAddition() {
        CityList list = new CityList();
        list.add(0);
        list.add(1);
        assertEquals(2, list.size());
        assertEquals(0, list.get(0));
        assertEquals(1, list.get(1));
    }

    @Test
    public void testCityListRemoval() {
        CityList list = new CityList();
        list.add(0);
        list.add(1);
        list.remove(0);
        assertEquals(1, list.size());
        assertEquals(1, list.get(0));
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testCityListEmptyAccess() {
        CityList list = new CityList();
        list.get(0);
    }

    // Test BruteForceOptimiser
    @Test
    public void testBruteForceOptimiser() {
        int[][] cities = {{0, 0}, {1, 0}, {0, 1}};
        DeliveryRouteOptimiser optimiser = new DeliveryRouteOptimiser(cities);
        CityList cityList = new CityList();
        cityList.add(0);
        cityList.add(1);
        cityList.add(2);

        DeliveryRoute route = optimiser.findBestRoute(cityList);
        assertNotNull(route);
        assertEquals(3, route.getRoute().size());
    }

    // Test NearestCityOptimiser: valid routes, edge cases, and performance
    @Test
    public void testNearestCityOptimiserValidRoute() {
        int[][] cities = {{0, 0}, {1, 0}, {0, 1}};
        NearestCityOptimiser optimiser = new NearestCityOptimiser(cities);
        CityList cityList = new CityList();
        cityList.add(0);
        cityList.add(1);
        cityList.add(2);

        DeliveryRoute route = optimiser.findBestRoute(cityList);
        assertNotNull(route);
        assertEquals(3, route.getRoute().size());
        assertTrue(route.getTotalDistance() > 0);
    }

    @Test
    public void testNearestCityOptimiserEdgeCaseEmptyList() {
        int[][] cities = {{0, 0}, {1, 0}};
        NearestCityOptimiser optimiser = new NearestCityOptimiser(cities);
        CityList cityList = new CityList();

        DeliveryRoute route = optimiser.findBestRoute(cityList);
        assertNotNull(route);
        assertEquals(0, route.getRoute().size());
        assertEquals(0, route.getTotalDistance(), 0.001);
    }

    @Test
    public void testNearestCityOptimiserEdgeCaseSingleCity() {
        int[][] cities = {{0, 0}};
        NearestCityOptimiser optimiser = new NearestCityOptimiser(cities);
        CityList cityList = new CityList();
        cityList.add(0);

        DeliveryRoute route = optimiser.findBestRoute(cityList);
        assertNotNull(route);
        assertEquals(1, route.getRoute().size());
        assertEquals(0, route.getTotalDistance(), 0.001);
    }

    @Test
    public void testNearestCityOptimiserLargerCitySet() {
        int[][] cities = new int[50][2];
        for (int i = 0; i < 50; i++) {
            cities[i][0] = i;
            cities[i][1] = i * 2;
        }
        NearestCityOptimiser optimiser = new NearestCityOptimiser(cities);
        CityList cityList = new CityList();
        for (int i = 0; i < 50; i++) {
            cityList.add(i);
        }

        DeliveryRoute route = optimiser.findBestRoute(cityList);
        assertNotNull(route);
        assertEquals(50, route.getRoute().size());
        assertTrue(route.getTotalDistance() > 0);
    }

    // Test HeuristicOptimiser
    @Test
    public void testHeuristicOptimiser() {
        int[][] cities = {{0, 0}, {3, 0}, {0, 4}, {3, 4}}; 
        HeuristicOptimiser optimiser = new HeuristicOptimiser(cities);
        CityList cityList = new CityList();
        cityList.add(0);
        cityList.add(1);
        cityList.add(2);
        cityList.add(3);

        DeliveryRoute route = optimiser.findBestRoute(cityList);
        assertNotNull(route);
        assertEquals(4, route.getRoute().size());
        assertTrue(route.getTotalDistance() > 0);

        System.out.println("Heuristic Best Route: " + route.getRoute());
        System.out.println("Total Distance: " + route.getTotalDistance());
    }

    // Test BacktrackingOptimiser
    @Test
    public void testBacktrackingOptimiser() {
        int[][] cities = {{0, 0}, {1, 0}, {0, 1}};  // Simple 3 city example
        BacktrackingOptimiser optimiser = new BacktrackingOptimiser(cities);
        CityList cityList = new CityList();
        cityList.add(0);
        cityList.add(1);
        cityList.add(2);

        DeliveryRoute route = optimiser.findBestRoute(cityList);
        assertNotNull(route);
        assertEquals(3, route.getRoute().size());
        assertTrue(route.getTotalDistance() > 0);

        System.out.println("Backtracking Best Route: " + route.getRoute());
        System.out.println("Total Distance: " + route.getTotalDistance());
    }
}
