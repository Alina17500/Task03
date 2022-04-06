package ru.vsu.cs.volobueva;

public class MyLinkedListQueue<T> implements SimpleQueue<T> {
    private class QueueNode {
        public T element;
        public QueueNode nextElement;

        public QueueNode(T element, QueueNode nextElement) {
            this.element = element;
            this.nextElement = nextElement;
        }

        public QueueNode(T element) {
            this(element, null);
        }
    }

    private QueueNode head = null;
    private QueueNode tail = null;
    private int count = 0;

    @Override
    public void addElement(T element) {
        if (count != 0) {
            tail.nextElement = new QueueNode(element);
            tail = tail.nextElement;
        } else {
            head = tail = new QueueNode(element);
        }

        count++;
    }

    @Override
    public int count() {
        return count;
    }

    @Override
    public boolean isEmpty() {
        return count() == 0;
    }

    @Override
    public T removeElement() throws Exception {
        T value = getElement();
        head = head.nextElement;

        if (count == 1) {
            tail = null;
        }

        count--;
        return value;
    }

    @Override
    public T getElement() throws Exception {
        if (count() == 0) {
            throw new Exception("This queue is empty!");
        }
        return head.element;
    }
}
