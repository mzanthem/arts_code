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
public class MyLinkedQueue {

	
	private Node head;
	private Node tail;
	
	private int size;
	
	
	public MyLinkedQueue() {
		
	}
	
	
	/**
	 * 入队  队尾
	 * @param data
	 */
	public void add(int data) {
		Node insertedNode = new Node(data);
		// 空
		if (size == 0) {
			head = tail = insertedNode;
		} else {
			// 插入尾部
			tail.next = insertedNode;
			tail = insertedNode;
		}
		size++;
		
	}
	
	/**
	 * 出队 队首
	 * @return
	 */
	public int remove() {
		if (size == 0) {
			throw new RuntimeException("queue is Empty!");
		}
		
		Node removed = head;
		// head右移
		head = head.next;
		size--;
		
		return removed.data;
	}
	
	public void output() {
		System.out.print("LinkedQueue[ ");
		
		Node temp = head;
		while (temp != null) {
			System.out.print(temp.data + " ");
			temp = temp.next;
		}
		
		System.out.print("] Size:" + size);
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
		MyLinkedQueue queue = new MyLinkedQueue();
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
