package com.treeStructures;

// implementation of min heap using array
public class MinHeap {
	
	static int[] arrMinHeap=new int[30];
	static int index=0;
	
	// insert into min heap
	public static void insertInto(int data) {
		// if first data or data less than last array value, insert at the index and increment index
		if(index==0 || arrMinHeap[returnParent(index)]<data) {
			arrMinHeap[index++]=data;
		}
		// insert at index and swap with parent if needed	
		else {
			arrMinHeap[index++]=data;
			int toCh=index-1;
			while(arrMinHeap[toCh] < arrMinHeap[returnParent(toCh)]){
				swap(toCh,returnParent(toCh));
				toCh=returnParent(toCh);
			}
		}
	}
	
	// delete root value
	public static void deleteRoot() {
		if(index==0)
			System.out.println("No value to delete");
		else if(index==1)
			index--;
		// swap last value with root and heapify the array
		else {
			swap(0,--index);
			minheapify(0);
		}
	}
	
	// children should be greater than parent
	public static void minheapify(int i) {
		int left=(i*2)+1;
		int right=(i*2)+2;
		int smallest=i;
		if(right<index && arrMinHeap[right]<arrMinHeap[smallest])
			smallest=right;
		if(left<index &&  arrMinHeap[left]<arrMinHeap[smallest])
			smallest=left;
		if(smallest!=i) {
			swap(i,smallest);
			minheapify(smallest);
		}
	}
	
	public static void swap(int i,int j) {
		int temp=arrMinHeap[i];
		arrMinHeap[i]=arrMinHeap[j];
		arrMinHeap[j]=temp;
	}
	
	public static int returnParent(int inde) {
		return (inde-1)/2;
		
	}
	
	public static void inOrder() {
		for(int i=0;i<index;i++)
			System.out.print(" "+arrMinHeap[i]);
	}
	
	public static void main(String[] args) {
		insertInto(7);
		insertInto(9);
		insertInto(70);
		insertInto(11);
		insertInto(20);
		insertInto(30);
		insertInto(31);
		insertInto(3);
		inOrder();
		deleteRoot();
		System.out.println("\n");
		inOrder();
	}

}
