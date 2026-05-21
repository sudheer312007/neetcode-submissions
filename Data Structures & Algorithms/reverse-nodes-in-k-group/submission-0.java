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
    public ListNode reverseKGroup(ListNode head, int k) {
        int count = k;
        ListNode tHead = head;
        ListNode tNode = head;
        ListNode prev = null;
        ListNode ah = new ListNode(-1);
        ListNode at = ah;

        while (tNode != null) {
            while (count > 0 && tNode != null) {
                prev = tNode;
                tNode = tNode.next;
                count--;
            }
            prev.next = null;
            if (count == 0) {
                ListNode rHead = reverseList(tHead);
                at.next = rHead;
                while (at.next != null) {
                    at = at.next;
                }
                tHead = tNode;
                count = k;
            } else {
                at.next = tHead;
            }


        }
        return ah.next;
    }

    private ListNode reverseList(ListNode head) {
        ListNode curr = head;
        ListNode prev = null;

        while (curr != null) {
            ListNode temp = curr;
            curr = curr.next;
            temp.next = prev;
            prev = temp;
        }
        return prev;
    }
}
