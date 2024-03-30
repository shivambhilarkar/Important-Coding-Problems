package BitManipulation;

public class Q1_Find_element_which_occurrence_single_time {

    public static int singleOccurrence(int[] input){
        int n = input.length;

        // XOR all the elements:
        int xorr = 0;
        for (int i = 0; i < n; i++) {
            xorr = xorr ^ input[i];
        }
        return xorr;
    }

    public static void main(String[] args) {
        int[] input = {4, 1, 2, 1, 2};
        //output 4
        int result = singleOccurrence(input);
        System.out.println("Result : "+ result);
    }
}
