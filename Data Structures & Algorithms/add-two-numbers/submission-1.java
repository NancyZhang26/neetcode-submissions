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
        ListNode dummy = new ListNode();
        ListNode curr = dummy;
        int carry = 0;
        while (l1!=null || l2!=null) {
            int one = l1==null?0:l1.val;
            int two = l2==null?0:l2.val;
            int sum = one + two + carry;
            int num = sum%10;
            ListNode node = new ListNode(num);

            curr.next = node;
            curr = curr.next;
            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;

            carry = sum/10;
        }
        if (carry==1) curr.next = new ListNode(1);
        return dummy.next;
    }
}
