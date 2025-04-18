
public class Main {
	
	private static CycleCalculator cycleCalculator = new CycleCalculator();	
	
	public static void main(String args[]) {
		// testing competency
		System.out.println("Beginner competency level is correct? " + Boolean.toString(1.5 ==
				cycleCalculator.getDuration(15, "Beginner", 0, true, 15, 0, false)));
		System.out.println("Intermediate competency level is correct? " + Boolean.toString(2 ==
				cycleCalculator.getDuration(30, "Intermediate", 0, true, 15, 0, false)));
		System.out.println("Advanced competency level is correct? " + Boolean.toString(1.0 ==
				cycleCalculator.getDuration(20, "Advanced", 0, true, 15, 0, false)));

		// testing buddy
		System.out.println("Test cycling with a buddy is correct? " + Boolean.toString(2.0 ==
				cycleCalculator.getDuration(24, "Beginner", 0, false, 15, 0, false)));
		System.out.println("Test cycling alone is correct? " + Boolean.toString(2.4 ==
				cycleCalculator.getDuration(24, "Beginner", 0, true, 15, 0, false)));

		// testing years experience
		System.out.println("Test years experience is correct? " + Boolean.toString(1.0 ==
				cycleCalculator.getDuration(11, "Beginner", 5, true, 15, 0, false)));

		// testing temperature
		System.out.println("Test temperature more than 10 is correct? " + Boolean.toString(1.8 ==
				cycleCalculator.getDuration(18, "Beginner", 0, true, 15, 0, false)));
		System.out.println("Test temperature less than 10 is correct? " + Boolean.toString(2 ==
				cycleCalculator.getDuration(18, "Beginner", 0, true, 0, 0, false)));
		System.out.println("Test temperature more than 20 is correct? " + Boolean.toString(2.0 ==
				cycleCalculator.getDuration(18, "Beginner", 0, true, 30, 0, false)));
		System.out.println("Test temperature less than 20 is correct? " + Boolean.toString(1.0 ==
				cycleCalculator.getDuration(10, "Beginner", 0, true, 15, 0, false)));

		// testing wind
		System.out.println("Test windspeed at 10mph is correct? " + Boolean.toString(1.0 ==
				cycleCalculator.getDuration(10, "Beginner", 0, true, 15, 10, false)));
		System.out.println("Test windspeed at 20mph is correct? " + Boolean.toString(1.0 ==
				cycleCalculator.getDuration(9, "Beginner", 0, true, 15, 20, false)));
		System.out.println("Test windspeed at 70mph is correct? " + Boolean.toString(1.0 ==
				cycleCalculator.getDuration(6, "Beginner", 0, true, 15, 70, false)));

		// testing rain
		System.out.println("Test raining is correct? " + Boolean.toString(2.0 ==
				cycleCalculator.getDuration(16, "Beginner", 0, true, 15, 0, true)));
		System.out.println("Test not raining is correct? " + Boolean.toString(1.0 ==
				cycleCalculator.getDuration(10, "Beginner", 0, true, 15, 0, false)));

		// testing total duration
		System.out.println("Test adding up total durations is correct? " + Boolean.toString(23.4 ==
			cycleCalculator.getTotalDuration(new double[] { 0.5, 1.2, 3.4, 5.6, 2.32, 1.4, 8.98 })));
		System.out.println("Test adding up total durations is correct? " + Boolean.toString(28.13 ==
			cycleCalculator.getTotalDuration(new double[] { 2, 5.65, 4.8, 7.5, 6.98, 1.2 })));
		
		// testing formatted duration
		System.out.println("Test formatting duration for 1.99 hours is correct? " + 
			Boolean.toString("1 hour(s) and 59 minute(s)".equals(cycleCalculator.getFormattedDuration(1.99))));
		System.out.println("Test formatting duration for 2.01 hours is correct? " + 
			Boolean.toString("2 hour(s) and 1 minute(s)".equals(cycleCalculator.getFormattedDuration(2.01))));
		System.out.println("Test formatting duration for 2.00 hours is correct? " + 
			Boolean.toString("2 hour(s)".equals(cycleCalculator.getFormattedDuration(2.00))));
	}

}
