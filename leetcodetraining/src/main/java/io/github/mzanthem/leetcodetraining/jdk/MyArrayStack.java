package io.github.mzanthem.leetcodetraining.jdk;

/**
 * 通过数组实现stack
 * 先进后出
 */
public class MyArrayStack {

    private int[] array;
    private int size;

    public MyArrayStack(int capacity) {
        array = new int[capacity];
    }

    /**
     * 入栈--对尾
     * @param data
     */
    public void push(int data) {
        if (size >= array.length) {
            throw new IndexOutOfBoundsException();
        }
        array[size++] = data;

    }

    /**
     * 出栈--队尾
     * @return
     */
    public int pop() {

        if (size == 0) {
            throw new RuntimeException("stack is empty!");
        }
        int last = array[size--];
        return last;

    }


    private void output() {

        System.out.print("Stack[");
        for (int i=0; i< size; i++) {
            System.out.print(array[i]);
            if (i < size-1) {
                System.out.print(", ");
            } else {
                System.out.print("");
            }


        }
        System.out.print("]");
        System.out.print(" Size: " + size);
        System.out.println();

    }

    public static void main(String[] args) {
        MyArrayStack stack = new MyArrayStack(6);
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
