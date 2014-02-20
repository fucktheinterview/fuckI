//Given a linked list, determine if it has a cycle in it.

/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
        if(head==null||head.next==null|| head.next.next==null) return false;
        
        ListNode cursor1 = head.next;
        ListNode cursor2 = head.next.next;
        while(cursor1!=cursor2){
            if(cursor1.next==null||cursor2.next==null||cursor2.next.next==null) return false;
            cursor1 = cursor1.next;
            cursor2= cursor2.next.next;
        }
     
        return true;
    }
}

//Given a linked list, return the node where the cycle begins. If there is no cycle, return null.


/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
        if(head==null||head.next==null|| head.next.next==null) return null;
        if(head.next==head) return head;
        ListNode cursor1 = head.next;
        ListNode cursor2 = head.next.next;
        while(cursor1!=cursor2){
            if(cursor1.next==null||cursor2.next==null||cursor2.next.next==null) return null;
            cursor1 = cursor1.next;
            cursor2= cursor2.next.next;
        }
        cursor1 =head;
        while(cursor1!=cursor2){
            cursor1= cursor1.next;
            cursor2 = cursor2.next;
        }
        
        return cursor1;
    }
}
