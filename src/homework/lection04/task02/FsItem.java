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

    /**
     * Проверяет, не "содержится" ли директория target в вызывающем объекте или его подпапках. Если вызывающий объект - это
     * файл, просто возвращает false. Если папка - проверяет в ней и рекурсивно в ее содержимом. Возвращает true, если
     * папка target найдена. Мне кажется, что не очень хорошо, что данный метод (как и getContent)
     * есть и у файла, но иначе пришлось бы использовать instanceof.
     */
    protected abstract boolean checkEntry(Directory target); //объявлене костыля раз
    protected abstract List<FsItem> getContent(); //объявление костыля два

    public abstract int getSize();
    public abstract String toString(int depth);
}
