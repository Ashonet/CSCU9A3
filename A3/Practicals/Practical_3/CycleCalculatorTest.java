import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class CycleCalculatorTest
{
	private static final double ACCURACY = 0.001;

	private CycleCalculator cycleCalculator;

	@Before
	public void setup()
	{
		cycleCalculator = new CycleCalculator();		
	}
	
	@Test
	public void testCompetency()
	{
		CycleRide cycle1 = new CycleRide(15, true);
		Cyclist cyclist1 = new Cyclist("Beginner", 0);
		assertEquals("Beginner competency level failed:", 1.5, cycleCalculator.getDuration(cycle1, cyclist1, 15, 0, false), ACCURACY);
		
		CycleRide cycle2 = new CycleRide(30, true);
		Cyclist cyclist2 = new Cyclist("Intermediate", 0);
		assertEquals("Intermediate competency level failed:", 2.0, cycleCalculator.getDuration(cycle2, cyclist2, 15, 0, false), ACCURACY);
		
		CycleRide cycle3 = new CycleRide(20, true);
		Cyclist cyclist3 = new Cyclist("Advanced", 0);
		assertEquals("Advanced competency level failed:", 1.0, cycleCalculator.getDuration(cycle3, cyclist3, 15, 0, false), ACCURACY);
	}
	
	@Test
	public void testCycleBuddy()
	{
		CycleRide cycle1 = new CycleRide(24, false);
		Cyclist cyclist1 = new Cyclist("Beginner", 0);
		assertEquals("Test cycling with a buddy failed:", 2.0, cycleCalculator.getDuration(cycle1, cyclist1, 15, 0, false), ACCURACY);
		
		CycleRide cycle2 = new CycleRide(24, true);
		Cyclist cyclist2 = new Cyclist("Beginner", 0);
		assertEquals("Test cycling alone failed:", 2.4, cycleCalculator.getDuration(cycle2, cyclist2, 15, 0, false), ACCURACY);
	}
	
	@Test
	public void testYearsExperience()
	{
		CycleRide cycle1 = new CycleRide(11, true);
		Cyclist cyclist1 = new Cyclist("Beginner", 5);
		assertEquals("Test years experience failed:", 1.0, cycleCalculator.getDuration(cycle1, cyclist1, 15, 0, false), ACCURACY);
	}
	
	@Test
	public void testLessThan10()
	{
		CycleRide cycle1 = new CycleRide(18, true);
		Cyclist cyclist1 = new Cyclist("Beginner", 0);
		assertEquals("Test temperature less than 10 failed:", 2.0, cycleCalculator.getDuration(cycle1, cyclist1, 0, 0, false), ACCURACY);
		
		CycleRide cycle2 = new CycleRide(18, true);
		Cyclist cyclist2 = new Cyclist("Beginner", 0);
		assertEquals("Test temperature equal to 10 failed:", 1.8, cycleCalculator.getDuration(cycle2, cyclist2, 10, 0, false), ACCURACY);
		
		CycleRide cycle3 = new CycleRide(18, true);
		Cyclist cyclist3 = new Cyclist("Beginner", 0);
		assertEquals("Test temperature more than 10 failed:", 1.8, cycleCalculator.getDuration(cycle3, cyclist3, 15, 0, false), ACCURACY);
	}
	
	@Test
	public void testMoreThan20()
	{
		CycleRide cycle1 = new CycleRide(18, true);
		Cyclist cyclist1 = new Cyclist("Beginner", 0);
		assertEquals("Test temperature more than 20 failed:", 2.0, cycleCalculator.getDuration(cycle1, cyclist1, 30, 0, false), ACCURACY);
		
		CycleRide cycle2 = new CycleRide(18, true);
		Cyclist cyclist2 = new Cyclist("Beginner", 0);
		assertEquals("Test temperature equal to 20 failed:", 1.8, cycleCalculator.getDuration(cycle2, cyclist2, 20, 0, false), ACCURACY);
		
		CycleRide cycle3 = new CycleRide(18, true);
		Cyclist cyclist3 = new Cyclist("Beginner", 0);
		assertEquals("Test temperature less than 20 failed:", 1.8, cycleCalculator.getDuration(cycle2, cyclist2, 15, 0, false), ACCURACY);
	}
	
	@Test
	public void testWindSpeed()
	{
		CycleRide cycle1 = new CycleRide(10, true);
		Cyclist cyclist1 = new Cyclist("Beginner", 0);
		assertEquals("Test windspeed at 10mph failed:", 1.0, cycleCalculator.getDuration(cycle1, cyclist1, 15, 10, false), ACCURACY);
		
		CycleRide cycle2 = new CycleRide(10, true);
		Cyclist cyclist2 = new Cyclist("Beginner", 0);
		assertEquals("Test windspeed at 20mph failed:", 1.111, cycleCalculator.getDuration(cycle2, cyclist2, 15, 20, false), ACCURACY);
		
		CycleRide cycle3 = new CycleRide(10, true);
		Cyclist cyclist3 = new Cyclist("Beginner", 0);
		assertEquals("Test windspeed at 70mph failed:", 1.666, cycleCalculator.getDuration(cycle3, cyclist3, 15, 70, false), ACCURACY);
	}
	
	@Test
	public void testRaining()
	{
		CycleRide cycle1 = new CycleRide(16, true);
		Cyclist cyclist1 = new Cyclist("Beginner", 0);
		assertEquals("Test raining failed:", 2.0, cycleCalculator.getDuration(cycle1, cyclist1, 15, 0, true), ACCURACY);
		
		CycleRide cycle2 = new CycleRide(10, true);
		Cyclist cyclist2 = new Cyclist("Beginner", 0);
		assertEquals("Test not raining failed:", 1.0, cycleCalculator.getDuration(cycle2, cyclist2, 15, 0, false), ACCURACY);
	}

}
