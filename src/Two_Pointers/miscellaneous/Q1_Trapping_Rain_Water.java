package Two_Pointers.miscellaneous;

public class Q1_Trapping_Rain_Water {

    public int trap(int[] height) {
        if (height == null || height.length == 0) {
            return 0;
        }

        int n = height.length;
        //left boundary
        int[] leftBoundary = new int[n];
        leftBoundary[0] = height[0];
        for (int i = 1; i < n; i++) {
            leftBoundary[i] = Math.max(leftBoundary[i - 1], height[i]);
        }

        //right boundary
        int[] rightBoundary = new int[n];
        rightBoundary[n - 1] = height[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            rightBoundary[i] = Math.max(rightBoundary[i + 1], height[i]);
        }

        int result = 0;
        for (int i = 0; i < n; i++) {
            int water = Math.min(leftBoundary[i], rightBoundary[i]);
            result += (water - height[i]);
        }
        return result;
    }


}
