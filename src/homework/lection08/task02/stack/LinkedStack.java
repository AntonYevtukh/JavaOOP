package homework.lection08.task02.stack;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Created by Anton on 18.07.2017.
 */
public class LinkedStack<E> implements Stack<E> {

    private Node<E> top;
    private int size;

    public LinkedStack() {
        top = null;
        size = 0;
    }

    public void push(E elem) {
        if (Integer.MAX_VALUE == size)
            throw new OutOfMemoryError("Stack size can't be more than Integer.MAX_VALUE.");
        top = new Node(elem, top);
        size++;
    }

    public E pop() {
        if (!isEmpty()) {
            E elem = top.value;
            top = top.prevNode;
            size--;
            return elem;
        }
        else
            throw new NoSuchElementException("Stack is empty.");
    }

    public E peek() {
        if (!isEmpty())
            return top.value;
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
        return new LinkedStackIterator();
    }

    private static class Node<E> {
        private final E value;
        private final Node<E> prevNode;

        Node(E value, Node<E> prevNode) {
            this.value = value;
            this.prevNode = prevNode;
        }
    }

    private class LinkedStackIterator implements Iterator<E> {

        Node<E> currentNode;

        private LinkedStackIterator() {
            this.currentNode = new Node<>(null, top);
        }

        public boolean hasNext() {
            return currentNode.prevNode != null;
        }

        public E next() {
            currentNode = currentNode.prevNode;
            return currentNode.value;
        }
    }
}
