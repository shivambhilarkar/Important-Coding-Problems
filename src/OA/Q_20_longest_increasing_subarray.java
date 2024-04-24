package OA;

public class Q_20_longest_increasing_subarray {

    public long lenOfLongIncSubArr(long arr[], long n) {

        int result = 1;
        int current = 1;

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > arr[i - 1]) {
                current += 1;
            } else {
                result = Math.max(result, current);
                current = 1;
            }
        }
        result = Math.max(result, current);
        return result;


    }


    public static void main(String[] args) {


        /**
         * Input : arr[] = {5, 6, 3, 5, 7, 8, 9, 1, 2} Output : 5 The subarray is {3, 5, 7, 8, 9}
         *
         * Input : arr[] = {12, 13, 1, 5, 4, 7, 8, 10, 10, 11} Output : 4 The subarray is {4, 7, 8, 10}
         */
    }
}
