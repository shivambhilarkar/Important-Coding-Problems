package Trie;

import java.util.Arrays;

public class Q2_Maximum_XOR_With_an_Element_From_Array {

    class Node {
        Node[] links = new Node[2];

        Node() {
        }

        boolean containsKey(int index) {
            return links[index] != null;
        }

        Node get(int index) {
            return links[index];
        }

        void put(int index, Node node) {
            links[index] = node;
        }
    }

    class Trie {
        Node root;

        Trie() {
            this.root = new Node();
        }

        public void insert(int num) {
            Node node = root;
            for (int i = 31; i >= 0; i--) {
                int bit = (num >> i) & 1;
                if (!node.containsKey(bit)) {
                    node.put(bit, new Node());
                }
                node = node.get(bit);
            }
        }

        public int getMax(int num) {
            Node node = root;
            int maxNum = 0;
            for (int i = 31; i >= 0; i--) {
                int bit = (num >> i) & 1;
                if (node.containsKey(1 - bit)) {
                    maxNum = maxNum | (1 << i);
                    node = node.get(1 - bit);
                } else {
                    node = node.get(bit);
                }
            }
            return maxNum;
        }

    }

    public int[] maximizeXor(int[] nums, int[][] queries) {
        if (nums == null || nums.length == 0) {
            return nums;
        }

        int n = queries.length;
        int[][] offlineQueries = new int[n][3];

        for (int i = 0; i < n; i++) {
            int[] query = {queries[i][0], queries[i][1], i};
            offlineQueries[i] = query;
        }

        Arrays.sort(offlineQueries, (a, b) -> a[1] - b[1]);
        Arrays.sort(nums);

        int index = 0;
        int[] result = new int[n];
        Trie trie = new Trie();

        for (int i = 0; i < n; i++) {
            while (index < nums.length && nums[index] <= offlineQueries[i][1]) {
                trie.insert(nums[index]);
                index += 1;
            }

            int queryIndex = offlineQueries[i][2];
            if (index != 0) {
                int answer = trie.getMax(offlineQueries[i][0]);
                result[queryIndex] = answer;
            } else {
                result[queryIndex] = -1;
            }
        }
        return result;
    }
}
