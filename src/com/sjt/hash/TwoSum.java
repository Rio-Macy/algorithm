package com.sjt.hash;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author sujuntao
 */
public class TwoSum {


    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15};
        System.out.println(Arrays.toString(twoSum2(nums, 26)));
    }

    public static int[] twoSum(int[] nums, int target) {
        //遍历每个元素  查找后续元素与其相加的和  是否等于target
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        return new int[]{-1, -1};
    }


    public static int[] twoSum1(int[] nums, int target) {
        // 使用map 存储 <元素值，索引位置>
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }

        for (int i = 0; i < nums.length; i++) {
            int needNum = target - nums[i];
            // 数组中同一个元素不能使用两遍
            if (map.containsKey(needNum) && map.get(needNum) != i) {
                return new int[]{i, map.get(needNum)};
            }
        }
        return new int[]{-1, -1};
    }


    public static int[] twoSum2(int[] nums, int target) {
        // 边遍历边修改map的值   能达到最好效率
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int needNum = target - nums[i];
            if (map.containsKey(needNum)) {
                return new int[]{map.get(needNum), i};
            }
            map.put(nums[i], i);
        }

        return new int[]{-1, -1};
    }
}
