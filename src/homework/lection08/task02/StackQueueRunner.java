package homework.lection08.task02;

import homework.lection08.task02.queue.ArrayQueue;
import homework.lection08.task02.queue.LinkedListQueue;
import homework.lection08.task02.queue.LinkedQueue;
import homework.lection08.task02.queue.Queue;
import homework.lection08.task02.stack.ArrayStack;
import homework.lection08.task02.stack.LinkedListStack;
import homework.lection08.task02.stack.LinkedStack;
import homework.lection08.task02.stack.Stack;

import java.time.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by Anton on 18.07.2017.
 */
public class StackQueueRunner {

    private final static int ADD_FIRST = 16;
    private final static int REMOVE = 8;
    private final static int ADD_SECOND = 4;
    private final static int TOTAL = ADD_FIRST + ADD_SECOND;
    private final static int COUNT_TO_BENCH = 500_000;
    private final static String SEPARATOR = "-------------------------------------------";

    public static void main(String[] args) {

        stackDemo();
        queueDemo();
        speedUp();
        stackBenchmark();
        queueBenchmark();
    }

    private static void stackDemo() {

        List<Stack<Integer>> stacks = new ArrayList<>();
        stacks.add(new ArrayStack<>(1));
        stacks.add(new LinkedStack<>());
        stacks.add(new LinkedListStack<>());

        System.out.println("\nStack demo:\n" + SEPARATOR);

        for(Stack<Integer> stack : stacks) {
            System.out.println("\n" + stack.getClass().getSimpleName() + " demo:\n" + SEPARATOR);

            System.out.println("Pushing " + ADD_FIRST + " elements to " + stack.getClass().getSimpleName() + ":\n");
            for (int i = 1; i <= ADD_FIRST; i++) {
                stack.push(i);
                System.out.printf("%2d has been pushed to stack;\n", i);
            }

            System.out.println("\nPopping " + REMOVE + " elements from " + stack.getClass().getSimpleName() + ":\n");
            for (int i = 1; i <= REMOVE; i++) {
                System.out.printf("%2d has been popped from stack;\n", stack.pop());
            }

            System.out.println("\nPushing next " + ADD_SECOND + " elements to " + stack.getClass().getSimpleName() + ":\n");
            for (int i = ADD_FIRST + 1; i <= TOTAL; i++) {
                stack.push(i);
                System.out.printf("%2d has been pushed to stack;\n", i);
            }

            System.out.println("\nGetting " + stack.getClass().getSimpleName() + " content in order \n" +
                    "from top to bottom using iterator:\n");

            Iterator<Integer> stackIterator = stack.iterator();
            while (stackIterator.hasNext())
                System.out.printf("%2d is returned by iterator;\n", stackIterator.next());

            System.out.println(SEPARATOR);
        }
    }

    private static void queueDemo() {

        List<Queue<Integer>> queues = new ArrayList<>();
        queues.add(new ArrayQueue<>(1));
        queues.add(new LinkedQueue<>());
        queues.add(new LinkedListQueue<>());

        System.out.println("\nQueue demo:\n" + SEPARATOR);

        for(Queue<Integer> queue : queues) {
            System.out.println("\n" + queue.getClass().getSimpleName() + " demo:\n" + SEPARATOR);

            System.out.println("Offering " + ADD_FIRST + " elements to " + queue.getClass().getSimpleName() + ":\n");
            for (int i = 1; i <= ADD_FIRST; i++) {
                queue.offer(i);
                System.out.printf("%2d has been offered to queue;\n", i);
            }

            System.out.println("\nPolling " + REMOVE + " elements from " + queue.getClass().getSimpleName() + ":\n");
            for (int i = 1; i <= REMOVE; i++) {
                System.out.printf("%2d has been polled from queue;\n", queue.poll());
            }

            System.out.println("\nOffering next " + ADD_SECOND + " elements to " + queue.getClass().getSimpleName() + ":\n");
            for (int i = ADD_FIRST + 1; i <= TOTAL; i++) {
                queue.offer(i);
                System.out.printf("%2d has been offered to queue;\n", i);
            }

            System.out.println("\nGetting " + queue.getClass().getSimpleName() + " content in order \n" +
                    "from head to tail using iterator:\n");

            Iterator<Integer> queueIterator = queue.iterator();
            while (queueIterator.hasNext())
                System.out.printf("%2d is returned by iterator;\n", queueIterator.next());

            System.out.println("\nResult of queue.contains(4) is " + queue.contains(4));
            System.out.println("Result of queue.contains(16) is " + queue.contains(16));

            System.out.println(SEPARATOR);
        }
    }

