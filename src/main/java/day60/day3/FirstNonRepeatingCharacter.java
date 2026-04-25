package day60.day3;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class FirstNonRepeatingCharacter {
    public static void main(String[] args) {
        String name = "laxmikanta";
        Map<Character, Integer> map = new LinkedHashMap<>();
        for (char c : name.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            if (entry.getValue() == 1) {
                System.out.println(entry.getKey() + " " + entry.getValue());
                break;
            }
        }

        LinkedHashMap<Character, Long> longLinkedHashMap = name.chars().mapToObj(x -> (char) x)
                .collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()));
        var first = longLinkedHashMap.entrySet().stream().filter(x -> x.getValue() == 1).map(Map.Entry::getKey).findFirst().get();
        System.out.println(first);
        int[] frq = new int[26];
// first convert to lower case
        for (char c : name.toCharArray()) {
//            frq[c - 'a'] = +1;
//            System.out.println(Arrays.toString(frq));
//            frq[c - 'a'] = frq[c - 'a'] + 1;
//            System.out.println(Arrays.toString(frq));
            frq[c - 'a']++;
        }
        for (char c : name.toCharArray()) {
            if (frq[c - 'a'] == 1) {
                System.out.println(c);
                break;
            }

        }
    }
}
//Given an Employee table, write a query to find departments where every employee earns more than the company-wide average salary.
//Employee(
//  id INT,
//  name VARCHAR,
//  department VARCHAR,
//  salary INT
//)
//
//id | name | department | salary
//--------------------------------
//1  | A    | IT         | 3000
//2  | B    | IT         | 4000
//3  | C    | HR         | 1000
//4  | D    | HR         | 2000
//5  | E    | SALES      | 5000