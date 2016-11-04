// O(n) = 2 * n, constant space

/* The knows API is defined in the parent class Relation.
      boolean knows(int a, int b); */

public class Solution extends Relation {
    public int findCelebrity(int n) {
        if(n < 1) return -1;
        int candidate = 0;
        
        for(int i = 1; i < n; i++) {
            if(!knows(i, candidate)) candidate = i;  // we can use either condition check here
        }
        
        for(int i = 0; i < n; i++) {
            if(i != candidate && (!knows(i, candidate) || knows(candidate, i))) return -1;
        }
        return candidate;
    }
}

/* The knows API is defined in the parent class Relation.
      boolean knows(int a, int b); */

public class Solution extends Relation {
    public int findCelebrity(int n) {
        if(n<1) return -1;
        int candidate = 0;
        
        for(int i = 1; i < n; i++) {
            if(knows(candidate, i)) {
                candidate = i;
            }
        }
        
        for(int i = 0; i < n; i++) {
            if(i != candidate && (knows(candidate, i) || !knows(i, candidate))) return -1;
        }
        return candidate;
    }
}
