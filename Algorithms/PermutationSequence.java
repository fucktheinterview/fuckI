http://blog.csdn.net/linhuanmars/article/details/22028697
public class Solution {
    public String getPermutation(int n, int k) {
        if(n<=0) return null;
        StringBuilder res = new StringBuilder();
        ArrayList<Integer> digits = new ArrayList<Integer>();
        for(int i=1; i<=n; i++) {
            digits.add(i);
        }
        int fac = 1;
        for(int i = 2; i<n; i++) {
            fac*=i;
        }
        k--;
        n--;
        while(n>=0) {
            int digit = k/fac;
            k %=fac;
            res.append(digits.get(digit));
            digits.remove(digit);
            if(n>0) fac/=n;
            n--;
        }
        return res.toString();
    }
}


// another solution
public class Solution {
    public String getPermutation(int n, int k) {
        // Start typing your Java solution below
        // DO NOT write main() function
        boolean[] visited = new boolean[n];
        int[] factor = new int[n];
        factor[0] = 1;
        for(int i=1; i<n; i++)
            factor[i] = factor[i-1]*i;
        String solution="";
            
        for(int i=n-1; i>=0; i--){
            int tmp = 1;
            while(k > factor[i]){
                tmp++;
                k -= factor[i];
            }
            for(int j=0; j<n; j++)
                if(j+1<=tmp && visited[j])
                    tmp++;
            solution+=Integer.toString(tmp);
            visited[tmp-1] = true;
        }
        
        return solution;
    }
}
