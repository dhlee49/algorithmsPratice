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
        if(head == null) return null;
        Node curr = head;
        //Copy regualr
        while(curr != null) {
            Node newNode = new Node(curr.val);
            Node next = curr.next;
            curr.next = newNode;
            newNode.next = next;
            curr = next;
        }
        //Copy the random
        curr = head;
        Node copy = head.next;
        while(curr != null) {
            if(curr.random == null) {
                copy.random = null;
            } else {
                copy.random = curr.random.next;
            }
            curr = curr.next.next;
            if(curr != null) copy = curr.next;
        }

        //Detach the list
        curr = head;
        copy = head.next;
             head = copy;
        while(curr != null) {
            Node next = copy.next;
            curr.next = next;
            if(next == null) {
                copy.next = null;
            } else {            
                copy.next = next.next;
            }
            curr = next;
            copy = copy.next;
        }
        return head;
        
    }
}