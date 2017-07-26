package homework.lection08.task02.queue;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Created by Anton on 18.07.2017.
 */
public class LinkedQueue<E> implements Queue<E> {

    private Node<E> head;
    private Node<E> tail;
    private int size;

    public LinkedQueue() {
        head = null;
        tail = null;
        size = 0;
    }

    @Override
    public void offer(E e) {
        if (size != Integer.MAX_VALUE) {
            Node<E> temp = tail;
            tail = new Node(e,null);
            if (head == null)
                head = tail;
            else
                temp.nextNode = tail;
            size++;
        }
        else
            throw new OutOfMemoryError("Queue size can't be more than Integer.MAX_VALUE.");
    }

    @Override
    public E remove() {
        if (!isEmpty()) {
            E elem = head.value;
            head = head.nextNode;
            size--;
            return elem;
        }
        else
            throw new NoSuchElementException("Queue is empty");
    }

    @Override
    public E poll() {
        if (!isEmpty()) {
            E elem = head.value;
            head = head.nextNode;
            size--;
            return elem;
        }
        else
            return null;
    }

    @Override
    public E element() {
        if (!isEmpty())
            return head.value;
        else
            throw new NoSuchElementException("Queue is empty.");
    }

    @Override
    public E peek() {
        if (!isEmpty())
            return head.value;
        else
            return null;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean contains(E elem) {
        Iterator linkedQueueIterator = iterator();
        while (linkedQueueIterator.hasNext())
            if (elem.equals(linkedQueueIterator.next()))
                return true;
        return false;
    }

    @Override
    public Iterator<E> iterator() {
        return new LinkedQueueIterator();
    }

    private static class Node<E> {
        private E value;
        private Node<E> nextNode;

        Node(E value, Node<E> nextNode) {
            this.value = value;
            this.nextNode = nextNode;
        }
    }

    private class LinkedQueueIterator implements Iterator<E> {

        private Node<E> currentNode;

        public LinkedQueueIterator() {
            this.currentNode = new Node(null, head);
        }

        public boolean hasNext() {
            return currentNode.nextNode != null;
        }

        public E next() {
            currentNode = currentNode.nextNode;
            return currentNode.value;
        }
    }
}
