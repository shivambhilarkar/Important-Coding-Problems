package Pattern_Matching;


public class Q3_String_Matching_KMP {

    // also called as LPS - Longest Prefix Suffix
    private static int[] prefixFunction(String str) {
        int n = str.length();
        int[] LPS = new int[n];


        //for i = 1 -> length(str)
        for (int index = 1; index < n; index++) {
            int j = LPS[index - 1];

            //while not equal jump to last occurrence
            while (j > 0 && str.charAt(index) != str.charAt(j)) {
                j = LPS[j - 1];
            }

            //equal increment j pointer
            if (str.charAt(index) == str.charAt(j)) {
                j += 1;
            }

            //store current LPS == J pointer
            LPS[index] = j;
        }
        return LPS;
    }

    //trial
    // working - test with different test cases
    private static void KMPStringSearch(String str, String pattern) {
        int N = str.length();
        int M = pattern.length();

        // get LPS - Longest Prefix Suffix
        int[] lps = prefixFunction(pattern);


        int j = 0;
        int i = 0;
        //i -> 0 to length(str)
        while (i < N) {

            // both character equal then increment both pointers
            if (pattern.charAt(j) == str.charAt(i)) {
                i += 1;
                j += 1;
            }

            // j pointer == length(pattern) we found pattern
            if (j == M) {
                System.out.println("Found Pattern at index : " + (i - j));
                j = lps[j - 1]; //jump back previous lps
            } else if (i < N && pattern.charAt(j) != str.charAt(i)) {

                //jump back to previous lps point
                if (j != 0) {
                    j = lps[j - 1];
                } else {
                    //if j is already at zero then increment ith pointer only
                    i = i + 1;
                }
            }
        }
    }


    public static void main(String[] args) {

        // prefix function
        /*

        String str1 = "abcabcd";
        //[ 0,0,0,1,2,3,0]

        int[] result1 = prefixFunction(str1);
        System.out.println(Arrays.toString(result1));


        String str2 = "aabaaab";
        //[ 0,1,0,1,2,2,3]

        int[] result2 = prefixFunction(str2);
        System.out.println(Arrays.toString(result2));
         */


        //Trial

        String str = "abcabcabc";
        String pat = "abca";

        KMPStringSearch(str, pat);
    }
}





