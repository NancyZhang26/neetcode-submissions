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

// split in half -> reverse the second half -> intersect the two halves

class Solution {
    public void reorderList(ListNode head) {
        ListNode dummy = new ListNode();
        // split half
        ListNode slow = head;
        ListNode fast = head;

        while (fast.next!=null && fast.next.next!=null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode half = new ListNode();
        half = slow.next;
        slow.next = null;

        ListNode newHead = reverseList(half);
        ListNode cur = head;

        intersect(cur, newHead);
    }

    public ListNode reverseList(ListNode head) {
        ListNode curr = head;
        ListNode prev = null;
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

    public ListNode intersect(ListNode node1, ListNode node2) {
        ListNode dummy = new ListNode();
        ListNode curr = dummy;

        while (node1 != null && node2 != null) {
            curr.next = node1;
            node1 = node1.next;
            curr = curr.next;
            curr.next = node2;
            node2 = node2.next;
            curr = curr.next;
        }
        if (node1!=null) curr.next = node1;
        if (node2!=null) curr.next = node2;

        return dummy.next;
    }
}
