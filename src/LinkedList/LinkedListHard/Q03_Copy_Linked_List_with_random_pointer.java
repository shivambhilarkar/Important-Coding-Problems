package LinkedList.LinkedListHard;

//https://leetcode.com/problems/copy-list-with-random-pointer/
public class Q03_Copy_Linked_List_with_random_pointer {


    class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

    class Solution {
        public Node copyRandomList(Node head) {

            Node temp = head;
            Node front = head;

            //make copy of each node in front of original node.
            while (temp != null) {
                front = temp.next;
                Node node = new Node(temp.val);
                temp.next = node;
                node.next = front;
                temp = front;
            }


            //assign random pointer for the copy nodes.
            temp = head;
            while (temp != null) {
                if (temp.random != null) {
                    temp.next.random = temp.random.next;
                }
                temp = temp.next.next;
            }

            //Restore the original list & extract the copy list.
            Node copyHead = new Node(-1);
            Node copy = copyHead;
            temp = head;
            while (temp != null) {
                front = temp.next.next;

                //extract the copy
                copy.next = temp.next;
                copy = copy.next;

                //restor original list
                temp.next = front;
                temp = front;
            }
            return copyHead.next;
        }
    }
}
