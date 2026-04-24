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
        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode cur = head;
        ListNode tail = head;
        ListNode prev = dummy;
        ListNode start = dummy;

        boolean stop = false;

        outer:
        while (stop==false) {
            for (int i = 0; i < k; i++) {
                if (tail == null) {
                    stop = true;
                    // System.out.println("stop");
                    break outer;
                }
                tail = tail.next;
            }

            for (int i = 0; i < k; i++) {
                ListNode temp = cur.next;
                cur.next = prev;
                prev = cur;
                cur = temp;

                if (cur==null) break;
            }
            
            // System.out.println("head is: "+ head.val);
            // System.out.println("start is: "+ start.val);
            // System.out.println("tail is: "+ tail.val);
            // System.out.println("---");
            start.next = prev;
            head.next = tail;

            start = head;
            head = start.next;

            if (tail == null) break;

            // System.out.println("head is: "+ head.val);
            // System.out.println("start is: "+ start.val);
            // System.out.println("tail is: "+ tail.val);
        }

        return dummy.next;
    }
}
