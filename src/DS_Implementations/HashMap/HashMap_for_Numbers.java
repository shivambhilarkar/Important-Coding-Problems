package DS_Implementations.HashMap;

import java.util.Scanner;


class Pair {
    int key;
    int value;

    Pair(int key, int value) {
        this.key = key;
        this.value = value;
    }
}

class Hashmap {


    static Pair[] map;
    static int lastmax = 0;

    Hashmap() {
        map = new Pair[100001];
    }

    public void add(int k) {
        if (map[k] == null) {
            map[k] = new Pair(k, 1);
        } else {
            Pair pair = map[k];
            int val = pair.value;
            map[k] = new Pair(k, val + 1);
        }
        lastmax = Math.max(k, lastmax);
    }

    public void put(int k, int v) {
        Pair pair = new Pair(k, v);
        map[k] = pair;
        lastmax = Math.max(k, lastmax);
    }

    public void remove(int k) {
        map[k] = null;
    }

    public boolean containsKey(int k) {
        if (map[k] != null) {
            System.out.println("True");
            return true;
        } else {
            System.out.println("False");
            return false;
        }
    }

    public void display() {
        System.out.println("HashMap : ");
        for (int i = 0; i <= lastmax; i++) {
            if (map[i] != null) {
                System.out.println("[" + map[i].key + "->" + map[i].value + "]");
            }
        }
    }
}


public class HashMap_for_Numbers {


    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        Hashmap map = new Hashmap();

        map.add(1);
        map.add(2);
        map.add(3);
        map.add(2);
        map.add(3);
        map.add(1);
        map.add(2);
        map.add(3);

        map.display();
    }
}
