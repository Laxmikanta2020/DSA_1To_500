package day60.day2;

import java.util.Arrays;

public class ProductExceptSelf {
    public static void main(String[] args) {
        //int[]{1, 2, 3, 4})));  // [24, 12, 8, 6]
        int[] nums = {1, 2, 3, 4};
        int value = 1;
//        for (int i = 0; i < nums.length; i++) {
//            value = value * nums[i];
//        }
//        System.out.println(value);
//        for (int i = 0; i < nums.length; i++) {
//            nums[i] = value / nums[i];
//        }
//        System.out.println(Arrays.toString(nums));
        // but in question already told the not used / operator
        nums = new int[]{1, 2, 3, 4};
        int n = nums.length;
        int[] result = new int[n];
        // Left pass: result[i] = product of all elements to the left
        int prefix = 1;
        for (int i = 0; i < n; i++) {
            result[i] = prefix;
            prefix *= nums[i];
        }
        System.out.println(Arrays.toString(nums));
        System.out.println(Arrays.toString(result));
        int suffix = 1;
        for (int i = n - 1; i >= 0; i--) {
            result[i] *= suffix;
            suffix *= nums[i];
        }
        System.out.println(Arrays.toString(result));
    }
}
