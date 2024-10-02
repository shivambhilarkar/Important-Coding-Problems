package Trie;


import java.util.Arrays;
import java.util.Scanner;

public class Q1_Trie_First {


    //Trie Node
    static class Node {
        Node[] children = new Node[26];
        boolean isEndOfWord;

        Node() {
            isEndOfWord = false;
            for (int i = 0; i < 26; i++) {
                children[i] = null;
            }
            // can be written as Arrays.fill(children, null);
        }
    }


    //Trie DataStructure
    static class Trie {

        Node root;

        Trie() {
            root = new Node();
        }

        public void insert(String word) {
            int len = word.length();
            Node temp = root;
            for (int i = 0; i < len; i++) {
                int index = word.charAt(i) - 'a';
                if (temp.children[index] == null) {
                    temp.children[index] = new Node();
                }
                temp = temp.children[index];
            }
            temp.isEndOfWord = true;
        }

        public void search(String word) {
            int len = word.length();
            Node temp = root;
            for (int i = 0; i < len; i++) {
                int index = word.charAt(i) - 'a';
                if (temp.children[index] == null) {
                    System.out.println("Word Is Not found!!! ");
                    return;
                }
                temp = temp.children[index];
            }

            if (temp != null && temp.isEndOfWord == true) {
                System.out.println("Word Found");
            } else {
                System.out.println("Word Not Found!!!");
            }
        }
    }


    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        Trie trie = new Trie();

        String[] dictionary = {"he", "she", "they", "there", "their", "them"};
        for (String str : dictionary) {
            trie.insert(str);
        }

        trie.search("him");
        trie.search("he");
    }

}
