package org.misspuzzle.datastructure;

public class MyCircularQueue {
    private final int[] queue;
    private final int k;

    private int front;
    private int end;

    public MyCircularQueue(int k) {
        this.k = k;
        queue = new int[k];
        front = -1;
        end = 0;
    }

    public boolean enQueue(int value) {
        if (isFull()) {
            return false;
        }

        front = front == -1 ? end : front;
        queue[end] = value;
        end = (end + 1) % k;

        return true;
    }

    public boolean deQueue() {
        if (isEmpty()) {
            return false;
        }

        front = (front + 1) % k;
        front = front == end ? -1 : front;

        return true;
    }

    public int Front() {
        return isEmpty() ? -1 : queue[front];
    }

    public int Rear() {
        return isEmpty() ? -1 : queue[(end + k - 1) % k];
    }

    public boolean isEmpty() {
        return front == -1;
    }

    public boolean isFull() {
        return front == end;
    }
}
