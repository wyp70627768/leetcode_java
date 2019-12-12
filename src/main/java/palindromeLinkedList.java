/*
234. Palindrome Linked List
Easy

2161

300

Favorite

Share
Given a singly linked list, determine if it is a palindrome.

Example 1:

Input: 1->2
Output: false
Example 2:

Input: 1->2->2->1
Output: true
Follow up:
Could you do it in O(n) time and O(1) space?
 */

public class palindromeLinkedList {
    public boolean isPalindrome(ListNode head) {
        if (head == null)
            return true;
        ListNode slow = head;
        ListNode fast = head;
        while (fast.next != null&& fast.next.next) {
            fast = fast.next.next;
            slow = slow.next;
        }
        ListNode secondHalf = slow.next;
        ListNode pre = null;
        ListNode curr = secondHalf;
        while (curr != null) {
            ListNode temp = curr.next;
            curr.next = pre;
            pre = curr;
            curr = temp;
        }
        slow.next = null;
        while (pre != null) {
            if (pre.val != head.val)
                return false;
            head = head.next;
            pre = pre.next;
        }
        return true;
    }
}
