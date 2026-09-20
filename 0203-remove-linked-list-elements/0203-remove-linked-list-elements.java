class Solution {
    public ListNode removeElements(ListNode head, int val) {

        ListNode curr = head;
        ListNode prev = null;

        while (curr != null) {

            // Agar current node ko delete karna hai
            if (curr.val == val) {

                // Agar head node delete ho raha hai
                if (prev == null) {
                    head = curr.next;
                } 
                else {
                    // Previous node ko current ke next se connect karo
                    prev.next = curr.next;
                }

            } 
            else {
                // Sirf tab prev ko aage move karo
                prev = curr;
            }

            // Current ko next node par move karo
            curr = curr.next;
        }

        return head;
    }
}