// package csc933.prac2;


public class CycleRide {
	
	private final int numberMiles;
	private final boolean cycleAlone;

	public CycleRide(int numberMiles, boolean cycleAlone) {
		this.numberMiles = numberMiles;
		this.cycleAlone = cycleAlone;
	}
	
	public int getNumberMiles() {
		return numberMiles;
	}
	
	public boolean isCycleAlone() {
		return cycleAlone;
	}
}
