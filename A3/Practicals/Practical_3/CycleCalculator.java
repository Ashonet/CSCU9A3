

/**
 * CycleCalculator class which uses Colins top secret rules to calculate the 
 * estimated duration of a cycle given certain information about the cyclist, 
 * the route and the weather.
 */
public class CycleCalculator 
{
	
	// The nice new method that we're refactoring. It is already receiving objects of two classes
	// (CycleRide and Cyclist) instead of parameters. Refactor more!
	public double getDuration(CycleRide cycleRide, Cyclist cyclist, int temp, int windSpeed, boolean isRaining) 
	{
		double speed = 0;

		// Competency
		if (cyclist.isBeginner())
		{
			speed = 10;
		}
		else if (cyclist.isIntermediate())
		{
			speed = 15;
		}
		else if (cyclist.isAdvanced())
		{
			speed = 20;
		}

		// Cycling buddy
		if (!cycleRide.isCycleAlone())
		{
			speed = speed * 1.2;
		}

		// Experience
		speed = speed + (cyclist.getNumYearsExperience() * 0.2);


		// Weather:
		
		// Temperature
		if (temp <= 10)
		{
			speed = speed - ((10 - temp) * 0.1);
		}
		else if (temp >= 20)
		{
			speed = speed - ((temp - 20) * 0.1);
		}

		// Wind
		if (windSpeed >= 15)
		{
			speed = speed - (windSpeed / 15);
		}

		// Rain
		if (isRaining)
		{
			speed = speed - 2;
		}

		return cycleRide.getNumberMiles() / speed;
	}
	
}
