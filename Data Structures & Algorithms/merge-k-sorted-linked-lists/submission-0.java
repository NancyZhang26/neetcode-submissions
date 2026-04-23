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
        ListNode dummy = new ListNode();
        if (lists.length == 0) {
            return null;
        }
        ListNode cur = dummy;
        cur.next = lists[0];
        cur = cur.next;

        int i = 1;

        while (i < lists.length) {
            ListNode node = mergeLists(cur, lists[i]);
            cur = node;
            i++;
        }

        return cur;
    }

    public ListNode mergeLists(ListNode n1, ListNode n2) {
        ListNode dummy = new ListNode();
        ListNode cur = dummy;

        while (n1!=null && n2!=null) {
            if (n1.val <= n2.val) {
                cur.next = n1;
                n1 = n1.next;
            } else {
                cur.next = n2;
                n2 = n2.next;
            }
            cur = cur.next;
        }

        if (n1!=null) cur.next = n1;
        if (n2!=null) cur.next = n2;

        return dummy.next;
    }
}
