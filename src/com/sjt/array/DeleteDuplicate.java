package com.sjt.array;

import java.util.Arrays;

/**
 *  DeleteDuplicate 删除重复的数字
 *
 *  ###### 删除排序数组中的重复项
 *
 * https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array/
 *
 * >给定一个排序数组，你需要在 原地 删除重复出现的元素，使得每个元素只出现一次，返回移除后数组的新长度。
 * >
 * >不要使用额外的数组空间，你必须在 原地 修改输入数组 并在使用 O(1) 额外空间的条件下完成。
 * >
 * >
 * >
 * >示例 1:
 * >
 * >给定数组 nums = [1,1,2],
 * >
 * >函数应该返回新的长度 2, 并且原数组 nums 的前两个元素被修改为 1, 2。
 * >
 * >你不需要考虑数组中超出新长度后面的元素。
 *
 * @author sujuntao
 */
public class DeleteDuplicate {

    public static void main(String[] args) {

        int[] arr = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        int index = DeleteDuplicate.removeDeleteDuplicate(arr);
        System.out.println(index);
        System.out.println(Arrays.toString(arr));
    }

    public static int removeDeleteDuplicate(int[] arr) {

        if (arr == null) {

            return -1;
        }
        // 记录要比较的元素位置
        int index = 0;

        for (int i = 1; i < arr.length; i++) {

            int i1 = arr[i];
            // 如果不同  进行覆盖
            if (i1 != arr[index]) {
                index++;
                arr[index] = arr[i];
            }

        }
        // 新数组的长度 = 最大索引+1
        return index + 1;
    }

}
