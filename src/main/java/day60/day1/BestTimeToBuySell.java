package day60.day1;

public class BestTimeToBuySell {
    public static void main(String[] args) {
        // There two type
        //1) one difference
        // we can take multiple
        int[] prices = {7, 1, 5, 3, 6, 4};
        int i = 0;
        int max = 0;
        for (int j = 1; j < prices.length; j++) {
            if (prices[i] < prices[j]) {
                max = Math.max(max, prices[j] - prices[i]);
                 // if it multiple
                //max+= Math.max(max, prices[j] - prices[i]);
            } else {
                i = j;
            }
        }
        System.out.println(max);
    }
}
