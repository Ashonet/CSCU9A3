import java.util.Arrays;
import java.util.Random;

public class Main {

	public static void main(String[] args) {
		Module a3 = new Module("CSCU9A3", new int[] { 171, 954, 999, 857, 486 });

		a3.add_student(857);
		a3.remove_student(999);

		System.out.println("Original array: " + Arrays.toString(a3.getList()));
		a3.sort();  // calling the sort method
		System.out.println("Sorted array: " + Arrays.toString(a3.getList()));

		System.out.println(a3.find_binary(857)); // calling the find_sequential
		test_binary_search();
	}
	
	public static void test_binary_search() {
		int array_size = 1000;
		Random rd = new Random(); 
		int[] arr = new int[array_size];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = rd.nextInt(999999999); 
		}
	
		Module test = new Module("test", arr);
		test.sort(); // Binary search requires sorted array
	
		long start = System.nanoTime();
		test.find_binary(arr[array_size - 100]);  // Binary search
		long end = System.nanoTime();
		System.out.println("Binary search time: " + (end - start));
	}

	public static void compare_searches() {
		int array_size = 10000;
		Random rd = new Random(); 
		int[] arr = new int[array_size];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = rd.nextInt(999999999); 
		}
	
		Module test = new Module("test", arr);
	
		// Sequential Search
		long seq_start = System.nanoTime();
		test.find_sequential(arr[array_size - 100]);
		long seq_end = System.nanoTime();
		System.out.println("Sequential search time: " + (seq_end - seq_start));
	
		// Binary Search
		test.sort(); // Sort before binary search
		long bin_start = System.nanoTime();
		test.find_binary(arr[array_size - 100]);
		long bin_end = System.nanoTime();
		System.out.println("Binary search time: " + (bin_end - bin_start));
	}

}
