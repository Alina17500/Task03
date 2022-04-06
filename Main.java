package ru.vsu.cs.volobueva;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws Exception {
        System.out.println("Transform a queue implemented based on a linked list: ");

        MyLinkedListQueue<Integer> listQueue = new MyLinkedListQueue<>();
        addQueueItems(listQueue);
        listQueue = transformQueue(listQueue);
        printResult(listQueue);

        System.out.println("Transform a queue implemented using the standard Java language library: ");
        StandardMain.standardMain();
    }

    private static int enterIntValue() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }

    private static void addQueueItems(MyLinkedListQueue<Integer> list) {
        System.out.print("Enter the number of items in the queue: ");
        int size = enterIntValue();

        for (int i = 0; i < size; i++) {
            System.out.println("Add an item to the queue: ");
            list.addElement(enterIntValue());
        }
    }

    public static MyLinkedListQueue<Integer> transformQueue(MyLinkedListQueue<Integer> list) throws Exception {
        int size = list.count();
        MyLinkedListQueue<Integer> result = new MyLinkedListQueue<>();

        for (int i = 0; i < size; i++) {
            if (list.getElement() % 2 == 0) {
                result.addElement(list.removeElement());
            } else list.removeElement();
        }
        return result;
    }

    private static void printResult(MyLinkedListQueue<Integer> result) throws Exception {
        int size = result.count();
        System.out.println("The resulting queue: ");

        for (int i = 0; i < size; i++) {
            System.out.print(result.removeElement() + " ");
        }
        System.out.println();
    }
}
