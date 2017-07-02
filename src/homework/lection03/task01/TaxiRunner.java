package homework.lection03.task01;

public class TaxiRunner {

    public static void main(String[] args) {

        TaxiRide ride1 = new TaxiRide(2,10,15);
        TaxiRide ride2 = new TaxiRide(5, 20, 25);
        TaxiRide ride3 = new TaxiRide(4,6,8);

        TaxiRides rides = new TaxiRides(ride1,ride2,ride3);
        System.out.println(rides);

        TaxiTariff standardTariff = new StandardTariff(); //стандартный тариф
        TaxiTariff familyTariff = new FamilyTariff(); //семейный тариф

        System.out.println("Summary price for standard tariff \"30 + 5 * distance + 2 * duration\" is " +
                rides.calculateSummaryPrice(standardTariff));
        System.out.println("Summary price for family tariff \"50 + 20 * distance / passengers\" is " +
                rides.calculateSummaryPrice(familyTariff));
        //новый тариф - анонимный класс
        System.out.println("Summary price for custom1 tariff \"passengers * distance\" is " +
                rides.calculateSummaryPrice(new TaxiTariff() {
                    public long calculatePrice(TaxiRide ride) {
                        return ride.getPassengers() * ride.getDistance();
                    }
        }));
        //новый тариф - лямбда
        System.out.println("Summary price for custom2 tariff \"passengers * duration\" is "
                + rides.calculateSummaryPrice((TaxiRide ride) -> (ride.getPassengers()) * ride.getDuration()));
    }
}
