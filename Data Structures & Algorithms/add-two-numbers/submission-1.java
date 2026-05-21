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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode t1 = l1;
        ListNode t2 = l2;
        ListNode ah = new ListNode();
        ListNode at = ah;

        int carry = 0;
        while (t1 != null && t2 != null) {
            int num = t1.val + t2.val + carry;
            carry = num / 10;
            at.next = new ListNode(num % 10);
            t1 = t1.next;
            t2 = t2.next;
            at = at.next;
        }

        while(t1 != null){
            int num = t1.val + carry;
            carry = num / 10;
            at.next = new ListNode(num % 10);
            t1 = t1.next;
            at = at.next;
        }
        while(t2 != null){
            int num = t2.val + carry;
            carry = num / 10;
            at.next = new ListNode(num % 10);
            t2 = t2.next;
            at = at.next;
        }
        if(carry!=0){
            at.next = new ListNode(carry );
        }

        return ah.next;


    }
}
