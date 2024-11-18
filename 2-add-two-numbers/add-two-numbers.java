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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int l1Size = getSize(l1);
        int l2Size = getSize(l2);

        if(l2Size > l1Size) return addTwoNumbers(l2, l1);
        int iteration = Math.min(l1Size, l2Size);
        int carry = 0;
        int val = 0;
        ListNode head = null;
        ListNode curr = null;
        ListNode next = null;
        while(iteration >= 0) {
            iteration--;
            val = (l1.val + l2.val + carry) % 10;
            carry = (l1.val + l2.val + carry) / 10;
            if(head == null) {
                head = new ListNode(val);
                curr = head;
            } else {
                next = new ListNode(val);
                curr.next = next;
                curr = next;
            }
            l1 = l1.next;
            l2 = l2.next;
        }
        //Case 1 No more nodes, but there is carry
        if(l1 == null && carry == 1) {
            curr.next = new ListNode(1);
        }
        //Case 2 No more nodes left
        if(l1 == null) {
            return head;
        }
        curr.next = l1;
        //Case 3 There are nodes left & carry
        ListNode prev = curr;
        while(l1 != null & carry > 0) {
            val = (l1.val + carry) % 10;
            carry = (l1.val + carry) / 10;
            l1.val = val;
            prev = l1;
            l1 = l1.next;

        }
        if(carry == 1) {
            prev.next = new ListNode(1);
        }
        return head;

    }
    private int getSize(ListNode node) {
        int size = 0;
        while(node.next != null) {
            node = node.next;
            size++;
        }
        return size;
    }
}