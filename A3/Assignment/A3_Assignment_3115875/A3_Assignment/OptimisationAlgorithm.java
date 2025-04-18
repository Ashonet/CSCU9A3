package A3_Assignment;

public interface OptimisationAlgorithm {
	//Finds the optimal delivery route for the given list of cities.
	DeliveryRoute findBestRoute(CityList cities);
}


//Class representing a delivery route contains the sequence of cities and the total distance.
class DeliveryRoute {
    private CityList route;
    private double totalDistance;

    public DeliveryRoute(CityList route, double totalDistance) {
        this.route = route;
        this.totalDistance = totalDistance;
    }

    public CityList getRoute() {
        return route;
    }

    public double getTotalDistance() {
        return totalDistance;
    }

    @Override
    public String toString() {
        return "Route: " + route + ", Total Distance: " + totalDistance;
    }
}
