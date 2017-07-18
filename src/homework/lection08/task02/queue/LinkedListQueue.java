package homework.lection08.task02.queue;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.NoSuchElementException;

/**
 * Created by Anton on 18.07.2017.
 */
public class LinkedListQueue<E> implements Queue<E> {

    private LinkedList<E> body;

    public LinkedListQueue() {
        body = new LinkedList<>();
    }

    @Override
    public void offer(E e) {
        if (body.size() != Integer.MAX_VALUE)
            body.offer(e);
        else
            throw new OutOfMemoryError("Queue size can't be more than Integer.MAX_VALUE.");
    }

    @Override
    public E remove() {
        try {
            return body.remove();
        } catch (NoSuchElementException exc) {
            throw new NoSuchElementException("Queue is empty");
        }
    }

    @Override
    public E poll() {
        return body.poll();
    }

    @Override
    public E element() {
        try {
            return body.element();
        } catch (NoSuchElementException exc) {
            throw new NoSuchElementException("Queue is empty");
        }
    }

    @Override
    public E peek() {
        return body.peek();
    }

    @Override
    public int size() {
        return body.size();
    }

    @Override
    public boolean isEmpty() {
        return body.isEmpty();
    }

    @Override
    public boolean contains(E elem) {
        return body.contains(elem);
    }

    @Override
    public Iterator<E> iterator() {
        return body.iterator();
    }
}