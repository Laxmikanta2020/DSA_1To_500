package laxmi.basic.array;

public class SubArray {
    public static void main(String[] args) {
        int [] arr= {1,2,3,4};

        for(int i=0;i<arr.length;i++){
            for(int j=0;j<=i;j++){
                System.out.print(arr[j]);
            }
            System.out.println();
        }
    }
}

//