package com.sjt.array;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author sujuntao
 */
public class FindRepeatNumber {

    public static void main(String[] args) {

        int[] nums = {2, 3, 1, 0, 2, 5, 3};
        int result = FindRepeatNumber.findRepeatNumber(nums);
//        Arrays.sort(nums);
        int result1 = FindRepeatNumber.findRepeatNumber1(nums);
        int result2 = FindRepeatNumber.findRepeatNumber4(nums);

        System.out.println(result2);
    }

    public static int findRepeatNumber(int[] nums) {

        if (nums == null) {
            return -1;
        }

        Set<Integer> integers = new HashSet<>(nums.length);

        for (int num: nums){

            if (integers.contains(num)) {
                return num;
            }

            integers.add(num);
        }
        return -1;
    }

    public static int findRepeatNumber1(int[] nums) {

        if (nums == null) {
            return -1;
        }

        for (int i = 0; i < nums.length -1; i++) {
            int num = nums[i];
            if (num == nums[i + 1]) {
                return num;
            }

        }

        return -1;
    }

    public static int findRepeatNumber2(int[] nums) {

        if (nums == null) {
            return -1;
        }

        int[] ns = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {
            int t = nums[i];
            ns[t] +=1;
        }
        System.out.println(Arrays.toString(ns));
        for (int i = 0; i < nums.length; i++) {

            if (ns[nums[i]] >= 2) {

                return nums[i];
            }
        }

        return -1;
    }
    public static int findRepeatNumber3(int[] nums) {

        if (nums == null) {
            return -1;
        }

        int[] ns = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {
            int t = nums[i];
            if (ns[t] != 0) {
                return t;
            }
            ns[t] = 1;
        }
        System.out.println(Arrays.toString(ns));
        return -1;
    }

    public static int findRepeatNumber4(int[] nums) {

        if (nums == null) {
            return -1;
        }

        for (int i = 0; i < nums.length; i++) {
            int temp = nums[i];
            nums[i] = nums[temp];
            nums[temp]= temp;
        }
        return -1;
    }
}
