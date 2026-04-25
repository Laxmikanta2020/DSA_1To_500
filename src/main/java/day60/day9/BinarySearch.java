package day60.day9;

public class BinarySearch {
    public static void main(String[] args) {

        int[] arr = {1, 4, 6, 8, 12, 23, 44, 50};
        int left = 0;

        int right = arr.length - 1;
        int target = 12;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] == target) {
                System.out.println("Found at index: " + mid);
                return;
            } else if (arr[mid] < target) {
                left = mid + 1;                   // fix 3 (direction)
            } else {
                right = mid - 1;                  // fix 3 (direction)
            }
        }
        System.out.println("Not found");
    }
}