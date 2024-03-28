# Singly Linked List


- linked list is made of multiple nodes joining in linear strucutre, one after another.
- Linked List can be defined as collection of objects called nodes that are randomly stored in the memory.
- A node contains two fields i.e. data stored at that particular address and the pointer which contains the address of the next node in the memory.
- First Node called is as Head and last node is called as Tail.
- The last node of the list contains pointer to the null.

- ![Linked List](https://static.javatpoint.com/ds/images/linked-list.png)



---
## Node
- following is the structure of node. which has `data` and `next` fields.
    - `data` = stores the value of node.
    - `next` = stores the address of next node in list.
```java
class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}
```


### Linked List
- operations 
    - add at head
    - remove from head location.
    - add at tail.
    - remove from tail.
    - add between nodes.

```java
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
```