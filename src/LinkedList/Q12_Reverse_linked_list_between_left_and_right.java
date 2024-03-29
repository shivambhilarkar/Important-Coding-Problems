package LinkedList;

public class Q12_Reverse_linked_list_between_left_and_right {

    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (head == null) return null;

        ListNode dummy = new ListNode(0);
        dummy.next = head;

        //first half
        ListNode curr1 = dummy;
        ListNode pre1 = null;
        for (int i = 0; i < left; i++) {
            pre1 = curr1;
            curr1 = curr1.next;
        }

        //reverse
        ListNode curr2 = curr1;
        ListNode prev2 = pre1;
        for (int i = left; i <= right; i++) {
            ListNode next = curr2;
            curr2.next = prev2;
            prev2 = curr2;
            curr2 = next;
        }

        //connect
        pre1.next = prev2;
        curr1.next = curr2;

        return dummy.next;
    }


    public static void main(String[] args) {

    }
}
