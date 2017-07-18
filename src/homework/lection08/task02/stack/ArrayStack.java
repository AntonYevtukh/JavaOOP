package homework.lection08.task02.stack;

import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Created by Anton on 18.07.2017.
 */
public class ArrayStack<E> implements Stack<E> {

    private E[] elems;
    private int size;

    public ArrayStack() {
        size = 0;
        elems = (E[]) new Object[8];
    }

    public ArrayStack(int initialCapacity) {
        if (initialCapacity > 0) {
            size = 0;
            elems = (E[]) new Object[initialCapacity];
        }
        else
            throw new IllegalArgumentException("Initial capacity should has a positive value.");
    }

    public void push(E elem) {
        if (Integer.MAX_VALUE == size)
            throw new OutOfMemoryError("Stack size can't be more than Integer.MAX_VALUE.");
        grow();
        elems[size++] = elem;
    }

    public E pop() {
        if (size != 0) {
            trim();
            return elems[--size];
        }
        else
            throw new NoSuchElementException("Stack is empty.");
    }

    public E peek() {
        if (size != 0) {
            return elems[size - 1];
        }
        else
            throw new NoSuchElementException("Stack is empty.");
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public Iterator<E> iterator() {
        return new ArrayStackIterator();
    }

    private void trim() {
        if (size == elems.length >> 2)
            elems = Arrays.copyOf(elems, elems.length >> 1);
    }

    private void grow() {
        if (size == elems.length) {
            if (Integer.MAX_VALUE - size > Integer.MAX_VALUE >> 1)
                elems = Arrays.copyOf(elems, elems.length << 1);
            else
                elems = Arrays.copyOf(elems, Integer.MAX_VALUE);
        }
    }

    private class ArrayStackIterator implements Iterator<E> {

        private int currentPosition;

        private ArrayStackIterator() {
            currentPosition = size;
        }

        public boolean hasNext() {
            return currentPosition > 0;
        }

        public E next() {
            return elems[--currentPosition];
        }
    }
}
