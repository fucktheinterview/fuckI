// O(n)

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    Random rand;
    ListNode head;
    
    /** @param head The linked list's head.
        Note that the head is guaranteed to be not null, so it contains at least one node. */
    public Solution(ListNode head) {
        rand = new Random();
        this.head = head;
    }
    
    /** Returns a random node's value. */
    public int getRandom() {
        ListNode node = head;
        
        int res = node.val;
        int count = 0;
        
        while(node != null) {
            if(rand.nextInt(++count) == 0) res = node.val;
            node = node.next;
        }
        
        return res;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(head);
 * int param_1 = obj.getRandom();
 */
