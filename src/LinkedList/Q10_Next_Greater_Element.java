package LinkedList;

import java.util.ArrayList;
import java.util.Stack;

public class Q10_Next_Greater_Element {
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
        public int[] nextLargerNodes(ListNode head) {
            // convert linkedlist into arraylist
            ArrayList<Integer> lst = new ArrayList<>();
            while (head != null) {
                lst.add(head.val);
                head = head.next;
            }
            int[] array = new int[lst.size()];
            Stack<Integer> stack = new Stack<>();
            // Monotonic stack algo -> next greate element
            for (int right = 0; right < lst.size(); right++) {
                while (!stack.isEmpty() && lst.get(stack.peek()) < lst.get(right)) {
                    int index = stack.pop();
                    array[index] = lst.get(right);
                }
                stack.push(right);
            }
            while (stack.isEmpty() == false) {
                array[stack.pop()] = 0;
            }
            return array;
        }
    }

}
