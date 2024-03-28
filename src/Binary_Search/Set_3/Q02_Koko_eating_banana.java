package Binary_Search.Set_3;

import java.util.Scanner;

class Q02_Koko_eating_banana {
    // variation allocate minimum number of pages

    public int minEatingSpeed(int[] piles, int h) {
        int low = 1, high = 0;
        for (int i = 0; i < piles.length; i++) {
            high = Math.max(piles[i], high);
        }
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (possible(piles, mid, h)) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }

    boolean possible(int[] piles, int speed, int hours) {
        int res = 0;
        for (int i = 0; i < piles.length; i++) {
            res += piles[i] / speed;
            if (piles[i] % speed != 0)
                res++;
        }
        return res <= hours;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
    }

}