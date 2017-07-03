package homework.lection03.task03;

public class Odd {

    private final String type;
    private final int rpm;

    public Odd(String type, int rpm) {
        if (rpm > 0) {
            this.rpm = rpm;
            this.type = type;
        }
        else
            throw new IllegalArgumentException("Invalid non-positive parameters for ODD: rounds per minute: " + rpm + ".");
    }

    public String getType() {
        return type;
    }

    public int getRpm() {
        return rpm;
    }

    public String toString() {
        return "ODD: " + type + " " + rpm + "rpm.";
    }
}
