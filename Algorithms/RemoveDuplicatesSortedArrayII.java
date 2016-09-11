// my latest
public class Solution {
    public int removeDuplicates(int[] nums) {
        if(nums == null && nums.length ==0) return 0;
        
        int res = 1;
        int count = 1;
        int k = 2;
        for(int i =1; i< nums.length; i++){
            if(nums[i] == nums[i-1]) {
                count++;
                if(count <=k) {
                    res++;
                }
            } else {
                count = 1;
                res++;
            }
            nums[res-1] = nums[i];
        }
        
        return res;
    }
}

//reference: http://blog.csdn.net/linhuanmars/article/details/24343525

public class Solution {
    public int removeDuplicates(int[] A) {
        if(A==null || A.length==0) return 0;
        int pre = 0;
        int dup = 1;
        for(int i = 1; i<A.length; i++) {
            if(A[pre]!=A[i]) {
                A[++pre] = A[i];
                dup =1;
            } else if(dup<2){
                dup++;
                A[++pre] = A[i];
            }
        }
        return pre+1;
    }
}

public class Solution {
    public int removeDuplicates(int[] A) {
        if(A==null || A.length==0) return 0;
        
        int index = 1;
        int count = 1;
        
        for(int i=1; i<A.length; i++) {
            if(A[index-1] ==A[i]) {
                if(count<2) {
                    A[index] = A[i];
                    index++;
                    count++;
                }
            } else {
                count =1 ;
                A[index] = A[i];
                index++;
            }
        }
        return index;
    }
}
