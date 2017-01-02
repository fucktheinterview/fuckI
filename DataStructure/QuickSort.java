// my easy understanding one, worst O(n2), average nlgn, in place
//快速排序之所比较快，因为相比冒泡排序，每次交换是跳跃式的。每次排序的时候设置一个基准点，
//将小于等于基准点的数全部放到基准点的左边，将大于等于基准点的数全部放到基准点的右边。
//这样在每次交换的时候就不会像冒泡排序一样每次只能在相邻的数之间进行交换，交换的距离就大的多了。
//因此总的比较和交换次数就少了，速度自然就提高了。
public class Quicksort  {
	
	public static void main(String[] args) {
		Quicksort qs = new Quicksort();
		System.out.println(Arrays.toString(qs.sort(new int[]{3, 1, 1, 1, 5, 6, 2, 3, 10})));
	}
	
	public int[] sort(int[] input) {
		if(input == null || input.length == 0) return null;
		quickSort(input, 0, input.length -1);
		return input;
	}
	
	public void quickSort(int[] input, int start, int end) {
		if(start >= end) return;
		int i = start, j = end, pivot = input[start];
		
		while( i < j) {
			while(i < j && input[j] >= pivot) j--;
			if(i < j) input[i++] = input[j];
			
			while(i < j && input[i] < pivot) i++;
			if(i < j) input[j--] = input[i];
		}
		
		input[i] = pivot;
		quickSort(input, start, i -1);
		quickSort(input, i + 1, end);
	}
} 

package Facebook;

import java.util.Arrays;

public class Quicksort  {
	
	public static void main(String[] args) {
		Quicksort qs = new Quicksort();
		System.out.println(Arrays.toString(qs.sort(new int[]{3, 5, 2, 3})));
	}
	
	public int[] sort(int[] input) {
		if(input == null || input.length == 0) return null;
		quickSort(input, 0, input.length -1);
		return input;
	}
	
	public void quickSort(int[] input, int start, int end) {
		int i = start, j = end;
		int pivot = input[start + (end - start)/2];
		while(i <= j) {
			while(input[i] < pivot) i++;

			while(input[j] > pivot) j--;
			
			if(i <= j) {
				swap(input, i, j);
				i++;
				j--;
			}
		}
		
		if(start < j) {
			quickSort(input, start, j);
		}
		
		if(i < end) {
			quickSort(input, i, end);
		}
	}
	
	private void swap(int[] input, int i, int j) {
		int temp = input[i];
		input[i] = input[j];
		input[j] = temp;
	}
} 


/*Fast, recursive, non-stable sort algorithm which works by the divide and conquer principle. Quicksort will in the best case divide the array into almost two identical parts. It the array contains n elements then the first run will need O(n). Sorting the remaining two sub-arrays takes 2* O(n/2). This ends up in a performance of O(n log n).

In the worst case quicksort selects only one element in each iteration. So it is O(n) + O(n-1) + (On-2).. O(1) which is equal to O(n^2).

The average case of quicksort is O(n log n).

Worst case performance	O(n2) (extremely rare)
Best case performance	O(n log n)
Average case performance	O(n log n)
Worst case space complexity	O(n) auxiliary (naive)
O(log n) auxiliary (Sedgewick 1978)
*/

// http://en.wikipedia.org/wiki/Quicksort
public class Quicksort  {
  private int[] numbers;
  private int number;

  public void sort(int[] values) {
    // check for empty or null array
    if (values ==null || values.length==0){
      return;
    }
    this.numbers = values;
    number = values.length;
    quicksort(0, number - 1);
  }

  private void quicksort(int low, int high) {
    int i = low, j = high;
    // Get the pivot element from the middle of the list
    int pivot = numbers[low + (high-low)/2];

    // Divide into two lists
    while (i <= j) {
      // If the current value from the left list is smaller then the pivot
      // element then get the next element from the left list
      while (numbers[i] < pivot) {
        i++;
      }
      // If the current value from the right list is larger then the pivot
      // element then get the next element from the right list
      while (numbers[j] > pivot) {
        j--;
      }

      // If we have found a values in the left list which is larger then
      // the pivot element and if we have found a value in the right list
      // which is smaller then the pivot element then we exchange the
      // values.
      // As we are done we can increase i and j
      if (i <= j) {
        exchange(i, j);
        i++;
        j--;
      }
    }
    // Recursion
    if (low < j)
      quicksort(low, j);
    if (i < high)
      quicksort(i, high);
  }

  private void exchange(int i, int j) {
    int temp = numbers[i];
    numbers[i] = numbers[j];
    numbers[j] = temp;
  }
} 
