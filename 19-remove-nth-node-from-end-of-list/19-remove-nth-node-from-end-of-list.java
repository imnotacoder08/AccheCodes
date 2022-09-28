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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        
        if(head.next == null) { return null; }
        
        if(head.next.next == null) {
            if(n == 1) { head.next = null; }
            if(n == 2) { head = head.next; }
            return head;
        }
        
        ListNode first = head;
        ListNode second = head;
        
        for(int i = 0;i < n;i++) {
            first = first.next;
        }
        
        if(first == null) {
            head = head.next;
            return head;
        }
        
        while(true) {
            if(first.next == null) { break; }
            first = first.next;
            second = second.next;
        }
        
        second.next = second.next.next;
        
        return head;
    }
}