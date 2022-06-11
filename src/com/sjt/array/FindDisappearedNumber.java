package com.sjt.array;

import java.util.*;

/**
 * @author sujuntao
 *  FindDisappearedNumber 找到消失的数字
 * ##### 2、数组中消失的数字
 *
 * https://leetcode-cn.com/problems/find-all-numbers-disappeared-in-an-array/
 *
 * 找到所有数组中消失的数字
 * 给定一个范围在  1 ≤ a[i] ≤ n ( n = 数组大小 ) 的 整型数组，数组中的元素一些出现了两次，另一些只出现一次。
 *
 * 找到所有在 [1, n] 范围之间没有出现在数组中的数字。
 *
 * 您能在不使用额外空间且时间复杂度为O(n)的情况下完成这个任务吗? 你可以假定返回的数组不算在额外空间内。
 *
 * 示例:
 *
 * 输入:
 * [4,3,2,7,8,2,3,1]
 *
 * 输出:
 * [5,6]
 */
public class FindDisappearedNumber {

    public static void main(String[] args) {

        int[] nums = {4, 3, 2, 7, 8, 2, 3, 1};

        List<Integer> integers = FindDisappearedNumber.findDisappearedNumbers1(nums);
//        Set<Integer> integerSet = new HashSet<>(nums.length);
        System.out.println(integers);
        System.out.println(!integers.contains("1"));
    }

    /**
     * 使用Set 和 List元素来处理重复元素
     * @param nums
     * @return
     */
    public static List<Integer> findDisappearedNumbers(int[] nums) {

        if (nums == null) {

            return null;
        }

        List<Integer> integerList = new ArrayList<>(nums.length);
        Set<Integer> integerSet = new HashSet<>(nums.length);
        // Set去重，存储了没有重复的数组元素
        for (int i = 0; i < nums.length; i++) {

            integerSet.add(nums[i]);
        }
        // 判断Set中的不包含的元素，将其存入List中
        for (int i = 1; i < nums.length; i++) {
            // 判断Set没有i这个值，存入List
            if (!integerSet.contains(i)) {
                integerList.add(i);
            }
        }

        return integerList;
    }

    /**
     * 不使用额外的空间
     * 利用数组的特性 用索引来记录已经出现的数字
     * @param nums
     * @return
     */
    public static List<Integer> findDisappearedNumbers1(int[] nums) {

        if (nums == null) {
            return null;
        }

        List<Integer> integerList = new ArrayList<>(nums.length);

        for (int i = 0; i < nums.length; i++) {

            int num = Math.abs(nums[i]);
            int index = num - 1;

            if (nums[index] > 0) {
                // 将对应索引位置的值置为负数， 提前是这个数是整数
                nums[index] = -nums[index];
                System.out.println("索引" + index + "" + Arrays.toString(nums));
            }
        }

        for (int i = 0; i < nums.length; i++) {

            if (nums[i] > 0) {
                integerList.add(i + 1);
                System.out.println(nums[i] + "元素仍为正数，找到" + (i + 1));
            }
        }

        return integerList;
    }
}