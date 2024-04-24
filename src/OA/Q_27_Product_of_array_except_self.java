package OA;

public class Q_27_Product_of_array_except_self {

    public int[] productExceptSelf(int[] nums) {

        int[] prefix = new int[nums.length];
        prefix[0] = nums[0];
        for (int i = 1; i < prefix.length; i++) {
            prefix[i] = prefix[i - 1] * nums[i];
        }
        // System.out.println(Arrays.toString(prefix));

        int[] suffix = new int[nums.length];
        suffix[nums.length - 1] = nums[nums.length - 1];
        for (int i = nums.length - 2; i >= 0; i--) {
            suffix[i] = suffix[i + 1] * nums[i];
        }
        // System.out.println(Arrays.toString(suffix));


        int[] result = new int[nums.length];
        result[0] = suffix[1];
        result[result.length - 1] = prefix[result.length - 2];
        for (int i = 1; i < result.length - 1; i++) {
            result[i] = prefix[i - 1] * suffix[i + 1];
        }

        // System.out.println(Arrays.toString(result));
        return result;

    }

    public static void main(String[] args) {

    }
}
