public class CycleCalculator {
    // Constants for competency levels
    private final int BEGINNER_SPEED = 10;
    private final int INTERMEDIATE_SPEED = 15;
    private final int ADVANCED_SPEED = 20;
    
    // Constants for temperature thresholds
    private final int LOW_TEMP_THRESHOLD = 10;
    private final int HIGH_TEMP_THRESHOLD = 20;
    
    // for checkpoint
    public double getDuration(int numMiles, String competency, 
                              int numYearsExperience, boolean cyclingAlone, 
                              int temp, int windSpeed, boolean isRaining) {
                                
        double baseSpeed = 0.0;

        // Determine base speed based on competency
        switch (competency) {
            case "Beginner":
                baseSpeed = BEGINNER_SPEED;
                break;
            case "Intermediate":
                baseSpeed = INTERMEDIATE_SPEED;
                break;
            case "Advanced":
                baseSpeed = ADVANCED_SPEED;
                break;
            default:
                throw new IllegalArgumentException("Invalid competency level.");
        }

        // Adjust speed for cycling with a buddy
        if (!cyclingAlone) {
            baseSpeed *= 1.2; 
        }

        // Adjust speed for years of experience
        baseSpeed += numYearsExperience * 0.2;

        // Adjust speed for temperature
        if (temp < LOW_TEMP_THRESHOLD) {
            baseSpeed -= (LOW_TEMP_THRESHOLD - temp) * 0.1; // Decrease speed for cold weather
        } else if (temp > HIGH_TEMP_THRESHOLD) {
            baseSpeed -= (temp - HIGH_TEMP_THRESHOLD) * 0.1; // Decrease speed for hot weather
        }

        // Adjust speed for wind speed
        baseSpeed -= (windSpeed / 15) * 1.0; 

        // Adjust speed for rain
        if (isRaining) {
            baseSpeed -= 2.0;
        }

        // Ensure speed doesn't drop below a certain limit (e.g., 1mph)
        if (baseSpeed < 1) {
            baseSpeed = 1.0;
        }

        // Calculate and return duration (time = distance / speed)
        return numMiles / baseSpeed;
    }

    // Advanced work: arrays
    public double getTotalDuration(double[] durations) {
        double totalDuration = 0.0;
        for (double duration : durations) {
            totalDuration += duration;
        }
        return totalDuration;
    }

    // Method to get the formatted duration
    public String getFormattedDuration(double time) {
        // Get hours and minutes
        int hours = (int) Math.floor(time);
        int minutes = (int) Math.round((time - hours) * 60);

        // Return the formatted string
        if (hours > 0 && minutes > 0) {
            return hours + " hour(s) and " + minutes + " minute(s)";
        } else if (hours > 0) {
            return hours + " hour(s)";
        } else {
            return minutes + " minute(s)";
        }
    }
}
