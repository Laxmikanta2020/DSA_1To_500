package com.laxmi.samal.arrayExample;

import java.util.*;
import java.util.stream.IntStream;

public class ArrayExp {

    public static void main(String[] args) {

        int la=10;
        Integer xy=70;
        Integer xxy=Integer.valueOf(la);
        int xc= xxy.intValue();

        System.out.println(xy);
        System.out.println(la);
        System.out.println(xxy);
        System.out.println(xc);


        int [] arr=new int[5];

        System.out.println(Arrays.toString(arr));

        arr[3]++;
        System.out.println(Arrays.toString(arr));
        arr[3]++;
        arr[3]++;
        arr[2]--;arr[2]--;
        System.out.println(Arrays.toString(arr));

        Map<String, List<Integer>> hmap= new HashMap<>();


        hmap.put("a", new ArrayList<>(10));
        if(hmap.containsKey("a")){

            List<Integer> a = hmap.get("a");
            hmap.put("a", a);
        }
        String s = "racecar";
        char[] charArray = s.toCharArray();
        IntStream chars = s.chars();
        String str = "HELLO";
        System.out.println(str.toLowerCase(Locale.CHINESE));
        String[] split = s.split("");
        System.out.println(Arrays.toString(charArray));
        System.out.println(Arrays.toString(split));
        //System.out.println(chars.mapToObj(s));

        int target=10;
        Map<Integer,Integer> hm=new HashMap<>();

        for(int t=0;t<arr.length;t++){
            int xx=target-arr[t];
            hmap.get(xx).add(10);

            if(hm.containsValue(xx)){
              //  new int[]{hm.get,t};
                hmap.computeIfAbsent(String.valueOf(xx), k->new ArrayList<>()).add(10);
                return;
            }else{
                hm.put(t,arr[t]);
            }
        }
    }

    // HashMap<Integer, Integer> map = new HashMap<>();
    //
    //    for(int i = 0; i < numbers.length; i++) {
    //        int complement = target - numbers[i];
    //
    //        if(map.containsKey(complement)) {
    //            return new int[]{map.get(complement), i};
    //        }
    //
    //        map.put(numbers[i], i);
    //    }
    //
    //    return new int[]{-1, -1};
}
