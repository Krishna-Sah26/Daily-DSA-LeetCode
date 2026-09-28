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
        // Priority Queue: smallest node value comes first
        PriorityQueue<ListNode> pq = new PriorityQueue<>(
            (a, b) -> Integer.compare(a.val, b.val)
        );

        // Put the first node of every list into the priority queue
        for (int i = 0; i < lists.length; i++) {
            if (lists[i] != null) {
                pq.offer(lists[i]);
            }
        }

        // Dummy node
        ListNode dummyNode = new ListNode(-1);
        ListNode temp = dummyNode;

        while (!pq.isEmpty()) {

            // Get the smallest node
            ListNode current = pq.poll();

            // Add it to the answer list
            temp.next = current;
            temp = temp.next;

            // Add the next node of the same list
            if (current.next != null) {
                pq.offer(current.next);
            }
        }

        return dummyNode.next;
    }
}