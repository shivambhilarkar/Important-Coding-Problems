package DS_Implementations.Heap;

import java.util.ArrayList;
import java.util.Scanner;

class Priority_Queue {
    static ArrayList<Integer> heap;

    Priority_Queue() {
        heap = new ArrayList<>();
    }

    public void add(int val) {
        heap.add(val);
        upheapify(heap.size() - 1);
    }

    private void upheapify(int index) {
        if (index == 0) {
            return;
        }
        int parent = (index - 1) / 2;
        if (heap.get(index) < heap.get(parent)) {
            swap(index, parent);
            upheapify(parent);
        }
    }

    public void swap(int child, int parent) {
        int ch = heap.get(child);
        int pr = heap.get(parent);

        heap.set(child, pr); //swapping in arraylist
        heap.set(parent, ch);
    }

    public int remove() {
        if (heap.size() == 0) {
            System.out.println("Heap Underflow...");
            return -1;
        }
        swap(0, heap.size() - 1);
        int val = heap.remove(heap.size() - 1);
        downheapify(0);
        System.out.println("Removed : " + val);
        return val;
    }

    private void downheapify(int index) {
        int min_index = index;
        int left_child = index * 2 + 1;
        int right_child = index * 2 + 2;

        if (left_child < heap.size() && heap.get(left_child) < heap.get(index)) {
            min_index = left_child;
        }
        if (right_child < heap.size() && heap.get(right_child) < heap.get(index)) {
            min_index = right_child;
        }

        if (min_index != index) {
            swap(index, min_index);
            downheapify(min_index);
        }
    }

    public void size() {
        System.out.println(heap.size());
    }

    public void display() {
        System.out.println("Heap : " + heap);
    }
}


//Min Priority Queue  or Min Heap
public class Priority_Queue_Min_Queue {


    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        Priority_Queue queue = new Priority_Queue();

        queue.add(8);
        queue.add(5);
        queue.add(7);
        queue.add(4);
        queue.add(1);
        queue.add(6);
        queue.add(3);
        queue.add(2);

        queue.display();
    }
}
