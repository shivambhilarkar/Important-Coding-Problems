package LinkedList;

import java.util.Stack;

//  * Definition for singly-linked list.

public class Q01_Reverse_linked_list {

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

    class Solution {
        public ListNode reverseList(ListNode head) {
            // Brute force

            Stack<Integer> stack = new Stack<>();
            ListNode temp = head;
            while (temp != null) {
                stack.push(temp.val);
                temp = temp.next;
            }
            ListNode newHead = new ListNode(0);// dummy head;
            ListNode tp = newHead;
            while (stack.isEmpty() == false) {
                tp.next = new ListNode(stack.pop());
                tp = tp.next;
            }
            return newHead.next;

        }
    }
    // optimise approcha o(1)

    class Solution2 {
        public ListNode reverseList(ListNode head) {
            if (head == null)
                return head;

            ListNode prevNode = null;
            ListNode nextNode = null;
            ListNode currNode = head;

            while (currNode != null) {
                nextNode = currNode.next;
                currNode.next = prevNode;
                prevNode = currNode;
                currNode = nextNode;
            }
            return prevNode;
        }
    }

}