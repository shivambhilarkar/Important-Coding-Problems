package Trees;/* package whatever; // don't place package name! */

import java.util.Arrays;
import java.util.Scanner;

/* Name of the class has to be "Main" only if the class is public. */
class Main {
    public static int getcount(int day, int[] minday, int[] maxday) {

        int counter = 0;
        for (int i = 0; i < minday.length; i++) {
            if (day > minday[i] && day < maxday[i]) {
                counter += 1;
            }
        }
        return counter;
    }

    public static void main(String[] args) throws Exception {
        // your code goes here

        Scanner scan = new Scanner(System.in);
        // int n = scan.nextInt();
        // int[] arr = new int[n];
        // for (int i = 0; i < n; i++) {
        // arr[i] = scan.nextInt();
        // }

        int[] arr = { 1, 0, 3, 6, 2, 5 };
        int n = arr.length;

        int[] minday = new int[n];
        int[] maxday = new int[n];

        // int x = scan.nextInt();
        // int y = scan.nextInt();
        int x = 1;
        int y = 3;
        for (int i = 0; i < arr.length; i++) {
            minday[i] = arr[i] + x;
            maxday[i] = arr[i] + y;
        }

        // int queries = scan.nextInt();
        int[] queriesarr = { 1, 2, 6, 4 };
        System.out.println(Arrays.toString(minday));
        System.out.println(Arrays.toString(maxday));
        for (int i = 0; i < queriesarr.length; i++) {
            int day = queriesarr[i];
            int count = getcount(day, minday, maxday);
            System.out.println(count);
        }

    }
}
