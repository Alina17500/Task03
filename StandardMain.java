package ru.vsu.cs.volobueva;

import java.util.Scanner;
import java.util.concurrent.LinkedBlockingQueue;

public class StandardMain {
    public static void standardMain() {
        LinkedBlockingQueue<Integer> queue= new LinkedBlockingQueue<>();
        addQueueItems(queue);
        queue = transformQueue(queue);
        printResult(queue);
    }

    private static int enterIntValue() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }

    private static void addQueueItems(LinkedBlockingQueue<Integer> list) {
        System.out.print("Enter the number of items in the queue: ");
        int size = enterIntValue();

        for (int i = 0; i < size; i++) {
            System.out.println("Add an item to the queue: ");
            list.add(enterIntValue());
        }
    }

    public static LinkedBlockingQueue<Integer> transformQueue(LinkedBlockingQueue<Integer> list) {
        int size = list.size();
        LinkedBlockingQueue<Integer> result = new LinkedBlockingQueue<>();

        for (int i = 0; i < size; i++) {
            Integer element = list.remove();
            if (element % 2 == 0) {
                result.add(element);
            }
        }
        return result;
    }

    private static void printResult(LinkedBlockingQueue<Integer> result) {
        int size = result.size();
        System.out.println("The resulting queue: ");

        for (int i = 0; i < size; i++) {
            System.out.print(result.remove() + " ");
        }
        System.out.println();
    }
}
