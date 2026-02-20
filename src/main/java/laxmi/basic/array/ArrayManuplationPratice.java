package laxmi.basic.array;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class ArrayManuplationPratice {

    public static void main(String[] args) {

        int[] arr={1,2,3,4,7,8,5};

        int totalSum=0;

        for(int i=0; i<arr.length; i++){
            for(int j=i; j<arr.length; j++){
                int subArraySum=0;
                for(int k=i; k<=j; k++) {
                    subArraySum += arr[k];
                }
                totalSum+=subArraySum;
            }
        }
        System.out.println(totalSum);

        int k=3;
        int windowSum=0;
        int maxSum=0;
        for(int i=0; i<k; i++){
            windowSum+=arr[k];
        }
        maxSum=windowSum;
        for(int i=k; i<arr.length; i++ ){
          windowSum= windowSum-arr[i-k]+arr[i];
          maxSum=Math.max(maxSum,windowSum);
        }

        System.out.println(maxSum);

        //===================================

        String str = "aabcdbefgh";

        int maxLength = 0;
        int n = str.length();
        int left = 0;

        Set<Character> set = new HashSet<>();

        for (int right = 0; right < n; right++) {

            while (set.contains(str.charAt(right))) {
                set.remove(str.charAt(left));
                left++;
            }

            set.add(str.charAt(right));
            maxLength = Math.max(maxLength, right - left + 1);
        }

        System.out.println(maxLength);

    }
}
