package DS_Implementations.LinkedList;


import java.util.Scanner;


//Singly LinkedList Node
class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}


//Singly Linked List
class LinkedList {

    private Node head;

    LinkedList() {
    }

    public void add_at_head(int val) {
        Node node = new Node(val);
        if (head == null) {
            head = node;
        } else {
            node.next = head;
            head = node;
        }
    }

    public void add_at_tail(int val) {
        Node node = new Node(val);
        if (head == null) {
            head = node;
        } else {
            Node temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = node;
        }
    }

    public void delete_from_front() {
        if (head == null) {
            System.out.println("Underflow....");
        } else {
            int deleted = head.data;
            head = head.next;
            System.out.println("Deleted Front: " + deleted);
        }
    }

    public void delete_from_last() {
        if (head == null) {
            System.out.println("Underflow....");
        } else {
            Node temp = head;
            while (temp.next.next != null) {
                temp = temp.next;
            }
            int deleted = temp.next.data;
            temp.next = null;
            System.out.println("Deleted Last : " + deleted);
        }
    }

    public void remove_value_node(int val) {
        Node temp = head;
        if (head == null) {
            System.out.println("Underflow....");
            return;
        }
        while (head.data == val) {
            head = head.next;
        }

        while (temp.next != null) {
            if (temp.next.data == val) {
                temp.next = temp.next.next;
            } else {
                temp = temp.next;
            }
        }
    }

    public void display_list() {
        Node temp = head;
        System.out.print("Linked List : ");
        while (temp != null) {
            System.out.print(temp.data + "  ");
            temp = temp.next;
        }
        System.out.println();
    }


}

public class SinglyLinkedList {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        LinkedList list = new LinkedList();
        //add head
        list.add_at_head(10);
        list.add_at_head(20);
        list.add_at_head(30);
        list.add_at_head(40);
        list.display_list();

        //add tail
        list.add_at_tail(50);
        list.add_at_tail(60);
        list.display_list();

        //delete head
        list.delete_from_front();
        list.display_list();

        //delete last
        list.delete_from_last();
        list.display_list();

        //remove specific node
        list.remove_value_node(10);
        list.display_list();

        list.add_at_head(20);
        list.add_at_head(20);
        list.add_at_head(20);
        list.add_at_head(30);
        list.display_list();

        list.remove_value_node(20);
        list.display_list();
    }
}


