/*
369. Plus One Linked List
Medium

358

16

Favorite

Share
Given a non-negative integer represented as non-empty a singly linked list of digits, plus one to the integer.

You may assume the integer do not contain any leading zero, except the number 0 itself.

The digits are stored such that the most significant digit is at the head of the list.

Example :

Input: [1,2,3]
Output: [1,2,4]
 */
public class plusOneLinkedList {
    public ListNode plusOne(ListNode head) {
        if (head == null)
            return head;
        ListNode newHead = reverse(head);
        ListNode dummy = newHead;
        int carry = 1;
        while (newHead != null) {
            int temp = carry + newHead.val;
            carry = temp/10;
            newHead.val = temp%10;
            newHead = newHead.next;
        }
        if (carry != 0) {
            ListNode node = new ListNode(0);
            newHead.next = node;
        }
        return dummy;
    }
    private ListNode reverse(ListNode head) {
        if (head == null) {
            return head;
        }
        ListNode pre = null;
        while (head != null) {
            ListNode temp = head.next;
            head.next = pre;
            pre = head;
            head = temp;
        }
        return pre;
    }
}
