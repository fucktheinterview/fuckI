// http://blog.csdn.net/linhuanmars/article/details/20276833
//brute force: 所以算法时间复杂度为O((n-m+1)*m)=O(n*m)，空间复杂度是O(1)。代码如下：
public String strStr(String haystack, String needle) {
    if(haystack==null || needle == null || needle.length()==0)
        return haystack;
    if(needle.length()>haystack.length())
        return null;
    for(int i=0;i<=haystack.length()-needle.length();i++)
    {
        boolean successFlag = true;
        for(int j=0;j<needle.length();j++)
        {
            if(haystack.charAt(i+j)!=needle.charAt(j))
            {
                successFlag = false;
                break;
            }
        }
        if(successFlag)
            return haystack.substring(i);
    }
    return null;
}

// 所以检测所有子串的时间复杂度只需要O(m+n-m)=O(n)，也是一个线性算法。代码如

//比较细心的朋友可能看出来了，这个方法的hashcode比较容易越界，因为以素数为底的幂会很大，解决的办法可以用BigInteger,或者如同Rabin–Karp algorithm - Wikipedia

public String strStr(String haystack, String needle) {
    if(haystack==null || needle==null) return null;
    if(haystack.length()==0){
        return needle.length()==0?"":null;
    }
    if(needle.length()==0) return haystack;
    if(haystack.length()<needle.length()) return null;

 int base = 29;
 long patternHash = 0;
    long tempBase = 1;

    for(int i=needle.length()-1; i>=0; i--){
     patternHash += (int)needle.charAt(i)*tempBase;
     tempBase *= base;
    }

    long hayHash = 0;
    tempBase = 1;
    for(int i=needle.length()-1; i>=0; i--){
     hayHash += (int)haystack.charAt(i)*tempBase;
     tempBase *= base;
    }
    tempBase /= base;

    if(hayHash == patternHash){
     return haystack;
    }

    for(int i=needle.length(); i<haystack.length(); i++){
     hayHash = (hayHash - (int)haystack.charAt(i-needle.length())*tempBase)*base+(int)haystack.charAt(i);
        if(hayHash == patternHash){
      return haystack.substring(i-needle.length()+1);
     }
    }
    return null;
} 