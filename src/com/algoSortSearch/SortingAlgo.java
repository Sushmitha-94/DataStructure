package com.algoSortSearch;

// implementation of all sorting algorithms
public class SortingAlgo {
	
	
	// Time complexity O(n^2)
	// Auxiliary Space O(1)
	// used when memory write is costly and small data
	public static void selectionSort(int[] arr) {
		int temp;
		int min;
		for(int i=0;i<arr.length;i++) {
			min=arr[i];
			temp=i;
			for(int j=i+1;j<arr.length;j++) {
				if(min>arr[j]) {
					min=arr[j];
					temp=j;
				}
			}			
			arr[temp]=arr[i];
			arr[i]=min;	
			System.out.print(arr[i]+" ");
		}
	}

	// Time Complexity O(n^2)
	// Auxiliary Space O(1)
	// small data
	// comparison-based sorting
	// stable
	// best case- already sorted
	public static void bubbleSort(int[] arr) {
		int n = arr.length;
        for (int i = 0; i < n-1; i++)
            for (int j = 0; j < n-i-1; j++)
                if (arr[j] > arr[j+1])
                {
                    // swap temp and arr[i]
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
	}
	
	// Time Complexity O(n^2)
	// Auxiliary Space O(1)
	// small data and almost sorted array
	// comparison-based sorting
	// stable
	// in-place
	// best case- already sorted
	// worst case- reverse order
	public static void insertionSort(int[] arr) {
		int temp;
		for(int i=1;i<arr.length;i++) {
			for(int j=0;j<i;j++) {
				if(arr[i]<arr[j]) {
					temp=arr[i];
					arr[i]=arr[j];
					arr[j]=temp;
				}
			}
		}
		for(int i=0;i<arr.length;i++) {
			System.out.print(arr[i]+"  ");
		}
	}
	
	// quick sort
	// time complexity - O(n^2) -worst case, O(n log n) - best and avg
	// Auxiliary space - log n(best), n(avg)
	// comparison-based sorting
	// usually not stable
	// in place
	// worst - when pivot is the smallest or the largest or many repetitive elements
	public static void quickSort(int[] arr,int low, int high) {
		if(low<high) {
			int pivotP=pivotSort(arr,low,high);
			quickSort(arr,low,pivotP-1);
			quickSort(arr,pivotP+1,high);
		}
	}
	
	public static int pivotSort(int[] arr, int low, int high) {
		int pivotV=arr[high];
		int indexP=low;
		for(int i=low;i<high;i++) {
			if(arr[i]<pivotV) {
				int temp=arr[i];
				arr[i]=arr[indexP];
				arr[indexP]=temp;
				indexP++;
			}
		}
		int temp=arr[indexP];
		arr[indexP]=arr[high];
		arr[high]=temp;
		return indexP;
	}
	

	
	// MergeSort
	// Time complexity - O(n logn)
	// Auxiliary space O(n)
	// sort linked list
	// comparison-based sorting
	// stable
	// not in-place
	// worst when already sorted
	public static void sort(int[] arr, int low, int high) {
		if(low<high) { 
			int mid=(high+low)/2;
			sort(arr,low,mid);
			sort(arr,mid+1,high);
			merge(arr,low,mid,high);
			
		}
		
	}
	
	public static void merge(int[] arr,int low,int mid,int high) {
		// find no of elements in arrays(L,R)
		int nL=mid-low+1;
		int nR=high-mid;
		// create and add those elements to the array for traversal
		int L[] = new int[nL],R[] = new int[nR];
		for(int i=0,j=low;i<nL;i++,j++) {
			L[i]=arr[j];
		}
		for(int i=0,j=mid+1;i<nR;i++,j++) {
			R[i]=arr[j];
		}
		
		// while any one reaches the limit, compare the pointers
		int iL=0, iR=0, k=low;
		while(iL<nL && iR<nR) {
			
			// add values to arr based on the comparison
			if(L[iL]<R[iR]) {
				arr[k]=L[iL];
				iL++;
			}
			else{
				arr[k]=R[iR];
				iR++;
			}
			k++;
		}
		
		
		// after while, add leftover elements
		while(iL<nL) {
			arr[k]=L[iL];
			iL++;
			k++;
		}
		while(iR<nR) {
			arr[k]=R[iR];
			iR++;
			k++;
		}
		
	}
	
	public static void display(int[] arr) {
		for(int i=0;i<arr.length;i++) {
			System.out.print(arr[i]+" ");
		}
	}
	
	
	// heap sort
	// time complexity - O(n log n)
	// Auxiliary space O(1)
	// comparison-based sorting
	// not stable
	// in place
	public static void heapSort(int[] arr,int n) {
		int index=n-1;
		for(int i=(index-1)/2;i>=0;i--) {
			maxheapify(arr,i,n-1);
		}
		for(int i=n-1;i>0;i--) {
			swap(arr,0,i);
			maxheapify(arr,0,i); 
		}
	}
	public static void maxheapify(int[] arr,int i,int n) {
		int left=(i*2)+1;
		int right=(i*2)+2;
		int largest=i;
		if(right<n && arr[right]>arr[largest])
			largest=right;
		if(left<n &&  arr[left]>arr[largest])
			largest=left;
		if(largest!=i) {
			swap(arr,i,largest);
			maxheapify(arr,largest,n);
		}
	}
	
	public static void swap(int[] arr,int i,int j) {
		int temp=arr[i];
		arr[i]=arr[j];
		arr[j]=temp;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a= {5,4,3,9,8,13,2,54,34,43,20,5};
		heapSort(a,a.length);
		display(a);
		int sum=63;
		int k=a.length;
		System.out.println("\nSum: "+sum);
		for(int i=0;i<a.length;i++) {
			for(int j=i;j<k;j++) {
				if((a[i]+a[j])==sum) {
					System.out.println("("+a[i]+","+a[j]+")");
					k=j;
				}
			}
		}
		/*
		HashMap<Integer,LinkedList<Integer>> mapHash=new HashMap<Integer,LinkedList<Integer>>();
		for(Integer i=0;i<a.length;i++) {
			if(!mapHash.containsKey(a[i]))			
				mapHash.put(a[i], new LinkedList<Integer>());
			mapHash.get(a[i]).add(i);
		}
		
		int sum=12;
		for(int i=0;i<a.length;i++) {
			int j=sum-a[i];
			if(mapHash.containsKey(j)) {				
				LinkedList<Integer> toadd = mapHash.get(j);
				for(Object it:toadd) {
					System.out.println("("+i+","+it+")");
				}
			}
		}*/
		
	}

}
