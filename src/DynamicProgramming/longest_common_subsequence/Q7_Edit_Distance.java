package DynamicProgramming.longest_common_subsequence;

public class Q7_Edit_Distance {

    public int minDistance(String word1, String word2) {
        int len1 = word1.length();
        int len2 = word2.length();
        if (len1 == 0 || len2 == 0) {
            return Math.abs(len1 - len2);
        }
        //already equal
        if (word1.equals(word2)) {
            return 0;
        }
        int[][] store = new int[len1 + 1][len2 + 1];
        int row = store.length;
        int col = store[0].length;
        //first col
        for (int i = 0; i < row; i++) {
            store[i][0] = i;
        }
        //first row;
        for (int j = 0; j < col; j++) {
            store[0][j] = j;
        }

        //remaining part
        char[] str1 = word1.toCharArray();
        char[] str2 = word2.toCharArray();
        for (int i = 1; i < row; i++) {
            for (int j = 1; j < col; j++) {
                if (str1[i - 1] == str2[j - 1]) {
                    store[i][j] = store[i - 1][j - 1];
                } else {
                    int insert = store[i - 1][j];
                    int delete = store[i][j - 1];
                    int replace = store[i - 1][j - 1];
                    store[i][j] = Math.min(replace, Math.min(insert, delete)) + 1;
                }
            }
        }
        int minNumberOperation = store[row - 1][col - 1];
        return minNumberOperation;
    }


}
