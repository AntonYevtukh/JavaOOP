package additional.lection2.task02;


import java.util.HashSet;

public class Network {
    private HashSet<Phone> phones;

    Network() {
        phones = new HashSet<>();
    }

    public void add(Phone phone) {
        phones.add(phone);
    }

    public boolean has(Phone phone) {
        return phones.contains(phone);
    }
}
