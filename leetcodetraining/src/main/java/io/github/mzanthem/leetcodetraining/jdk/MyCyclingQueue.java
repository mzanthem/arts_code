package io.github.mzanthem.leetcodetraining.jdk;

/**
 * 循环队列
 * （rear + 1）% length = rear
 */
public class MyCyclingQueue {

    private int[] array;
    private int front;
    private int rear;

    public MyCyclingQueue(int capacity) {
        this.array = new int[capacity + 1]; // 保留一个rear空节点
    }

    public void enQueue(int element)  {
        if ((rear + 1) % array.length == front) {
            throw new RuntimeException("queue is full");
        }
        array[rear] = element;
        rear = (rear +1) % array.length;
    }

    public int deQueue()  {
        if (rear == front) {
            throw new RuntimeException("queue is empty");
        }
        int e = array[front]; // 从头取
        front = (front + 1) % array.length;
        return e;
    }

    public void output() {
        System.out.print("[");
        for (int i = front; i != rear; i = (i + 1) % array.length) {
            System.out.print(" " + array[i]);
        }
        System.out.print("]");
        System.out.println();
    }

    public static void main(String[] args) {
        MyCyclingQueue queue = new MyCyclingQueue(6);
        queue.enQueue(1);
        queue.enQueue(2);
        queue.enQueue(3);
        queue.enQueue(4);
        queue.enQueue(5);
        queue.enQueue(6);
        queue.output();


        queue.deQueue();
        queue.deQueue();
        queue.output();

        queue.enQueue(7);
        queue.enQueue(8);
        queue.output();

    }

}
