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
        ListNode temp = head;
        int cnt = 0;
        // check the k node of exit or not
        while(cnt<k){
            if(temp==null){
                return head;
            }
            temp = temp.next;
            cnt++;
        }
        // recurselvly call for the rst of ll
        ListNode prevNode = reverseKGroup(temp,k);
        //reverse current node ;
        temp = head; cnt = 0;
        while(cnt<k){
            ListNode next = temp.next;
            temp.next = prevNode;
            prevNode = temp;
            temp=next;
            cnt++;
        }
        return prevNode;
    }
}