package DS_Implementations.HashSet;

import java.util.Scanner;

class HashSet {
    static boolean[] array;
    static int lastmax = 0;

    HashSet() {
        array = new boolean[100000];
    }

    public void add(int val) {
        array[val] = true;
        lastmax = Math.max(lastmax, val);
    }

    public void remove(int val) {
        array[val] = false;
    }

    public boolean contains(int val) {
        if (array[val]) {
            System.out.println("Contains...");
            return true;
        } else {
            System.out.println("Not Contains...");
            return false;
        }
    }

    public void display() {
        System.out.print("HashSet : ");
        for (int i = 0; i <= lastmax; i++) {
            if (array[i] == true) {
                System.out.print(i + ",");
            }
        }
    }

}


public class Hashset_implementation_for_Numbers {


    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        HashSet set = new HashSet();
        set.add(1);
        set.add(2);
        set.add(7);
        set.add(4);
        set.add(5);

        set.contains(6);
        set.display();
    }
}
