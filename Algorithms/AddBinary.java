//reference: http://blog.csdn.net/linhuanmars/article/details/20192227


// my way

public class Solution {
    public String addBinary(String a, String b) {
        if(a==null && b==null) return "";
        if(a==null) return b;
        if(b==null) return a;
        
        int indexA = a.length()-1;
        int indexB = b.length()-1;
        StringBuilder sb = new StringBuilder();
        int carry = 0;
        while(indexA>=0 && indexB>=0) {
            int digitA = a.charAt(indexA--)-'0';
            int digitB = b.charAt(indexB--)-'0';
            sb.append(String.valueOf((digitA+digitB+carry)%2));
            carry = (digitA+digitB+carry)/2;
        }
        while(indexA>=0) {
            int digitA = a.charAt(indexA--)-'0';
            sb.append(String.valueOf((digitA+carry)%2));
            carry = (digitA+carry)/2;
        } 
        while(indexB>=0) {
            int digitB = b.charAt(indexB--)-'0';
            sb.append(String.valueOf((digitB+carry)%2));
            carry = (digitB+carry)/2;
        }
        if(carry==1) sb.append("1");
        return sb.reverse().toString();
    }
}
public class Solution {
    public String addBinary(String a, String b) {
        if(a==null || b==null) return null;
        int lenA = a.length();
        int lenB = b.length();
        if(lenA==0) return b;
        if(lenB==0) return a;
        
        int i = lenA-1;
        int j = lenB-1;
        int carry = 0;
        int sum = 0;
        int digit = 0;
        StringBuilder res = new StringBuilder();
        while(i>=0 && j>=0) {
            sum  =(a.charAt(i) - '0')+(b.charAt(j) - '0') + carry;
            carry = sum/2;
            digit = sum%2;
            res.append(Integer.toString(digit));
            i--;
            j--;
        }
        while(i>=0) {
            sum = (a.charAt(i) - '0') + carry;
            carry = sum/2;
            digit = sum%2;
            res.append(Integer.toString(digit));
            i--;
        }
        while (j>=0) {
            sum = (b.charAt(j) - '0') + carry;
            carry = sum/2;
            digit = sum%2;
            res.append(Integer.toString(digit));
            j--;
        }
        if(carry==1) res.append("1");
        return res.reverse().toString();
    }
}
