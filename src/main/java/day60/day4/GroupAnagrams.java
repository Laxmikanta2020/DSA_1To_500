package day60.day4;

import java.util.*;

public class GroupAnagrams {
    public static void main(String[] args) {
        String[] strs = {"eat", "eat", "tan", "ate", "nat", "bat"};

        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            char[] charArray = str.toCharArray();
            Arrays.sort(charArray);
            String s = new String(charArray);
            if(!map.containsKey(s)){
                map.put(s,new ArrayList<>());
            }
            map.get(s).add(str);
        }

         //    map.putIfAbsent(key, new ArrayList<>());
        //    map.get(key).add(str)
        System.out.println(map.values());
    }
}
