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
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode ah = new ListNode(-1);
        ListNode at = ah;
        PriorityQueue<ListNode> minHeap = new PriorityQueue<>(Comparator.comparingInt(a -> a.val));

        for (ListNode list : lists) {
            minHeap.add(list);
        }

        while (!minHeap.isEmpty()) {
            ListNode temp = minHeap.poll();
            at.next = temp;
            at = at.next;
            if(temp.next != null){
                minHeap.add(temp.next);
            }
        }
        
        return ah.next;


    }
}
