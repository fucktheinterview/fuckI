//So how can we improve the above solution and make it O(N) guaranteed? 
//The answer is quite simple, we can randomize the input, so that even when the 
//worst case input would be provided the algorithm wouldn't be affected. 
//So all what it is needed to be done is to shuffle the input.
private void shuffle(int a[]) {

        final Random random = new Random();
        for(int ind = 1; ind < a.length; ind++) {
            final int r = random.nextInt(ind + 1);
            exch(a, ind, r);
        }
    }
//O(N) best case / O(N^2) worst case running time + O(1) memory

public class Solution {
    public int findKthLargest(int[] nums, int k) {
        if(nums == null || k < 1 || k > nums.length) return 0;
        
        return quickSelect(nums, k, 0, nums.length -1);
    }
    
    private int quickSelect(int[] nums, int k, int low, int high) {
        int i = low, j = high, pivot = nums[low];
        
        while(i < j) {
            while(i < j && nums[j] >= pivot) j--;
            if(i < j) nums[i++] = nums[j];
            
            while(i < j && nums[i] < pivot) i++;
            if(i < j) nums[j--] = nums[i];
        }
        
        nums[i] = pivot;
        int largerEqual = high - i + 1;
        if(largerEqual == k) return nums[i];
        else if(largerEqual > k) return quickSelect(nums, k, i + 1, high);
        else return quickSelect(nums, k - largerEqual, low, i - 1);
    }
}

//O(N lg K) running time + O(K) memory

public int findKthLargest(int[] nums, int k) {

    final PriorityQueue<Integer> pq = new PriorityQueue<>();
    for(int val : nums) {
        pq.offer(val);

        if(pq.size() > k) {
            pq.poll();
        }
    }
    return pq.peek();
}


// O(N lg N) running time + O(1) memory

public int findKthLargest(int[] nums, int k) {
        final int N = nums.length;
        Arrays.sort(nums);
        return nums[N - k];
}
