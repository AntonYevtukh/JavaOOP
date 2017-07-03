package homework.lection04.task02;

import java.util.ArrayList;
import java.util.List;

public class Directory extends FsItem{

    private List<FsItem> content = new ArrayList<>();

    public Directory(String name, FsItem... items) {
        super(name);
        for (FsItem item : items) {
            if (item.checkEntry(this)) //костыли нужны, чтобы тут работало без instanceof
                System.out.println("Can't add directory " + item.getName() + " to directory " + name);
            else
                content.add(item);
        }
    }

    protected final boolean checkEntry(Directory target) {
        if (target == this)
            return true;
        for (FsItem item : content)
            if (item.checkEntry(target)) //и тут
                return true;
        return false;
    }

    protected final List<FsItem> getContent() {
        return content;
    }

    public int getSize() {
        int result = 0;
        for (FsItem item : content)
            result += item.getSize();
        return result;
    }

    public Directory add(FsItem... items) {
        for (FsItem item : items) {
            if (item.checkEntry(this)) //и тут
                System.out.println("Can't add directory " + item.getName() + " to directory " + name);
            else
                content.add(item);
        }
        return this;
    }

    public String toString(int depth) {
        StringBuilder result = new StringBuilder("");
        for (int i = 1; i < depth; i++) {
            result.append("|   ");
        }
        if (depth > 0)
            result.append("|---");
        result.append(name + " (" + getSize() + ")\n");
        for (FsItem item : content)
            result.append(item.toString(depth + 1));
        for (int i = 0; i < depth; i++)
            result.append("|   ");
        result.append("\n");
        return result.toString();
    }

    public String toString() {
        return toString(0);
    }
}
