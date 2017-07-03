package homework.lection04.task02;

import java.util.List;

public class File extends FsItem {

    private int size;

    public File(String name, int size) {
        super(name);
        this.size = size;
    }

    //реализация костыля раз
    protected final boolean checkEntry(Directory target) {
        return false;
    }

    //реализация костыля два
    protected List<FsItem> getContent() {
        return null;
    }

    public int getSize() {
        return size;
    }

    public String toString(int depth) {
        StringBuilder result = new StringBuilder("");
        for (int i = 1; i < depth; i++) {
            result.append("|   ");
        }
        result.append("|---" + name + " (" + size + ")\n");
        return result.toString();
    }

    public String toString() {
        return toString(0);
    }
}
