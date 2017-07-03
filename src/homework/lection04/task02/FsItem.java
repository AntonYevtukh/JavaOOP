package homework.lection04.task02;

public abstract class FsItem {

    protected String name;

    public FsItem(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName() {
        this.name = name;
    }

    public abstract int getSize();

    public abstract String toString(int depth);
}
