package OA;


import java.util.*;

/**
 * 819. Most Common Word
 * Given a paragraph and a list of banned words, return the most frequent word that is not in the list of banned words.
 * It is guaranteed there is at least one word that isn't banned, and that the answer is unique.
 *----------------------
 * Words in the list of banned words are given in lowercase, and free of punctuation. Words in the paragraph are not
 * case-sensitive. The answer is in lowercase.
 *-----------------------------
 * Example:
 * Input:
 * paragraph = "Bob hit a ball, the hit BALL flew far after it was hit."
 * banned = ["hit"]
 * Output: "ball"
 * Explanation:
 * "hit" occurs 3 times, but it is a banned word.
 * "ball" occurs twice (and no other word does), so it is the most frequent non-banned word in the paragraph.
 * Note that words in the paragraph are not case-sensitive,
 * that punctuation is ignored (even if adjacent to words, such as "ball,"),
 * and that "hit" isn't the answer even though it occurs more because it is banned.
 */
public class Q_09_Most_Common_word {


    public static String mostCommonWord(String paragraph, String[] banned){

        Set<String> bannedWords = new HashSet<>(Arrays.asList(banned));

        TreeMap<String,Integer> wordCounter = new TreeMap<>();

        String[] words = paragraph.split("[\\s,.]");
        //System.out.println(Arrays.toString(words));

        for(String word : words){
            word = word.toLowerCase();
            if(!bannedWords.contains(word)){
                wordCounter.put(word, wordCounter.getOrDefault(word, 0)+ 1);
            }
        }

        System.out.println(wordCounter);
        String maxWord = "";
        int maxCount = 0;
        for(Map.Entry<String, Integer> entry : wordCounter.entrySet()){
            if(entry.getValue() >= maxCount){
                maxCount = entry.getValue();
                maxWord = entry.getKey();
            }
        }
        return maxWord;
    }


    public static void main(String[] args) {
        String paragraph = "Bob hit a ball, the hit BALL flew far after it was hit.";
        String[] bannedWords = {"hit"};


        String result = mostCommonWord(paragraph, bannedWords);
        System.out.println("Result : "+ result);
    }


}
