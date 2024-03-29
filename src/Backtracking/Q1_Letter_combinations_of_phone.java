package Backtracking;

import java.util.ArrayList;
import java.util.List;

public class Q1_Letter_combinations_of_phone {


    //phone numpad with digit codes.
    final private String[] digitCodes = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

    public List<String> getLetterCombinations(String digits) {
        if (digits == null || digits.isEmpty()) {
            return new ArrayList<>();
        }

        List<String> result = new ArrayList<>();
        getCombinations(digits, "", result);
        return result;
    }

    private void getCombinations(String digits, String path, List<String> result) {
        if (digits.length() == 0) {
            result.add(path);
            return;
        }

        char digit = digits.charAt(0);
        String remainingDigits = digits.substring(1);
        String codeForDigit = digitCodes[digit - '0'];
        for (char code : codeForDigit.toCharArray()) {
            getCombinations(remainingDigits, path + code, result);
        }
    }


    public static void main(String[] args) {

    }
}
