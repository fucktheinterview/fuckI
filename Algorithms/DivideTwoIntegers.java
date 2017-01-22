
// lgn, constant space
// using long to avoid extra check
// confirm with the interview at last or begining, Integer.MIN_VALUE / -1 = Integer.MIN_VALUE(correct as in eclipse) instead of Integer.MAX_VALUE like in leetcode.

public class Solution {
    public int divide(int dividend, int divisor) {
        if(divisor == 0) return Integer.MAX_VALUE;
        boolean isNeg = ((dividend ^ divisor) >>> 31 ) == 1;
        long a = (long) dividend, b = (long) divisor;
        if(a < 0) a = -a;
        if(b < 0) b = -b;
        
        int digit = 0;
        while(b <= a >> 1) {
            digit++;
            b <<= 1;
        }
        long res = 0;
        
        while(digit >= 0) {
            if(a >= b) {
                res += (((long)1) << digit); //Integer.MIN_VALUE, -1 should be Integer.MAX_VALUE, i >>> 31 will be MIN_VALUE if not casted to long
                a -= b;
            }
            digit--;
            b >>= 1;
        }
        
        if(res > Integer.MAX_VALUE) return isNeg ? Integer.MIN_VALUE : Integer.MAX_VALUE;
        int intRes = (int)res;
        return isNeg ? -intRes : intRes;
    }
}
// my latest, Integer.MIN_VALUE / -1 = Integer.MIN_VALUE(correct as in eclipse) instead of Integer.MAX_VALUE like in leetcode.

public class Solution {
    public int divide(int dividend, int divisor) {
        if(dividend == 0) return 0;
        if(divisor == 1) return dividend;
        if(divisor == 0) return Integer.MAX_VALUE;
        boolean isNeg = false;
        if(((dividend ^ divisor) >>> 31) == 1) isNeg = true;
        int res = 0;
        if(divisor == Integer.MIN_VALUE) return dividend == Integer.MIN_VALUE ? 1 : res;
        if(divisor < 0) divisor = Math.abs(divisor);
        if(dividend == Integer.MIN_VALUE) {
            dividend += divisor;
            res++;
        }
        if(dividend < 0) dividend = Math.abs(dividend);
        
        int digit = 0;
        while(divisor <= (dividend >> 1)) {
            divisor <<= 1;
            digit++;
        }
        
        while(digit >= 0) {
            if(dividend >= divisor) {
                res += 1 << digit;
                dividend -= divisor;                
            }
            divisor >>= 1;
            digit--;
        }
        return isNeg ? -res : res;
    }
}

//http://blog.csdn.net/linhuanmars/article/details/20024907

//所以时间复杂度为O(logn)。

public class Solution {
    public int divide(int dividend, int divisor) {
        if(divisor == 0) return Integer.MAX_VALUE;
        int res = 0;
        boolean isNeg = (dividend ^ divisor) >>> 31 == 1;
        if(dividend == Integer.MIN_VALUE){
            dividend += Math.abs(divisor);
            if(divisor == -1){
                return Integer.MAX_VALUE;
            }
            res++;
        }
        
        if(divisor == Integer.MIN_VALUE) return res;
        dividend = Math.abs(dividend);
        divisor = Math.abs(divisor);
        int digit = 0;
        while(divisor <= (dividend>>1)){
            divisor<<=1;
            digit++;
        }
        while(digit>=0){
            if(dividend >= divisor){
                res += 1<<digit;
                dividend-= divisor;
            }
            divisor >>=1;
            digit--;
        }
        return isNeg ? -res: res;
    }
}

package leetcode;

public class DivideTwoIntegers {
    public int divide(int dividend, int divisor) // return c=a/b;
    {
        long a = dividend;
        long b = divisor;

        if (b == 0)
            throw new ArithmeticException();

        boolean isNeg = false;
        if (a < 0)
            isNeg = !isNeg;

        if (b < 0)
            isNeg = !isNeg;

        a = Math.abs(a);
        b = Math.abs(b);

        int k = 0;
        while (b << k <= a)
            ++k;

        int res = 0;
        k--;
        for (int i = k; i >= 0; i--)
        {
            if (b << i <= a)
            {
                res |= 1 << i;
                a -= b << i;
            }
        }

        if (isNeg)
            res = -res;
        return res;
    }

}
