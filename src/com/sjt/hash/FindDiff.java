package com.sjt.hash;

import java.util.HashMap;
import java.util.Map;

/**
 * @author sujuntao
 */
public class FindDiff {

    public static void main(String[] args) {
        System.out.println(findTheDifference3("abcd", "abcde"));
        System.out.println(findTheDifference3("abcd", "abcda"));
    }

    public static char findTheDifference(String s, String t) {
        Map<Character, Integer> map = new HashMap<>();
        // 存储s中的字母  及其出现次数
        for (Character c : s.toCharArray()) {
            if (map.containsKey(c)) {
                int newNum = map.get(c) + 1;
                map.put(c, newNum);
                continue;
            }
            map.put(c, 1);
        }

        for (char tc : t.toCharArray()) {
            // 在s中从未出现的字母
            if (!map.containsKey(tc)) {
                return tc;
            }

            // 查找t中出现次数多了一次
            if (map.get(tc) == 0) {
                return tc;
            }

            int newNum = map.get(tc) - 1;
            map.put(tc, newNum);
        }

        return '-';
    }


    public static char findTheDifference1(String s, String t) {
        for (Character c : s.toCharArray()) {
            // 替换第一个出现的位置
            t = t.replaceFirst(c.toString(), "");
        }
        return t.toCharArray()[0];
    }


    // 根据ascii码表的特性
    public static char findTheDifference2(String s, String t) {
        int sSum = 0, tSum = 0;
        for (Character c : s.toCharArray()) {
            sSum += c;
        }

        for (Character c : t.toCharArray()) {
            tSum += c;
        }

        return (char) (tSum - sSum);
    }


    //异或运算
    public static char findTheDifference3(String s, String t) {
        int result = 0;
        for (Character c : s.toCharArray()) {
            result ^= c;
        }

        for (Character c : t.toCharArray()) {
            result ^= c;
        }

        return (char) result;
    }
}
