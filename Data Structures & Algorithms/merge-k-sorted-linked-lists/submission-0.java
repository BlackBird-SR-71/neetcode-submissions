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
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) return null;
        while (lists.length > 1) {
            List<ListNode> merged = new ArrayList<>();
            for (int i = 0; i < lists.length; i+=2) {
                ListNode node1 = lists[i];
                ListNode node2 = (i + 1) < lists.length ? lists[i + 1] : null;

                merged.add(merge(node1,node2));
            }

            lists = merged.toArray(new ListNode[0]);
        }
        return lists[0];
        
    }

    private ListNode merge(ListNode headA, ListNode headB) {
        ListNode dummy = new ListNode();

        ListNode res = dummy;

        while (headA != null && headB != null) {
            if (headA.val < headB.val) {

                dummy.next = headA;
                headA = headA.next;

            }

            else {
                

                dummy.next = headB;
                headB = headB.next;
            }

            dummy = dummy.next;
        }

        if (headA != null) {
            dummy.next = headA;
        }
        if (headB != null) {
            dummy.next = headB;
        }
        return res.next;
        
    }
}


