package homework.lection03.task01;

class StandardTariff implements TaxiTariff {

    public long calculatePrice(TaxiRide ride) {
        return 30 + 5 * ride.getDistance() + 2 * ride.getDuration();
    }
}

class FamilyTariff implements TaxiTariff {

    public long calculatePrice(TaxiRide ride) {
        return 50 + 20 * ride.getDistance() / ride.getPassengers();
    }
}
