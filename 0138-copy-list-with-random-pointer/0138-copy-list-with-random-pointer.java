/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {   
        if(head==null){
            return null;
        }            
        HashMap<Node, Node> m = new HashMap<>();
        Node newHead = new Node(head.val);
            Node oldtemp = head.next;
            Node newtemp = newHead;
            m.put(head, newHead);
            
            while(oldtemp!=null){
                // plan simple traik to copy linkedlist
                Node copyNode = new Node(oldtemp.val);
                // to store the value in map
               m.put(oldtemp, copyNode);
                newtemp.next = copyNode;

                oldtemp = oldtemp.next;
                newtemp = newtemp.next;
            }
            //to copy the random 
            oldtemp = head; 
            newtemp = newHead;
            while(oldtemp!=null){
             newtemp.random = m.get(oldtemp.random);
              oldtemp = oldtemp.next;
              newtemp = newtemp.next;
            }
            return newHead;

        
    }

}