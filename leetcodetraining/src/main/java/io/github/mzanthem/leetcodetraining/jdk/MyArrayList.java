/*
* MyArrayList.java Created On 2019年12月18日
* Copyright(c) 2019 Mazan Inc.
* ALL Rights Reserved.
*/
package io.github.mzanthem.leetcodetraining.jdk;
/**
* MyArrayList
* 查找-更新: O(1)
* 插入-删除: O(n)
* @time: 下午2:02:53
* @author mazan
*/
public class MyArrayList {

	private int[] array;
	private int size;
	
	
	public MyArrayList(int capacity) {
		this.array = new int[capacity];
		this.size = 0;
	}
	
	// 添加元素到最后面
	public void add(int element) {
		if (size >= array.length) {
			resize();
		}
		array[size++] = element;
		
	}
	
	public void insert(int element, int index) throws Exception {
		
		if (index <0 || index >size) {
			throw new IndexOutOfBoundsException("超出数组范围");
		}
		if (size >= array.length) {
			resize();
		}
		// 从尾向头循环，将元素逐个右移
		for (int i = size -1; i>= index; i--) {
			array[i+1] = array[i];
		}
		array[index] = element;
		size++;
		
	}
	
	/**
	 * 扩容
	 */
	private void resize() {
		int[] arrayNew = new int[array.length * 2];
		System.arraycopy(array, 0, arrayNew, 0, array.length);
		array = arrayNew;
	}
	
	
	public int delete(int index) throws Exception {
		if (index < 0 || index >= size) {
			throw new IndexOutOfBoundsException();
		}
		
		int deletedElement = array[index];
		// 从左向右循环，将元素迁移
		for(int i = index; i < size-1; i++) {
			array[i] = array[i+1];
		}
		size--;
		return deletedElement;
		
	}
	
	
	
	public void output() {
		System.out.print("List[");
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
	
	
	public static void main(String[] args) throws Exception {
		MyArrayList list = new MyArrayList(3);
		list.output();
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(4);
		list.output();
		
		list.insert(5, 3); // index=3(array[3]) 
		list.output();
		
		list.delete(3); // delete array[3]
		list.output();
	}
	
	
}
