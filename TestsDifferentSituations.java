package ru.vsu.cs.volobueva;

import org.junit.Assert;
import org.junit.Test;

import java.util.concurrent.LinkedBlockingQueue;

public class TestsDifferentSituations {
    @Test
    public void testWithMyQueue() throws Exception {
        MyLinkedListQueue<Integer> listQueue = new MyLinkedListQueue<>();
        listQueue.addElement(0);
        listQueue.addElement(1);
        listQueue.addElement(2);
        listQueue.addElement(3);
        listQueue.addElement(4);
        listQueue.addElement(5);

        String[] queueForTest = toStringForMyQueue(Main.transformQueue(listQueue));

        MyLinkedListQueue<Integer> queue = new MyLinkedListQueue<>();
        queue.addElement(0);
        queue.addElement(2);
        queue.addElement(4);

        String[] trueQueue = toStringForMyQueue(queue);

        Assert.assertArrayEquals(trueQueue, queueForTest);
    }

    @Test
    public void testWithStandardQueue() {
        LinkedBlockingQueue<Integer> listQueue = new LinkedBlockingQueue<>();
        listQueue.add(1);
        listQueue.add(2);
        listQueue.add(3);
        listQueue.add(4);
        listQueue.add(5);
        listQueue.add(6);

        String[] queueForTest = toStringForStandardQueue(StandardMain.transformQueue(listQueue));

        LinkedBlockingQueue<Integer> queue = new LinkedBlockingQueue<>();
        queue.add(2);
        queue.add(4);
        queue.add(6);

        String[] trueQueue = toStringForStandardQueue(queue);

        Assert.assertArrayEquals(trueQueue, queueForTest);
    }

    @Test
    public void testWithoutEvenNumbers() throws Exception {
        MyLinkedListQueue<Integer> listQueue = new MyLinkedListQueue<>();
        listQueue.addElement(1);
        listQueue.addElement(25);
        listQueue.addElement(33);
        listQueue.addElement(97);
        listQueue.addElement(15);
        listQueue.addElement(61);

        String[] queueForTest = toStringForMyQueue(Main.transformQueue(listQueue));

        MyLinkedListQueue<Integer> queue = new MyLinkedListQueue<>();
        String[] trueQueue = toStringForMyQueue(queue);

        Assert.assertArrayEquals(trueQueue, queueForTest);
    }

    @Test
    public void testOnlyWithEvenNumbers() {
        LinkedBlockingQueue<Integer> listQueue = new LinkedBlockingQueue<>();
        listQueue.add(4);
        listQueue.add(300);
        listQueue.add(74);
        listQueue.add(26);

        String[] queueForTest = toStringForStandardQueue(StandardMain.transformQueue(listQueue));

        LinkedBlockingQueue<Integer> queue = new LinkedBlockingQueue<>();
        queue.add(4);
        queue.add(300);
        queue.add(74);
        queue.add(26);

        String[] trueQueue = toStringForStandardQueue(queue);

        Assert.assertArrayEquals(trueQueue, queueForTest);
    }

    @Test
    public void testWithOnlyOneNumbers() throws Exception {
        MyLinkedListQueue<Integer> listQueue = new MyLinkedListQueue<>();
        listQueue.addElement(70);

        String[] queueForTest = toStringForMyQueue(Main.transformQueue(listQueue));

        MyLinkedListQueue<Integer> queue = new MyLinkedListQueue<>();
        queue.addElement(70);

        String[] trueQueue = toStringForMyQueue(queue);

        Assert.assertArrayEquals(trueQueue, queueForTest);
    }

    private static String[] toStringForMyQueue(MyLinkedListQueue<Integer> listQueue) throws Exception {
        int size = listQueue.count();
        String[] str = new String[size];

        for (int i = 0; i < size; i++) {
            str[i] = String.valueOf(listQueue.removeElement());
        }

        return str;
    }

    private static String[] toStringForStandardQueue(LinkedBlockingQueue<Integer> listQueue) {
        int size = listQueue.size();
        String[] str = new String[size];

        for (int i = 0; i < size; i++) {
            str[i] = String.valueOf(listQueue.remove());
        }
        return str;
    }
}
