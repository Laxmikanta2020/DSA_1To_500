package com.laxmi.samal.slidingWindow;

public class MaximumSumSubArray {

    public static void main(String[] args) {
        int [] arr= {2,14,4,5,20,8,7,9,12};
        //Find the maximum sum subarray of size of k th element
        int size=3;
        int i=0,j=0,sum=0,max=0;
        while(j< arr.length){
            sum+=arr[j];
            if(j-i+1==size){// find the size let j=5 and i=2 then 5-2=3 =(0,1,2,3) so we need to add 1 because size 3 and we need 3 element
                if(sum>max){
                    max=sum;
                }
                System.out.println(sum);
                sum=sum-arr[i];
                i++;
            }
            j++;

        }
        System.out.println(max);

    }
}

//Laxmikanta-05/10/2025-Bengaluru/hoodi