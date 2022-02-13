package com.sjt.array;

/**
 *  二维数组转化稀疏数组
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
