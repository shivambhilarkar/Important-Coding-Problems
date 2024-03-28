package LinkedList;

public class Q08_Add_Two_Number_I_ {
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
        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

            ListNode head = new ListNode(-1);
            ListNode temp = head;
            int carry = 0;
            while (l1 != null || l2 != null || carry != 0) {
                if (l1 != null) {
                    carry += l1.val;
                    l1 = l1.next;
                }
                if (l2 != null) {
                    carry += l2.val;
                    l2 = l2.next;
                }

                ListNode node = new ListNode(carry % 10);
                temp.next = node;
                temp = temp.next;
                carry = carry / 10;
            }
            return head.next;
        }
    }

}
