package homework.lection03.task03;

public class Hdd {

    private final int rpm;
    private final Prefix units;
    private final int size;
    private boolean infected;

    public Hdd(int size, Prefix units, int rpm) {
        if (rpm > 0 && size > 0) {
            this.rpm = rpm;
            this.size = size;
            this.units = units;
        } else {
            String errorMessage = "Invalid non-positive parameters for HDD:";
            if (rpm <= 0) errorMessage += " rounds per minute: " + rpm + ",";
            if (size <= 0) errorMessage += " size: " + size + ".";
            throw new IllegalArgumentException(errorMessage);
        }
    }

    public boolean isInfected() {
        return infected;
    }

    public void setInfected(boolean infected) {
        this.infected = infected;
    }

    public int getRpm() {
        return rpm;
    }

    public Prefix getUnits() {
        return units;
    }

    public int getSize() {
        return size;
    }

    public String toString() {
        return "HDD: " + size + " " + units + "B, " + rpm + " rpm.";
    }
}
