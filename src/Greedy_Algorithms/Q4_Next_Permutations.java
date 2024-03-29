package Greedy_Algorithms;

public class Q4_Next_Permutations {

    public void nextPermutation(int[] array) {
        if (array == null || array.length == 0) return;

        int pivot = indexOfLastPeek(array) - 1;
        if (pivot != -1) {
            int nextPrefix = lastOfIndexGreaterThanPivot(array, array[pivot]);
            swap(array, pivot + 1, nextPrefix);
        }
        reverse(array, pivot + 1, array.length - 1);
    }

    //suffix decreasing - pivot element
    private int indexOfLastPeek(int[] array) {
        for (int i = array.length - 1; i > 0; i--) {
            if (array[i - 1] < array[i]) {
                return i;
            }
        }
        return 0;
    }


    //greater than pivot
    private int lastOfIndexGreaterThanPivot(int[] array, int index) {
        for (int i = array.length - 1; i > 0; i--) {
            if (array[i] > array[index]) {
                return array[i];
            }
        }
        return -1;
    }

    public void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    //reverse array
    public void reverse(int[] array, int start, int end) {
        while (start < end) {
            swap(array, start, end);
            start += 1;
            end -= 1;
        }
    }

    public static void main(String[] args) {

    }
}
