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
    public ListNode FindthNode(ListNode temp,int k){
        int cnt = 1;
        while(temp!=null){
            if(cnt==k) return temp;
                cnt ++;
                temp = temp.next;
        }
        return null;
    }
    public ListNode rotateRight(ListNode head, int k) {
        if(head==null || k==0){

            return head;
        }   
            ListNode tail = head;
            int len = 1;
            while(tail.next!=null){
                tail = tail.next;
                len += 1;
            }
            if(k % len ==0) return head;
            k = k%len;
            // aattach the tail to head;
            tail.next = head;
            ListNode newListNode = FindthNode(head,len -k);
            head = newListNode.next;
            newListNode.next = null;
            return head;
        
    }
}