package com.sjt.array;

import java.util.Arrays;

/**
 * ###### 移除元素
 * <p>
 * https://leetcode-cn.com/problems/remove-element/
 *
 * @author sujuntao
 */
public class RemoveElement {

    public static void main(String[] args) {
        int[] arr = {0, 1, 2, 2, 3, 0, 4, 2};
        int val = 2;
        int index = RemoveElement.removeElement1(arr, val);
        System.out.println(index);
        System.out.println(Arrays.toString(arr));
    }

    public static int removeElement(int[] arr, int val) {

        if (arr == null) {
            return 0;
        }

        int index = 0;

        for (int i = 0; i < arr.length; i++) {

            if (val !=  arr[i]) {
                arr[index] = arr[i];
                System.out.println("将" + arr[i] + "覆盖到" + index + "位置上");
                index++;
            }
        }

        return index;
    }

    public static int removeElement1(int[] arr, int val) {

        if (arr == null) {
            return 0;
        }

        int index = 0;
        int len = arr.length;

        while (true){

            if (index >= len) {
                return -1;
            }

            if (arr[index] == val) {

                arr[index] = arr[len - 1];
                arr[len - 1] = val;
                len--;
                index--;
            }
            index++;
        }
    }
}
