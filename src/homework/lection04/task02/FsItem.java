package homework.lection04.task02;

import java.util.List;

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

    protected abstract boolean checkEntry(Directory target); //объявлене костыля раз
    protected abstract List<FsItem> getContent(); //объявление костыля два

    public abstract int getSize();
    public abstract String toString(int depth);
}
