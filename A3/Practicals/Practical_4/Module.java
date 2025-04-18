import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Module {

	private String module_name;
	private int[] list;
	
	private Logger logger;

	public Module(String module_name, int[] list) {
		this.module_name = module_name;
		this.list = list;
		
		logger = Logger.getLogger("Logging module " + module_name);
		logger.setLevel(Level.SEVERE);  // this will only log/print SEVERE type messages
	}
	
	public String getModule_name() {
		return module_name;
	}
	public void setModule_name(String module_name) {
		this.module_name = module_name;
	}
	public int[] getList() {
		return list;
	}
	public void setList(int[] list) {
		this.list = list;
	}

	public void add_student(int s) {
		logger.log(Level.INFO, "Adding student " + s);
		if (find_sequential(s) == -1) { // check if the list contains student s
			logger.log(Level.INFO, "Current student list " + Arrays.toString(list));
	
			int[] new_list = new int[list.length + 1];
			for (int i = 0; i < list.length; i++) 
				new_list[i] = list[i]; 
	  
			new_list[list.length] = s; 
			list = new_list;
			
			logger.log(Level.INFO, "New current student list " + Arrays.toString(list));
		} else {
			logger.log(Level.WARNING, "You can not add the same student twice");
		}
	}

	public void remove_student(int s) {
		logger.log(Level.INFO, "Removing student " + s);
		logger.log(Level.INFO, "Current student list " + Arrays.toString(list));
	
		try {
			int[] new_list = new int[list.length - 1];
			int new_index = 0;  // track index in new list
			for (int i = 0; i < list.length; i++) {
				if (list[i] != s) {
					new_list[new_index++] = list[i];  // copy only if not equal to s
				}
			}
			list = new_list;
			logger.log(Level.INFO, "New current student list " + Arrays.toString(list));
		} catch (Exception e) {
			logger.log(Level.SEVERE, "Could not remove student. Error: " + e);
		}
	}
	
	
	public void sort() {
		for (int i = 0; i < list.length; i++) {
			for (int j = 0; j < list.length - i - 1; j++) {
				if (list[j] > list[j + 1]) {
					int temp = list[j];
					list[j] = list[j + 1];
					list[j + 1] = temp;  
				}
			}
		}
	}
	
	
	public int find_binary(int target) {
		int left = 0;
		int right = list.length - 1;
	
		while (left <= right) {
			int mid = left + (right - left) / 2;
	
			// Check if target is present at mid
			if (list[mid] == target)
				return mid;
	
			// If target is greater, ignore left half
			if (list[mid] < target)
				left = mid + 1;
	
			// If target is smaller, ignore right half
			else
				right = mid - 1;
		}
	
		return -1;  // Target not found
	}
	

}
