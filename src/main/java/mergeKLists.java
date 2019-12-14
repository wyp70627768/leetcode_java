/*
23. Merge k Sorted Lists
Hard

3331

219

Favorite

Share
Merge k sorted linked lists and return it as one sorted list. Analyze and describe its complexity.

Example:

Input:
[
  1->4->5,
  1->3->4,
  2->6
]
Output: 1->1->2->3->4->4->5->6
 */
public class mergeKLists {
    public static ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0)
            return null;
        return mergeHelper(lists, 0, lists.length - 1);
    }
    private static ListNode mergeHelper(ListNode[] lists, int start, int end) {
        if (start == end)
            return lists[start];
        int mid = start + (end - start)/2;
        ListNode left = mergeHelper(lists, start, mid);
        ListNode right = mergeHelper(lists, mid + 1, end);
        return mergeTwoLists(left, right);
    }
    private static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;
        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                tail.next = list1;
                list1 = list1.next;
            } else {
                tail.next = list2;
                list2 = list2.next;
            }
            tail = tail.next;
        }
        tail.next = list1 == null ? list2 : list1;
        return dummy.next;
    }
}
