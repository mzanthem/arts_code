/*
* MyQueue.java Created On 2019年12月18日
* Copyright(c) 2019 Mazan Inc.
* ALL Rights Reserved.
*/
package io.github.mzanthem.leetcodetraining.jdk;

/**
* MyQueue
*  （1）通过数组实现一个队列；
*  （2）通过集合实现一个对列；
*  （3）通过两个堆栈实现一个队列
* LIFO 队列
* @time: 下午3:52:17
* @author mazan
*/
public class MyArrayQueue {

	private int[] array;
	private int size;
	
	public MyArrayQueue(int capacity) {
		array = new int[capacity];
	}
	
	
	/**
	 * 入队
	 * @param data
	 */
	public void add(int data) {
		if (size >= array.length) {
			throw new IndexOutOfBoundsException();
		}
		// 添加到队尾
		array[size++] = data; 
		
	}
	
	/**
	 * 出队
	 * @return
	 */
	public int remove() {
		if (size == 0) {
			throw new RuntimeException("queue is Empty!");
		}
		
		int removed = array[0];
		for (int i = 0; i< size; i++) {
			array[i] = array[i+1]; // 队列向左移
		}
		size--;
		
		return removed;
	}
	
	public void output() {
		System.out.print("Queue[ ");
		
		for(int i = 0; i < size; i++) {
			System.out.print(array[i] + " ");
		}
		
		System.out.print("] Size:" + size);
		System.out.println();
	}
	
	public static void main(String[] args) {
		MyArrayQueue queue = new MyArrayQueue(10);
		queue.add(1);
		queue.add(2);
		queue.add(3);
		queue.output();
		
		
		queue.remove();
		queue.output();
		
		queue.add(4);
		queue.output();
		
		queue.remove();
		queue.output();
		
		queue.remove();
		queue.output();
		
		queue.remove();
		queue.output();
		
		
	}

}
