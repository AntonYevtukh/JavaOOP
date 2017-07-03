package homework.lection03.task03;

public class Cpu {

    private final int cores;
    private final int frequency;
    private final Prefix units;

    public Cpu(int cores, int frequency, Prefix units) {
        if (cores > 0 && frequency > 0) {
            this.cores = cores;
            this.frequency = frequency;
            this.units = units;
        } else {
            String errorMessage = "Invalid non-positive parameters for CPU:";
            if (cores <= 0) errorMessage += " cores: " + cores + ",";
            if (frequency <= 0) errorMessage += " frequency: " + frequency + ".";
            throw new IllegalArgumentException(errorMessage);
        }
    }

    public int getCores() {
        return cores;
    }

    public int getFrequency() {
        return frequency;
    }

    public Prefix getUnits() {
        return units;
    }

    public String toString() {
        return "CPU: " + cores + " x " + frequency + " " + units + "Hz.";
    }
}
