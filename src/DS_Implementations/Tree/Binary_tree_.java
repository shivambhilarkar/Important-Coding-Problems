package DS_Implementations.Tree;

import java.util.Scanner;

class Node {
    int data;
    Node left;
    Node right;

    Node(int val, Node left, Node right) {
        this.data = val;
        this.left = left;
        this.right = right;
    }
}

class Binary_Tree {

    private Node root;

    Binary_Tree() {
        root = null;
    }

    public Node constructor(int[] arr, int high, int low) {
        if (low > high) {
            return null;
        }
        int mid = (low + high) / 2;
        int data = arr[mid];
        Node left_child = constructor(arr, low, mid - 1);
        Node right_child = constructor(arr, mid + 1, high);
        Node node = new Node(data, left_child, right_child);
        return node;
    }

    public void display() {
        preorderPrint(root);
    }

    private void preorderPrint(Node node) {
        if (node == null) {
            return;
        }
        String str = "";
        str += node.left == null ? "." : node.left.data;
        str += " <- " + node.data + " -> ";
        str += node.right == null ? "." : node.right.data;
        System.out.println(str);

        preorderPrint(node.left);
        preorderPrint(node.right);
    }
}


public class Binary_tree_ {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int[] arr = {12, 25, 37, 50, 62, 75, 87};
        int high = arr.length - 1;
        int low = 0;

        Binary_Tree tree = new Binary_Tree();
        tree.constructor(arr, low, high);
        tree.display();
    }
}
