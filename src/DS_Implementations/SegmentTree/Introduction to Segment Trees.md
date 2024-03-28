
# Segment Tree

- Segment Tree is used in cases where there are multiple range queries on array and modifications of elements of the same array. 
- For example, finding the sum of all the elements in an array from indices left to right.
-  or finding the minimum (famously known as Range Minimum Query problem) of all the elements in an array from indices left to right. 
These problems can be easily solved with one of the most versatile data structures, Segment Tree.

---


## Build Segment Tree
- here we are building segment tree for sum (Range Sum Query) , hence we will add the result from left & right subtree to parent node ie. ` segmentTree[position] = leftSubTree + rightSubTree`.
- if we want to build minimum segment tree ( Range Minimum Query) then we will just simple take ` min( leftSubTree, rightSubtree) `


```java
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
    

```


## Update Segment Tree

```java

    public void update(int index, int value) {
        updateSegTree(0, size - 1, index, value, 0);
    }

    private int updateSegTree(int low, int high, int indexToUpdate, int value, int position) {
        //out of range 
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

```


## Perform Query on Segment Tree

```java

    public void query(int queryStart, int queryEnd) {
        rangeSum(0, size - 1, queryStart, queryEnd, 0);
    }

    private int rangeSum(int low, int high, int queryStart, int queryEnd, int position) {
        //out of range
        if (queryEnd < low || queryStart > high) {
            return 0;
        }
        //lies inside given range
        if (queryStart <= low && queryEnd >= high) {
            return segTree[position];
        }

        int mid = (low + high) / 2;
        int leftSubTree = rangeSum(low, mid, queryStart, queryEnd, position * 2 + 1);
        int rightSubTree = rangeSum(mid + 1, high, queryStart, queryEnd, position * 2 + 2);

        segTree[position] = leftSubTree + rightSubTree;
        return segTree[position];
    }


```