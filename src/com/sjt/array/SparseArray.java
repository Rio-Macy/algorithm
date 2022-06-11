package com.sjt.array;

/**
 *  二维数组转化稀疏数组(节省空间)压缩
 *
 *  保存原始的行数和列数
 *  保存非零元素的位置
 *
 *  行  列  元素值
 *  10  10   3
 *   1  2    1
 *   3  1    2
 *   2  2    2
 * @author sujuntao
 */
public class SparseArray {

    public static void main(String[] args) {

        int[][] arr = new int[10][10];

        arr[2][4] = 1;
        arr[6][4] = 3;
        arr[7][4] = 1;
        arr[8][4] = 3;

        int[][] res = SparseArray.toSparse(arr);

        for (int i = 0; i < res.length; i++) {

            for (int j = 0; j < 3; j++) {

                System.out.print(res[i][j] + " ");
            }
            System.out.println();
        }
    }


    /**
     *   把普通数组 转化为 稀疏数组
     *   用 (n+1)*3列的数组  压缩，n代表非零元素的个数
     *   第一行  存储总行数  总列数  和 非零元素的个数
     *   接下来每一行  存储  元素的行数  列数 和 自身元素值
     * @param nums
     * @return
     */
    public static int[][] toSparse(int[][] nums) {

        if (nums == null) {
            return null;
        }

        int count = 0;

        for (int i = 0; i < nums.length; i++) {

            for (int j = 0; j < nums.length; j++) {
                if (nums[i][j] != 0) {
                    count++;
                }
            }
        }

        int[][] result = new int[count + 1][3];
        result[0][0] = nums.length;
        result[0][1] = nums[0].length;
        result[0][2] = count;

        int index = 0;

        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                if (nums[i][j] != 0) {
                    ++index;
                    result[index][0] = i;
                    result[index][1] = j;
                    result[index][2] = nums[i][j];
                }
            }

        }

        return result;
    }
}
