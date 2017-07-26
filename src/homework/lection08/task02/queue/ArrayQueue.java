package homework.lection08.task02.queue;

import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Created by Anton on 18.07.2017.
 */
public class ArrayQueue<E> implements Queue<E> {

    private E[] elems;
    private int head;
    private int tail;

    public ArrayQueue() {
        head = 0;
        tail = 0;
        elems = (E[]) new Object[8];
    }

    public ArrayQueue(int initialCapacity) {
        if (initialCapacity > 0) {
            head = 0;
            tail = 0;
            elems = (E[]) new Object[initialCapacity];
        }
        else
            throw new IllegalArgumentException("Initial capacity should has a positive value.");
    }

    @Override
    public void offer(E e) {
        grow();
        if (elems.length != Integer.MAX_VALUE)
            elems[tail++] = e;
        else
            throw new OutOfMemoryError("Queue size can't be more than Integer.MAX_VALUE.");
    }

    @Override
    public E remove() {
        if (!isEmpty()) {
            trim();
            return elems[head++];
        }
        else
            throw new NoSuchElementException("Queue is empty");
    }

    @Override
    public E poll() {
        if (!isEmpty()) {
            trim();
            return elems[head++];
        }
        else
            return null;
    }

    @Override
    public E element() {
        if (!isEmpty())
            return elems[head];
        else
            throw new NoSuchElementException("Queue is empty.");
    }

    @Override
    public E peek() {
        if (!isEmpty())
            return elems[head];
        else
            return null;
    }

    @Override
    public int size() {
        return tail - head;
    }

    @Override
    public boolean isEmpty() {
        return tail == head;
    }

    @Override
    public boolean contains(E elem) {
        for (E currentElem : elems)
            if (elem.equals(currentElem))
                return true;
        return false;
    }

    @Override
    public Iterator<E> iterator() {
        return new ArrayQueueIterator();
    }

    private void trim() {
        if (size() == elems.length >> 2) {
            E[] temp = (E[])new Object[elems.length << 1];
            System.arraycopy(elems, head, temp, 0, size());
            elems = temp;
            tail = tail - head;
            head = 0;
        }
    }

    private void grow() {
        if (tail == elems.length) {
            int newLength = (Integer.MAX_VALUE - size() > Integer.MAX_VALUE >> 1 ?
                    (size() == 0 ? 8 : size() << 1) : Integer.MAX_VALUE);
            E[] temp = (E[])new Object[newLength];
            System.arraycopy(elems, head, temp, 0, size());
            elems = temp;
            tail = tail - head;
            head = 0;
        }
    }

    private class ArrayQueueIterator implements Iterator<E> {

        private int currentPosition;

        private ArrayQueueIterator() {
            this.currentPosition = head;
        }

        public boolean hasNext() {
            return currentPosition != tail;
        }

        public E next() {
            return elems[currentPosition++];
        }
    }
}
