/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public void deleteNode(ListNode node) {
        ListNode nextNode = node.next;
        // value ko copy karo
        node.val = nextNode.val;
        // delete the next nide
        node.next = nextNode.next;
        nextNode.next = null;
        
    }
}