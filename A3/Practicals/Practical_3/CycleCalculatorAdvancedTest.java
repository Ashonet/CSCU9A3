import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class CycleCalculatorAdvancedTest
{
	private static final double ACCURACY = 0.001;

	private CycleCalculator cycleCalculator;

	@Before
	public void setup()
	{
		cycleCalculator = new CycleCalculator();		
	}
	
	@Test
	public void testCycleRide()
	{
		CycleRide cycle1 = new CycleRide(10, true);
		Cyclist cyclist1 = new Cyclist("Beginner", 0);
		assertEquals("Beginner competency level failed:", 1.0, cycleCalculator.getDuration(cycle1, cyclist1, 15, 0, false), ACCURACY);
	}
	
	public void testMountainBikeRide()
	{
		CycleRide cycle2 = new MountainBikeRide(15, true);
		Cyclist cyclist2 = new Cyclist("Intermediate", 0);
		assertEquals("Intermediate competency level failed:", 1.5, cycleCalculator.getDuration(cycle2, cyclist2, 15, 0, false), ACCURACY);
	}

	// create a test here for the RoadBikeRide

}
