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
     public ListNode mergeTwoLists(ListNode h1, ListNode h2) {
        if (h1 == null) {
            return h2;
        }
        if (h2 == null) {
            return h1;
        }

        ListNode h = new ListNode(-1);
        ListNode t = h;

        ListNode t1 = h1;
        ListNode t2 = h2;

        while (t1 != null && t2 != null) {
            if (t1.val < t2.val) {
                t.next = t1;
                t1 = t1.next;
            } else {
                t.next = t2;
                t2 = t2.next;
            }
            t = t.next;
        }

        if (t1 != null) {
            t.next = t1;
        }else{
            t.next = t2;
        }

        return h.next;


    }
}