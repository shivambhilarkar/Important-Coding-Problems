# Priority Queue : ( Heap )

- A priority queue is an abstract data type that behaves similarly to the normal queue except that each element has some priority, i.e., the element with the highest priority would come first in a priority queue. 
- The priority of the elements in a priority queue will determine the order in which elements are removed from the priority queue.
- Types of Priority Queue.
    - Min Priority Queue ( Min Heap)
        - small element has the highest priority ie. smallest element will be removed first from queue.
    - Max Priority Queue ( Max Heap)
        - large element has the highest priority ie. largest element will be removed first from queue.
- Priority Queue can be represented using complete binary tree.and satisfies the heap property. 
- If A is a parent node of B, then A is ordered with respect to the node B for all nodes A and B in a heap. 
- It means that the value of the parent node could be more than or equal to the value of the child node, or the value of the parent node could be less than or equal to the value of the child node.
---
 - ![Min Heap](https://static.javatpoint.com/ds/images/ds-priority-queue6.png)
---
 - ![Max Heap](https://static.javatpoint.com/ds/images/ds-priority-queue5.png)
---

## Min Priority queue implementation
```java
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

```
