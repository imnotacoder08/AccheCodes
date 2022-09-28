/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode swapNodes(ListNode head, int k) {
        ListNode curr = head;
        ListNode p1 = head;
        ListNode p2= head;
        int ct = 1;
        
        while( curr != null )
        {
            if( ct < k )
                p1 = p1.next;
            
            if( ct > k )
                p2 = p2.next;
            
            
            curr = curr.next;
            ct++;
        }
        
        int temp = p1.val;
        p1.val = p2.val;
        p2.val = temp;
        
        return head;
    }
}
        
    