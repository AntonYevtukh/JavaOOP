package homework.lection03.task01;

import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;

public class TaxiRides {
    private final List<TaxiRide> rides;

    public TaxiRides() {
        this.rides = new ArrayList<>();
    }

    public TaxiRides(TaxiRide... rides) {
        this();
        add(rides);
    }

    public void add(TaxiRide... rides) {
        for (TaxiRide ride : rides) {
            this.rides.add(ride);
        }
    }

    long calculateSummaryPrice(TaxiTariff tariff) {
        long result = 0;
        for (TaxiRide ride : rides)
            result += tariff.calculatePrice(ride);
        return result;
    }

    public String toString() {
        StringJoiner joiner = new StringJoiner("\n","List of taxi rides:\n","\n");
        for (TaxiRide ride : rides) {
            joiner.add(ride.toString());
        }
        return joiner.toString();
    }
}
