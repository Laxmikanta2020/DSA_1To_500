package laxmi.basic.array;

public class FindSubArray {

    public static void main(String[] args) {

        int[] arr = {1, 4, 20, 3, 10, 5};
        int target = 33;

        int sum = 0;
        int j = 0;
        for (int i = 0; i < arr.length; i++) {

            sum += arr[i];
            if (sum > target) {
                while (target < sum) {
                    sum = sum - arr[j];
                    j++;
                }
            }

            if (sum == target) {
                System.out.println("Subarray found from index "
                        + j + " to " + i);
                return;
            }
        }
    }
}
