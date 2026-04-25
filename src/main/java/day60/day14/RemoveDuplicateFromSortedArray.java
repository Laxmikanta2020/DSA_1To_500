package day60.day14;

public class RemoveDuplicateFromSortedArray {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 3, 4, 4, 5, 6};

        if (arr.length == 0) return;
        int i = 0; // points to last unique element
        for (int j = 1; j < arr.length; j++) {
            if (arr[j] != arr[i]) {
                i++;
                arr[i] = arr[j];
            }
        }
        // Print unique elements
        for (int j = 0; j <= i; j++) {
            System.out.print(arr[j] + " ");
        }
    }
}
