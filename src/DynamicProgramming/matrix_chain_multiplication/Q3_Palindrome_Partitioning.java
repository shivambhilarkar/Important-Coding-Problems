package DynamicProgramming.matrix_chain_multiplication;

//https://leetcode.com/problems/palindrome-partitioning-ii/
//https://leetcode.com/problems/palindrome-partitioning-ii/solutions/1364206/mcm-pattern-in-aditya-verma-format-with-some-optimizations-all-tc-passed-memoization-1-d-dp/
public class Q3_Palindrome_Partitioning {

    private int recursive(String str, int i, int j) {
        if (i >= j) {
            return 0;
        }
        if (isPalindrome(str, i, j)) {
            return 0;
        }

        int result = Integer.MAX_VALUE;
        for (int k = i; k < j; k++) {
            int answer = recursive(str, i, k) + recursive(str, k + 1, j) + 1;
            result = Math.min(answer, result);
        }
        return result;
    }

    private boolean isPalindrome(String s, int i, int j) {
        while (i < j) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }


    public int memoization(String str, int i, int j, int[] memo) {
        if (i >= j) {
            return 0;
        }
        if (isPalindrome(str, i, j)) {
            return 0;
        }
        if (memo[i] != 0) {
            return memo[i];
        }

        int result = Integer.MAX_VALUE;
        for (int k = i; k < j; k++) {

            if (isPalindrome(str, i, k)) {
                int answer = memoization(str, k + 1, j, memo) + 1;
                result = Math.min(result, answer);
            }
        }
        memo[i] = result;
        return result;
    }


    public int minCut(String s) {
        if (s == null) return 0;

        // int result = recursive(s, 0, s.length()-1);
        // return result;

        int[] memo = new int[s.length() + 1];
        int result = memoization(s, 0, s.length() - 1, memo);
        return result;
    }
}
