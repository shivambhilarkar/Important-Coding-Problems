package DS_Implementations.Queue;

import java.util.Arrays;
import java.util.Scanner;


class Queue {
    static int[] array;
    static int front = 0;
    static int back = 0;
    static int size = 0;
    static int capacity = 10;

    Queue() {
        array = new int[capacity]; //default size of queue
    }

    Queue(int val) {
        capacity = val;
        array = new int[val];
    }

    public void add(int value) {
        if (size == capacity) {
            System.out.println("Queue Overflowed...");
        } else {
            size += 1;
            array[back] = value;
            back = (++back) % (capacity - 1);   //this will allow to come at front circularly
        }
    }

    public void remove() {
        if (size == 0) {
            System.out.println("Queue Under flowed...");
        } else {
            size -= 1;
            int value = array[front];
            array[front] = 0;
            front = (++front) % (capacity - 1);  //this will allow to come at front circularly
            System.out.println("Removed : " + value);
        }
    }

    public void isEmpty() {
        if (size == 0) {
            System.out.println("Queue is Empty..");
        } else {
            System.out.println("Queue is Not Empty...");
        }
    }

    public void display_queue() {

        System.out.println("Queue : " + Arrays.toString(array));
        System.out.println("Start At : " + front + " -> End At : " + back);

    }

}

public class Queue_Using_array {


    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);


        Queue queue = new Queue();

        queue.isEmpty();
        queue.add(10);
        queue.add(20);
        queue.add(30);
        queue.add(40);
        queue.add(50);

        queue.display_queue();

        queue.remove();
        queue.remove();
        queue.display_queue();
        queue.isEmpty();


    }
}
