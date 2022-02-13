package com.sjt.array;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author sujuntao
 *  ##### 1、数组中重复的数字
 *
 * https://leetcode-cn.com/problems/shu-zu-zhong-zhong-fu-de-shu-zi-lcof/
 *
 *  剑指 Offer 03. 数组中重复的数字
 *
 *  找出数组中重复的数字。
 *
 *
 * 在一个长度为 n 的数组 nums 里的所有数字都在 0～n-1 的范围内。数组中某些数字是重复的，但不知道有几个数字重复了，也不知道每个数字重复了几次。请找出数组中任意一个重复的数字。
 *
 * 示例 1：
 * 输入：
 * [2, 3, 1, 0, 2, 5, 3]
 * 输出：2 或 3
 *
 * 使用数组本身的特点 或者 JDK中的工具去实现
 */
public class FindRepeatNumber {

    public static void main(String[] args) {

        int[] nums = {2, 1, 1, 0, 2, 1, 3};
//        int result = FindRepeatNumber.findRepeatNumber(nums);
//        int result1 = FindRepeatNumber.findRepeatNumber1(nums);
//        System.out.println(result1);
//        int result2 = FindRepeatNumber.findRepeatNumber4(nums);
//        System.out.println(result2);
        int result3 = FindRepeatNumber.findRepeatNumber4(nums);
        System.out.println(result3);
    }

    /**
     *  通过 Set的去重的特性，找出重复的元素
     * @param nums
     * @return
     */
    public static int findRepeatNumber(int[] nums) {

        if (nums == null) {
            return -1;
        }

        Set<Integer> integers = new HashSet<>(nums.length);

        for (int num: nums){
            // 如果integers包含num元素则表明num元素重复出现
            if (integers.contains(num)) {
                return num;
            }

            integers.add(num);
        }
        return -1;
    }

    /**
     *  将数组处理为有序数组，判断相邻元素判断元素是否重复
     * @param nums
     * @return
     */
    public static int findRepeatNumber1(int[] nums) {

        if (nums == null) {
            return -1;
        }
        // 使用Arrays类中sort()方法将nums数组变为有序数组
        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 1; i++) {
            int num = nums[i];
            //判断num与num后一个元素的比较，若对于返回num
            if (num == nums[i + 1]) {
                return num;
            }

        }

        return -1;
    }

    /**
     *  用一个新数组，存储目标数组元素出现的个数
     * @param nums
     * @return
     */
    public static int findRepeatNumber2(int[] nums) {

        if (nums == null) {
            return -1;
        }

        int[] ns = new int[nums.length];
        // ns记录nums数组元素出现的个数
        for (int i = 0; i < nums.length; i++) {
            int t = nums[i];
            ns[t] += 1;
        }
        // 查找ns数组中大于2的数字
        for (int i = 0; i < nums.length; i++) {
            if (ns[nums[i]] >= 2) {
                return nums[i];
            }
        }

        return -1;
    }

    /**
     *  用一个新数组，新数组记录存储目标数组元素是否存在
     * @param nums
     * @return
     */
    public static int findRepeatNumber3(int[] nums) {

        if (nums == null) {
            return -1;
        }

        int[] ns = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {
            int t = nums[i];
            // 判断是否存在此元素，不等于0存在
            if (ns[t] != 0) {
                return t;
            }

            ns[t] = 1;
        }

        return -1;
    }

    /**
     * 希望当前位置  和 出现元素正好匹配上
     * 先判断  是否匹配  如果不匹配 进行交换  并且看需要交换的位置  是否存在期望元素
     * 如果可以 交换之后  继续遍历当前位置   如果不可交换  即为重复元素
     * @param nums
     * @return
     */
    public static int findRepeatNumber4(int[] nums) {

        if (nums == null) {
            return -1;
        }

        for (int i = 0; i < nums.length; i++) {
            // 如果索引正好等于元素本身 是期望的结果 跳过
            if (nums[i] == i) {
                continue;
            }
            int num = nums[i];
            // 如果要交换的位置，已经有期望值，说明重复
            if (nums[num] == num) {
                return num;
            }
            int temp = nums[num];
            nums[num]= num;
            nums[i] = temp;
            i--;
        }
        return -1;
    }
}
