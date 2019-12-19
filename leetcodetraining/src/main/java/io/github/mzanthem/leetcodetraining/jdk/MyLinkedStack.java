package io.github.mzanthem.leetcodetraining.jdk;

/**
 * 通过数组实现stack1
 * 从队尾
 * 先进后出
 */
public class MyLinkedStack {

    private Node head;
    private Node tail;

    private int size;



    /**
     * 入栈--对尾
     * @param data
     */
    public void push(int data) {
        Node e = new Node(data);
        if (size ==0) {
            head = tail = e;
        } else {
            // 插入队尾
            tail.next = e;
            tail = e;
        }
        size++;
    }

    /**
     * 出栈--队尾
     * @return
     */
    public int pop() {

        if (size == 0) {
            throw new RuntimeException("Stack is empty!");
        }
        Node removed = null;
        if (size == 1) {
            // 只有一个元素
            removed = head;
        } else {
            // 大于等于 2个元素
            int tailIndex = size - 1; // 尾节点的“下标”
            Node prevNode = get(tailIndex - 1);
            removed = prevNode.next;

            prevNode.next = null; // 置为null,即断开与尾元素的链接

            tail = prevNode; // 重置tail
        }


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
        MyLinkedStack stack = new MyLinkedStack();
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
    }

}
