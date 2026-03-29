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
        ListNode res = new ListNode(-1, head);
        ListNode prev = res;

        while (head != null) {
            ListNode temp = head;
            for (int i = 1; i < k; i++) {
                if (temp.next == null) {
                    return res.next;
                }
                temp = temp.next;
            }
            ListNode next = temp.next;
            temp.next = null;
            temp = reverse(head);

            prev.next = temp;
            for (int i = 1; i < k; i++) {
                temp = temp.next;
            }
            temp.next = next;
            prev = temp;
            head = next;
        }

        return res.next;
    }

    private ListNode reverse(ListNode head) {
        ListNode temp = null;
        while (head != null) {
            ListNode next = head.next;
            head.next = temp;
            temp = head;
            head = next;
        }
        return temp;
    }
}
