
// LeetCode 141. Linked List Cycle
// https://leetcode.com/problems/linked-list-cycle/
// Definition for singly-linked list.
//Time Complexity : O(n)


public class Solution {

    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                return true;
            }
        }
        return false;
    }

}
/**
 * This code defines a method to detect if a linked list has a cycle using the Floyd's Tortoise and Hare algorithm.
 * It uses two pointers, one moving at normal speed (slow) and the other moving at double speed (fast).
 * If there is a cycle, the two pointers will eventually meet; otherwise, the fast pointer will reach the end of the list.
 */