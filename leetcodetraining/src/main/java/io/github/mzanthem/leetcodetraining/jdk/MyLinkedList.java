/*
* MyLinkedList.java Created On 2019年12月18日
* Copyright(c) 2019 Mazan Inc.
* ALL Rights Reserved.
*/
package io.github.mzanthem.leetcodetraining.jdk;
/**
* MyLinkedList
* 查找-更新: O(n)
* 插入-删除: O(1)
* @time: 下午2:36:33
* @author mazan
*/
public class MyLinkedList {
	// h
	private Node head;
	// t
	private Node tail;
	// size
	private int size;
	
	// 插入最后
	public void add(int data) throws Exception {
		this.insert(data, size);
	}
	/**
	 * 插入
	 * @param data
	 * @param index
	 * @throws Exception
	 */
	public void insert(int data, int index) throws Exception {
		if (index < 0 || index > size) {
			throw new IndexOutOfBoundsException();
		}
		Node insertedNode = new Node(data);
		
		if (size == 0) {
			//  插入头
			head = tail = insertedNode;
		} else if (size == index) {
			// 插入尾部
			tail.next = insertedNode; // 原尾部的next指向新元素
			tail = insertedNode;	// 尾部右移
		} else {
			// 插入中间
			Node prevNode = get(index - 1);
			Node nextNode = prevNode.next;
			
			prevNode.next = insertedNode; 
			insertedNode.next = nextNode;
			
		}
		size++;
	}
	
	public Node remove(int index) throws Exception {
		if (index < 0 || index > size) {
			throw new IndexOutOfBoundsException();
		}
		
		Node removedNode = null;
		if (index == 0) {
			// 删除头节点
			removedNode = head;
			head = head.next; // 头节点右移
		} else if (index == size-1) {
			// 删除尾节点
			Node prevNode = get(index - 1);
			
			removedNode = prevNode.next;
			
			prevNode.next = null; // 置为null
			tail = prevNode; // 为节点左移
			
		} else {
			// 删除中间节点
			Node prevNode = get(index - 1);
			Node nextNode = prevNode.next.next;
			
			removedNode = prevNode.next; // 被删除的元素
			prevNode.next = nextNode; // 两边链接起来
		}
		size--;
		
		return removedNode;
	}
	
	
	
	/**
	 * 获取指定节点的元素
	 * @param i
	 * @return
	 */
	public Node get(int index) {
		if (index <0 || index > size) {
			throw new IndexOutOfBoundsException();  
		}
		Node temp = head;
		for (int i = 0; i< index; i++) {
			temp = temp.next;
		}
		
		return temp;
	}

	public void output() {
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
	
	public static void main(String[] args) throws Exception {
		MyLinkedList linkedList = new MyLinkedList();
		linkedList.output();
		
		linkedList.add(1);
		linkedList.add(2);
		linkedList.add(3);
		linkedList.output();
		
		linkedList.insert(5, 1);
		linkedList.insert(6, 2);
		linkedList.output();
		
		linkedList.remove(2); // 第三个 ==6
		linkedList.output();
		
		linkedList.remove(3); //  第4个 3
		linkedList.output();
	}

}


