package A3_Assignment;

import java.util.Arrays;

public class CityList {

    private int[] cities;   // Array to hold the cities
    private int size;       // Number of cities in the list
    private static final int INITIAL_CAPACITY = 10; // Initial capacity of the list

    public CityList() {
        this.cities = new int[INITIAL_CAPACITY];
        this.size = 0;
    }

    /**
     * Adds a city to the list, resizing the array if necessary.
     * @param city The city index to add.
     */
    public void add(int city) {
        // Resize the array if it is full
        if (size == cities.length) {
            cities = Arrays.copyOf(cities, size * 2);
        }
        cities[size++] = city;
    }

    /**
     * Gets the city at a specific index.
     * @param index The index of the city to retrieve.
     * @return The city index.
     */
    public int get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }
        return cities[index];  // Access the city at the given index in O(1)
    }

    /**
     * Removes the city at a specific index.
     * @param index The index of the city to remove.
     * @return The removed city's index.
     */
    public int remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }

        int removedCity = cities[index];

        // Shift all elements after the removed city to the left by one position
        System.arraycopy(cities, index + 1, cities, index, size - index - 1);
        size--;
        // Nullify the last element to help with garbage collection
        cities[size] = 0;
        return removedCity;  // Return the removed city's index
    }

    /**
     * Gets the size of the list (number of cities).
     * @return The size of the list.
     */
    public int size() {
        return size;
    }

    /**
     * Checks if the list is empty.
     * @return true if the list is empty, false otherwise.
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Clears the list, removing all cities.
     */
    public void clear() {
        Arrays.fill(cities, 0);
        size = 0;
    }

    /**
     * Prints the cities in the list.
     */
    public void printList() {
        for (int i = 0; i < size; i++) {
            System.out.print(cities[i] + " -> ");
        }
        System.out.println("null");
    }
}
