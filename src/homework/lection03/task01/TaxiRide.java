package homework.lection03.task01;

public class TaxiRide {
    private final int passengers;
    private final int distance;
    private final int duration;

    public TaxiRide(int passengers, int distance, int duration) {
        String errorMessage = "";
        if (passengers > 0 && distance > 0 && duration > 0) {
            this.passengers = passengers;
            this.distance = distance;
            this.duration = duration;
        } else {
            errorMessage = "Invalid non-positive parameters: ";
            if (passengers <= 0) errorMessage += "passengers = " + passengers + "; ";
            if (distance <= 0) errorMessage += "distance = " + distance + "; ";
            if (duration <= 0) errorMessage += "duration = " + duration + ";";
            throw new IllegalArgumentException(errorMessage);
        }
    }

    public int getPassengers() {
        return passengers;
    }

    public int getDistance() {
        return distance;
    }

    public int getDuration() {
        return duration;
    }

    public String toString() {
        return "Taxi ride: passengers: " + passengers + ", distance: " + distance + ", duration: " + duration + ";";
    }
}
