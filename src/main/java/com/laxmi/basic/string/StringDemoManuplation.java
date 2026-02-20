package com.laxmi.basic.string;

public class StringDemoManuplation {

    public static void main(String[] args) {

        String str="Laxmikant Samal";
        System.out.println(findLength(str));

        String str2="gfaklberc";
        String str3="abc";

        System.out.println(isSubSequence(str2,str3));

    }

   private static boolean isSubSequence(String str2, String str3){

        int j=0;
        int i=0;

        while(str2.length()>i && str3.length()>j){

            if(str2.charAt(i)==str3.charAt(j)){
                i++;
            }else{
                j++;
            }
        }

        if(str3.length()==i){
            return true;
        }

        return false;
   }



   private static int findLength(String str){

        int count=0;
        char[] strArray=str.toCharArray();

        for(int i=str.length()-1; i>=0;i--){

            if(str.charAt(i)!=' ') {
                count++;
            }else{
                break;
            }
        }

        return count;
    }
}
