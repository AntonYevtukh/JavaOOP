package homework.lection08.task02.stack;

import java.util.*;

/**
 * Created by Anton on 18.07.2017.
 */
public class LinkedListStack<E> implements Stack<E> {

    private LinkedList<E> body;

    public LinkedListStack() {
        body = new LinkedList<>();
    }

    public void push(E elem) {
        if (Integer.MAX_VALUE == body.size())
            throw new OutOfMemoryError("Stack size can't be more than Integer.MAX_VALUE.");
        body.push(elem);
    }

    public E pop() {
        try {
            return body.pop();
        }
        catch (NoSuchElementException exc) {
            throw new NoSuchElementException("Stack is empty.");
        }
    }

    public E peek() {
        try {
            return body.peek();
        }
        catch (NoSuchElementException exc) {
            throw new NoSuchElementException("Stack is empty.");
        }
    }

    public int size() {
        return body.size();
    }

    public boolean isEmpty() {
        return body.isEmpty();
    }

    public Iterator<E> iterator() {
        return body.iterator();
    }

    private class LinkedListStackIterator implements Iterator<E> {

        private ListIterator<E> reversedIterator;

        private LinkedListStackIterator() {
            reversedIterator = body.listIterator(body.size());
        }

        public boolean hasNext() {
            return reversedIterator.hasPrevious();
        }

        public E next() {
            return reversedIterator.previous();
        }
    }
}
