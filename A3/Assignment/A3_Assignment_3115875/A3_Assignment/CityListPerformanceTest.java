package A3_Assignment;

public class CityListPerformanceTest {

    public static void main(String[] args) {
        // Test for the original singly linked list
        CityList originalList = new CityList();  // Original linked list
        testListPerformance(originalList);

        // Test for the new array-backed list
        CityList refactoredList = new CityList();  // Refactored array-backed list
        testListPerformance(refactoredList);
    }

    //Test the performance of adding, retrieving, and removing cities.
    public static void testListPerformance(CityList list) {
        int[] testSizes = {10, 20, 50};

        for (int size : testSizes) {
            System.out.println("Testing list size: " + size);

            // Add cities
            long startTime = System.nanoTime();
            for (int i = 0; i < size; i++) {
                list.add(i);
            }
            long endTime = System.nanoTime();
            System.out.println("Add operation time taken: " + (endTime - startTime) + "ns");

            // Get cities
            startTime = System.nanoTime();
            for (int i = 0; i < size; i++) {
                list.get(i);
            }
            endTime = System.nanoTime();
            System.out.println("Get operation time taken: " + (endTime - startTime) + "ns");

            // Remove cities
            startTime = System.nanoTime();
            for (int i = size - 1; i >= 0; i--) {
                list.remove(i);
            }
            endTime = System.nanoTime();
            System.out.println("Remove operation time taken: " + (endTime - startTime) + "ns");

            System.out.println();
        }
    }
}
