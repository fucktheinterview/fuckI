// O(n + Mlgn) two heaps, this is gonna be the normal best solution. but sometimes it will ask O(m+ nlgn) and then find the solution below

package Leetcode;

import java.util.Arrays;

public class FindNFromM {
	
	public static void main(String[] args) {
		int[] input = {13, 1, 3, 2, 5, 12, 3, 9, 0};
		int n = 3;
		FindNFromM f = new FindNFromM();
		
		System.out.println(Arrays.toString(f.findNFromM(input, n)));
	}
	
	public int[] findNFromM(int[] input, int n) {
		HeapSort hs = new HeapSort(input, n -1);
		hs.constructMinHeap();
		for(int i = n; i < input.length; i++) {
			if(input[i] > input[0]) {
				int temp = input[i];
				input[i] = input[0];
				input[0] = temp;
				hs.minHeapify(0);
			}
		}
		return hs.outputSortedArray();
	} 
}

// parent: (i-1)/2
// left: (i+1) * 2- 1
// right (i+1) * 2

class HeapSort {
	private int heapSize;
	int[] array;
	
	public HeapSort(int[] array, int heapSize) {
		this.array = array;
		this.heapSize = heapSize;
	}
	
	public void constructMinHeap() {
		for(int i = getParent(heapSize); i>=0; i--) {
			minHeapify(i);
		}
	}
	
	public void minHeapify(int i) {
		int left = getLeftChild(i);
		int right = getRightChild(i);
		int min = i;
		if(left <= heapSize && array[left] < array[min]) min = left;
		if(right <= heapSize && array[right] < array[min]) min = right;
		if(min != i) {
			swap(i, min);
			minHeapify(min);
		}
	}
	
	public int[] outputSortedArray() {
		int resSize = heapSize + 1;
		int[] res = new int[resSize];
		for(int i = resSize -1; i>=0; i--) {
			res[i] = array[0];
			swap(0, heapSize);
			heapSize--;
			minHeapify(0);
		}
		return res;
	}
	
	private void swap(int a, int b) {
		int temp = array[a];
		array[a] = array[b];
		array[b] = temp;
	}
	
	private int getParent(int i) {
		return (i-1)/2;
	}
	
	private int getLeftChild(int i) {
		return (i+1) * 2 -1;
	}
	
	private int getRightChild(int i) {
		return (i+1) *2;
	}
}



// O(N + klgk) with a second heap and push 2 children every time

// or just one N size heap and keep pop out

package Leetcode;

import java.util.Arrays;

public class FindKLargest {
	public static void main(String[] args) {
		int[] input = {3, 2, 9, 1, 1, 5, 4, 10, -1, 9, 12};
		System.out.println(Arrays.toString(findKLargest2(input, 5)));
//		int[] input = {3, 2, 9, 1, 1, 5, 4, 10, -1};
//		System.out.println(Arrays.toString(findKLargest1(input, 3)));
	}
		
	public static int[] findKLargest1(int[] array, int k) {
		 int[] res = new int[k];
		 if(k > array.length) return res;
		 HeapSort.heapify(array);
		 IdxNode[] kHeap = new IdxNode[k+1];
		 KIdxHeap.insert(kHeap, new IdxNode(0, array[0]));
		 int count = 0;
		 while(count < k) {
			 IdxNode top = KIdxHeap.pop(kHeap);
			 res[count++] = top.value;
			 insertChildren(kHeap, top.idx, array);
		 }
		 return res;
	}
	
	public static int[] findKLargest2(int[] array, int k) {
		int[] res = new int[k];
		HeapSort2.heapify(array);
		int heapSize = array.length -1;
		int count = 0;
		while(count < k) {
			res[count] = array[0];
			HeapSort2.swap(array, heapSize--, 0);
			count++;
			HeapSort2.maxHeapify(array, 0, heapSize);
		}
		return res;
	}

	
	private static void insertChildren(IdxNode[] kHeap, int index, int[] heap) {
		int left = (index + 1) * 2 -1;
		int right = (index + 1) * 2;
		if(left < heap.length) KIdxHeap.insert(kHeap, new IdxNode(left, heap[left]));
		if(right < heap.length) KIdxHeap.insert(kHeap, new IdxNode(right, heap[right]));

	}
}

class KIdxHeap {
	private static int N = -1;
	public static void insert(IdxNode[] kHeap, IdxNode node) {
		kHeap[++N] = node;
		int i = N;
		while(i > 0 && kHeap[(i-1)/2].value < node.value) {
			swapNode(kHeap, i, (i-1)/2);
			i = (i-1)/2;
		}		
	}
	
	public static IdxNode pop(IdxNode[] kHeap) {
		IdxNode res = kHeap[0];
		swapNode(kHeap, 0, N);
		kHeap[N] = null;
		N--;
		maxHeapify(kHeap, 0);
		return res;
	}
	
	private static void maxHeapify(IdxNode[] kHeap, int target) {
		if(target >= N || target <0) return;
		int left = (target + 1) * 2 -1;
		int right = (target + 1) * 2;
		int max = target;
		if(left <= N && kHeap[left].value > kHeap[max].value) max = left;
		if(right <= N && kHeap[right].value > kHeap[max].value) max = right;
		if(max != target) {
			swapNode(kHeap, target, max);
			maxHeapify(kHeap, max);
		}
	}
	
	public static void swapNode(IdxNode[] kHeap, int a, int b) {
		IdxNode temp = kHeap[a];
		kHeap[a] = kHeap[b];
		kHeap[b] = temp;
	}
}

class IdxNode {
	public int idx;
	public int value;
	
	public IdxNode(int idx, int value) {
		this.idx = idx;
		this.value = value;
	}
}

/*
 		0
 	1		2
 3	  4   5    6
 
 i -> left (i+1) * 2 -1
 i -> right (i+1) * 2
 i -> parent (i-1)/2
 */

class HeapSort2 {
	
	public static int[] sort(int[] array){
		heapify(array);
		int heapSize = array.length -1;
		for(int i = heapSize; i >0; i--) {
			swap(array, i, 0);
			heapSize--;
			maxHeapify(array, 0, heapSize);
		}
		
		return array;
	}
	
	public static void heapify(int[] array) {
		int heapSize = array.length -1;
		// i starts with the parent of the last element
		for(int i = (heapSize-1)/2; i>=0 ; i--) {
			maxHeapify(array, i, heapSize);
		}
	}
	
	public static void maxHeapify(int[] array, int target, int heapSize) {
		if(target >= heapSize || target <0) return;
		int left = (target + 1) * 2 -1;
		int right = (target + 1) * 2;
		int max = target;
		if(left <= heapSize && array[left] > array[max]) max = left;
		if(right <= heapSize && array[right] > array[max]) max = right;
		if(max != target) {
			swap(array, target, max);
			maxHeapify(array, max, heapSize);
		}
	}
		
	public static void swap(int[] array, int a, int b) {
		int temp = array[a];
		array[a] = array[b];
		array[b] = temp;
	}
}
