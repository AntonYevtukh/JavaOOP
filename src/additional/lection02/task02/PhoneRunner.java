package additional.lection02.task02;

public class PhoneRunner {

    public static void main(String[] args) {
        Network life = new Network();
        Phone anton = new Phone("Anton","+380630887878");
        Phone katya = new Phone("Katya","+380935180851");

        anton.register(life);
        anton.call(katya);
        katya.register(life);
        katya.call(anton);
    }
}
