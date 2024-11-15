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
        if(l1Size > l2Size) return getFullCalc(l1,l2, l1Size, l2Size);
        return getFullCalc(l2,l1, l2Size, l1Size);
    }
    private ListNode getFullCalc(ListNode first, ListNode second, int firstSize, int secondSize) {
        ListNode head = null;
        ListNode curr = null;
        ListNode prev = null;
        int carry = 0;
        int value = 0;
        while(secondSize > 0) {
            secondSize--;
            firstSize--;
            value = (carry + first.val  + second.val) % 10;
            carry = (carry + first.val + second.val) / 10;
            if(head == null) {
                head = new ListNode(value);
                curr = head;
            } else {
                prev = curr;
                curr =  new ListNode(value);
                prev.next = curr;
            }
            first = first.next;
            second = second.next;
        }
        while(carry > 0 && firstSize > 0) {
            firstSize--;
            value = (carry + first.val) % 10;
            carry = (carry + first.val) / 10;
            curr.next = first;
            first.val = value;
            curr = first;
            first = first.next;
        }
        //We have 2 possible cases
        // 1. No more carry 2.No more nodes
        if(firstSize > 0) {
            //Add node 
            curr.next = first;
        } else if(carry > 0) {
            curr.next = new ListNode(carry);
        }
        return head;
    }
    private int getSize(ListNode curr) {
        int size = 1;
        while(curr.next != null) {
            size++;
            curr = curr.next;
        }
        return size;
    }
}