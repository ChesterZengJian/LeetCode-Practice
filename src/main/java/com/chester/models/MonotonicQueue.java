package src.main.com.chester.models;

import java.util.LinkedList;

public class MonotonicQueue {
    private LinkedList<Integer> queue = new LinkedList<>();

    public void push(int num) {
        while (!queue.isEmpty() && queue.peekLast() < num) {
            queue.pollLast();
        }

        queue.addLast(num);
    }

    public int pop(int num) {
        if (!queue.isEmpty() && queue.getFirst() == num) {
            return queue.pop();
        }

        return num;
    }

    public int getMax() {
        return queue.peekFirst();
    }

    public void print() {
        while (!queue.isEmpty()) {
            System.out.println(queue.pop());
        }
    }
}
