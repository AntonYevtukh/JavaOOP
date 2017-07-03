package homework.lection03.task03;

public class Ram {

    private int size;
    private Prefix units;
    private String type;

    public Ram(int size, Prefix units, String type) {
        if (size > 0) {
            this.size = size;
            this.units = units;
            this.type = type;
        }
        else throw new IllegalArgumentException("Invalid non-positive parameter for RAM: size" + size + ";");
    }

    public int getSize() {
        return size;
    }

    public Prefix getUnits() {
        return units;
    }

    public String getType() {
        return type;
    }

    public String toString() {
        return "RAM: " + type + " " + size + " " + units + "B.";
    }
}
