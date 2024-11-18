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
        Node newNode = null;
        Node curr = head;
        Node next;
        Node skip;
        while(curr != null) {
            skip = curr.next;
            newNode = new Node(curr.val);
            curr.next = newNode;
            newNode.next = skip;
            curr = skip;
        } 
        //So far we've set everything correctly. set random correclty.
        curr = head;
        while(curr != null) {
            next = curr.next;
            skip = next.next;
            if(curr.random != null) {            
                next.random = curr.random.next;
            } else {
                next.random = null;
            }
            curr = skip;
        }
        curr = head;
        Node newHead = curr.next;
        Node newCurr = newHead;
        while(newCurr.next != null) {
            curr.next = curr.next.next;
            curr = curr.next;
            newCurr.next = newCurr.next.next;
            newCurr = newCurr.next;
        }
        curr.next = null;
        return newHead;
    }
}