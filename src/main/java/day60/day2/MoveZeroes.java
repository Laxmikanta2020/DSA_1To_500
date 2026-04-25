package day60.day2;

import java.util.Arrays;

public class MoveZeroes {

    public static void main(String[] args) {

        int[] nums = {5, 0, 1, 0, 3, 12, 0, 2, 9, 8};
        int i = 0;
        for (int j = 0; j < nums.length; j++) {
            if (nums[j] != 0) {// it is starting if you want to end we can used !=0
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
                i++;
            }
        }
        System.out.println(Arrays.toString(nums));
    }

}