    private static void stackBenchmark() {
        System.gc();

        LocalDateTime start;
        LocalDateTime end;
        Duration duration;

        List<Stack<Object>> stacks = new ArrayList<>();
        stacks.add(new ArrayStack<>(1));
        stacks.add(new LinkedStack<>());
        stacks.add(new LinkedListStack<>());

        System.out.println("\nStacks benchmark:\n" + SEPARATOR);
        printSystemInfo();

        for (int mod = 0; mod <= 4; mod += 2) {
            int currentCount = COUNT_TO_BENCH << mod;
            System.out.print("Pushing " + currentCount + " objects to stack:\n");
            System.out.println(SEPARATOR);
            for (Stack<Object> stack : stacks) {
                start = LocalDateTime.now();

                for (int i = 0; i < currentCount; i++) {
                    stack.push(new Object());
                }

                end = LocalDateTime.now();

                duration = Duration.between(start, end);
                System.out.println(duration.getSeconds() + ":" + duration.getNano() / 1_000_000 + " for "
                        + stack.getClass().getSimpleName());
            }
            System.out.println(SEPARATOR);

            System.out.print("Popping " + currentCount + " objects from stack:\n");
            System.out.println(SEPARATOR);
            for (Stack<Object> stack : stacks) {
                start = LocalDateTime.now();

                for (int i = 0; i < currentCount; i++) {
                    stack.pop();
                }

                end = LocalDateTime.now();

                duration = Duration.between(start, end);
                System.out.println(duration.getSeconds() + ":" + duration.getNano() / 1_000_000 + " for "
                        + stack.getClass().getSimpleName());
            }
            System.out.println(SEPARATOR);
        }
    }

    private static void queueBenchmark() {
        System.gc();

        LocalDateTime start;
        LocalDateTime end;
        Duration duration;

        List<Queue<Object>> queues = new ArrayList<>();
        queues.add(new ArrayQueue<>(1));
        queues.add(new LinkedQueue<>());
        queues.add(new LinkedListQueue<>());

        System.out.println("\nQueues benchmark:\n" + SEPARATOR);
        printSystemInfo();

        for (int mod = 0; mod <= 4; mod += 2) {
            int currentCount = COUNT_TO_BENCH << mod;
            System.out.print("Offering " + currentCount + " objects to queue:\n");
            System.out.println(SEPARATOR);
            for (Queue<Object> queue : queues) {
                start = LocalDateTime.now();

                for (int i = 0; i < currentCount; i++) {
                    queue.offer(new Object());
                }

                end = LocalDateTime.now();

                duration = Duration.between(start, end);
                System.out.println(duration.getSeconds() + ":" + duration.getNano() / 1_000_000 + " for "
                        + queue.getClass().getSimpleName());
            }
            System.out.println(SEPARATOR);

            System.out.print("Polling " + currentCount + " objects from queue:\n");
            System.out.println(SEPARATOR);
            for (Queue<Object> queue : queues) {
                start = LocalDateTime.now();

                for (int i = 0; i < currentCount; i++) {
                    queue.poll();
                }

                end = LocalDateTime.now();

                duration = Duration.between(start, end);
                System.out.println(duration.getSeconds() + ":" + duration.getNano() / 1_000_000 + " for "
                        + queue.getClass().getSimpleName());
            }
            System.out.println(SEPARATOR);
        }
    }

    private static void speedUp() {

        System.out.println("\nPreparing for benchmark:");
        System.out.println(SEPARATOR);
        System.out.println("Speeding Up...");
        ArrayList<Object> objectList = new ArrayList<>();
        int j = 1;
        for (int i = 0; i < COUNT_TO_BENCH << 6; i++) {
            objectList.add(new Object());
            if (i % (COUNT_TO_BENCH << 2) == 0) {
                System.out.printf("\r%.0f%s done...", 6.25 * j, "%");
                j++;
            }
        }
        System.out.println("\nDone.");
        System.out.println(SEPARATOR);
    }

    private static void printSystemInfo() {

        System.out.println("\nSystem info:");
        System.out.println(SEPARATOR);
        System.out.printf("%-24s: %s\n", "OS name", System.getProperty("os.name"));
        System.out.printf("%-24s: %s\n","OS architecture", System.getProperty("os.arch"));
        System.out.printf("%-24s: %s\n", "OS version", System.getProperty("os.version"));
        System.out.printf("%-24s: %s\n", "CPU identifier", System.getenv("PROCESSOR_IDENTIFIER"));
        System.out.printf("%-24s: %s\n", "CPU architecture", System.getenv("PROCESSOR_ARCHITECTURE"));
        System.out.printf("%-24s: %s\n", "Number of CPU threads", System.getenv("NUMBER_OF_PROCESSORS"));
        System.out.printf("%-24s: %s\n", "Free memory (MB)", (Runtime.getRuntime().freeMemory() >> 20));
        System.out.printf("%-24s: %s\n", "Maximum memory (MB)", (Runtime.getRuntime().maxMemory() >> 20));
        System.out.printf("%-24s: %s\n", "Total memory (MB)", (Runtime.getRuntime().totalMemory() >> 20));
        System.out.println(SEPARATOR);
        System.out.println();

    }
}
