package LinkedList;

import java.util.Stack;

public class Q05_Palindrome_linkedlist {

    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    // Brute Force Solution
    class solution1 {

        public boolean isPalindrome(ListNode head) {
            Stack<Integer> stk = new Stack<>();
            get_stack(head, stk);
            while (head != null) {
                int top = stk.pop();
                if (head.val != top) {
                    return false;
                }
                head = head.next;
            }
            return true;
        }

        public void get_stack(ListNode head, Stack<Integer> stack) {
            while (head != null) {
                stack.push(head.val);
                head = head.next;
            }
        }
    }

    // Optimise Solution
    class Solution2 {
        boolean isPal = true;

        public boolean isPalindrome(ListNode head) {
            recursive(head, head);
            return isPal;
        }

        public ListNode recursive(ListNode head, ListNode curr) {
            if (curr == null || isPal == false) {
                return head;
            }

            head = recursive(head, curr.next);
            if (head.val != curr.val) {
                isPal = false;
            }
            return head.next;
        }
    }

}
