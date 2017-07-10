package additional.lection02.task02;

public class Phone {

    private String name;
    private String number;
    private Network network;

    public Phone(String name, String number) {
        this.name = name;
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public String getNumber() {
        return number;
    }

    public void register(Network network) {
        network.add(this);
        this.network = network;
    }

    public void call(Phone phone) {
        if (this != phone) {
            if (network != null) {
                System.out.println("Calling: " + phone.name + " " + phone.number);
                if (network.has(phone))
                    phone.incomingCall(this);
                else
                    System.out.println("Sorry, the subscriber is temporarily unavailable.");
            } else
                System.out.println("No network is available.");
        }
    }

    private void incomingCall(Phone phone) {
        System.out.println("Incoming call from: " + phone.name + " " + phone.number);
    }
}
