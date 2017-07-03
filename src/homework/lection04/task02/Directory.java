package homework.lection04.task02;

import java.util.ArrayList;
import java.util.List;

public class Directory extends FsItem{

    private List<FsItem> content = new ArrayList<>();

    public Directory(String name, FsItem... items) {
        super(name);
        for (FsItem item : items) {
            if ((item instanceof Directory) && ((Directory)item).checkEntry(this))
                System.out.println("Can't add directory " + item.getName() + " to directory " + name);
            else
                content.add(item);
        }
    }

    public int getSize() {
        int result = 0;
        for (FsItem item : content)
            result += item.getSize();
        return result;
    }

    public Directory add(FsItem... items) {
        for (FsItem item : items) {
            if ((item instanceof Directory) && ((Directory)item).checkEntry(this))
                System.out.println("Can't add directory " + item.getName() + " to directory " + name);
            else
                content.add(item);
        }
        return this;
    }

    private boolean checkEntry(Directory target) {
        if (target == this)
            return true;
        for (FsItem item : content)
            if ((item instanceof Directory) && ((Directory)item).checkEntry(target))
                return true;
        return false;
    }

    public String toString(int depth) {
        StringBuilder result = new StringBuilder("");
        for (int i = 1; i < depth; i++) {
            result.append("|   ");
        }
        result.append("|---" + name + " (" + getSize() + ")");
        for (FsItem item : content)
            result.append(item.toString(depth + 1));
        for (int i = 1; i < depth; i++)
            result.append("|   ");
        result.append("\n");
        return result.toString();
    }

    public String toString() {
        return toString(0);
    }
}
