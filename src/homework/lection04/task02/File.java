package homework.lection04.task02;

import java.util.ArrayList;
import java.util.List;

public class File extends FsItem {

    private int size;

    public File(String name, int size) {
        super(name);
        this.size = size;
    }

    public List<FsItem> getContent() {
        return new ArrayList<>();
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
