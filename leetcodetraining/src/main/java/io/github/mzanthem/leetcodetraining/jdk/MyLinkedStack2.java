package io.github.mzanthem.leetcodetraining.jdk;

/**
 * 通过数组实现stack2
 * 从队首
 * 先进后出
 */
public class MyLinkedStack2 {

    private Node head;
    private Node tail;

    private int size;



    /**
     * 入栈--队首
     * @param data
     */
    public void push(int data) {
        Node e = new Node(data);
        if (size ==0) {
            head = tail = e;
        } else {
            // 插入队首
            e.next = head;
            head = e;  // head 左移
        }
        size++;
    }

    /**
     * 出栈--队首
     * @return
     */
    public int pop() {

        if (size == 0) {
            throw new RuntimeException("Stack is empty!");
        }
        Node removed = head;

        head = head.next; // head右移



        size--;

        return removed.data;
    }

    private Node get(int index) {

        if (index <0 || index > size) {
            throw new IndexOutOfBoundsException();
        }
        Node temp = head;
        for (int i = 0; i< index; i++) {
            temp = temp.next;
        }

        return temp;

    }


    private void output() {

        Node temp = head;
        System.out.print("LinkedList [");
        while(temp != null) {
            System.out.print(" " + temp.data);
            temp = temp.next;
        }
        System.out.print(" ] Size:" + size);
        System.out.println();

    }


    private static class Node {
        int data;
        Node next;
        Node(int data) {
            this.data = data;
        }
    }

    public static void main(String[] args) {
        MyLinkedStack2 stack = new MyLinkedStack2();
        stack.push(1);
        stack.push(2);
        stack.output();

        stack.push(3);
        stack.output();

        stack.push(4);
        stack.output();


        stack.pop();
        stack.output();

        stack.pop();
        stack.output();

        stack.pop();
        stack.output();

        stack.pop();
        stack.output();
    }

}
