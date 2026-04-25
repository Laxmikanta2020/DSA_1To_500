package day60.day10;

public class RemoveDuplicates {

    public static void main(String[] args) {
        int[] nums = {1, 1, 2, 2, 3, 4, 4};

        if (nums.length == 0)
            return;
        int i = 0; // last unique index
        for (int j = 1; j < nums.length - 1; j++) {
            if (nums[j] != nums[i]) {
                i++;
                nums[i] = nums[j];
            }
        }
        for (int x = 0; x <= i; x++) {
            System.out.println(nums[x]);

        }

    }
}
