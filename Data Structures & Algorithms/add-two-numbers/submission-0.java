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
        int carry = 0;

        ListNode res = new ListNode(0);

        ListNode temp = res;
        // res = res.next;
        while (l1 != null || l2 != null || carry != 0) {

            int val1 = (l1 != null) ? l1.val : 0;
            int val2 = (l2 != null) ? l2.val : 0;

            int add = val1 + val2 + carry;
            carry = add / 10;

            res.next = new ListNode(add % 10);
    
            res = res.next;
            l1 = l1 != null ? l1.next : null;
            l2 = l2 != null ? l2.next : null;
        }

        // if (l1 != null) res.next = l1;
        // if (l2 != null) res.next = l2;

        return temp.next;
    }
}