package com.sjt.array;

import java.util.HashMap;
import java.util.Map;

/**
 *  MajorityNumber 找出数组最多的数字 最多的数
 * @author sujuntao
 */
public class MajorityNumber {

    public static void main(String[] args) {

        int[] arr = {2, 2, 1, 1, 1, 2, 2};

        int res = MajorityNumber.majorityElement1(arr);
        System.out.println(res);
    }
    public static int majorityElement(int[] nums) {

        if (nums == null) {
            return -1;
        }

        Map<Integer, Integer> hashMap = new HashMap(nums.length);

        for (int i = 0; i < nums.length; i++) {

            int num = nums[i];
            if (!hashMap.containsKey(num)) {
                hashMap.put(num, 1);
            }else{
                hashMap.put(num, hashMap.get(num)+1);
            }
        }

        int len = nums.length / 2;
        int t = -1;

        for(Map.Entry<Integer, Integer> vo: hashMap.entrySet()){

            if(vo.getValue() > len){
              t = (vo.getKey());
            }
        }

        return t;
    }

    public static int majorityElement1(int[] nums) {

        if (nums == null) {
            return -1;
        }

        Map<Integer, Integer> hashMap = new HashMap(nums.length);

        for (int i = 0; i < nums.length; i++) {

            int num = nums[i];
            if (hashMap.containsKey(num)) {

                hashMap.put(num, hashMap.get(num)+1);
            }else{
                hashMap.put(num, 1);
            }
        }

        int len = nums.length / 2;
        int t = -1;
        for(Map.Entry<Integer, Integer> vo: hashMap.entrySet()){

            System.out.print(vo.getKey() + " ");
            System.out.println(vo.getValue());

            if(vo.getValue() > len){
                t= (vo.getKey());
            }
        }
        return t;
    }
}
