package DS_Implementations.SegmentTree;

/**
 * construct segment tree for Range Sum
 */

class SegmentTree {

    private int size;
    private int[] segTree;

    public SegmentTree(int[] inputArray) {
        this.size = inputArray.length;
        this.segTree = new int[size * 4];
        construct(0, size - 1, inputArray, 0);
    }

    private int construct(int low, int high, int[] input, int position) {
        if (low == high) {
            segTree[position] = input[low];
            return segTree[position];
        }

        int mid = (low + high) / 2;
        int leftSubtree = construct(low, mid, input, position * 2 + 1);
        int rightSubtree = construct(mid + 1, high, input, position * 2 + 2);

        segTree[position] = leftSubtree + rightSubtree;
        return segTree[position];
    }

    public void update(int index, int value) {
        updateSegTree(0, size - 1, index, value, 0);
    }

    private int updateSegTree(int low, int high, int indexToUpdate, int value, int position) {
        if (indexToUpdate < low || indexToUpdate > high) {
            return segTree[position];
        }

        if (indexToUpdate == low && indexToUpdate == high) {
            segTree[position] = value;
            return segTree[position];
        }

        int mid = (low + high) / 2;
        int leftSubTree = updateSegTree(low, mid, indexToUpdate, value, position * 2 + 1);
        int rightSubTree = updateSegTree(mid + 1, high, indexToUpdate, value, position * 2 + 2);

        segTree[position] = leftSubTree + rightSubTree;
        return segTree[position];
    }


    public void query(int queryStart, int queryEnd) {
        rangeSum(0, size - 1, queryStart, queryEnd, 0);
    }

    private int rangeSum(int low, int high, int queryStart, int queryEnd, int position) {
        if (queryEnd < low || queryStart > high) {
            return 0;
        }

        if (queryStart <= low && queryEnd >= high) {
            return segTree[position];
        }
        int mid = (low + high) / 2;
        int leftSubTree = rangeSum(low, mid, queryStart, queryEnd, position * 2 + 1);
        int rightSubTree = rangeSum(mid + 1, high, queryStart, queryEnd, position * 2 + 2);

        segTree[position] = leftSubTree + rightSubTree;
        return segTree[position];
    }
}


public class Segment_Tree {

    public static void main(String[] args) {

        SegmentTree segmentTree = new SegmentTree(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9});
    }

}
