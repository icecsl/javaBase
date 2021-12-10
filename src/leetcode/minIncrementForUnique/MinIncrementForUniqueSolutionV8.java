package leetcode.minIncrementForUnique;


import java.util.Arrays;

/**
 * 超时 。。。。
 * @Author: huangbingjing
 * @DATE: 12/3/21
 */
public class MinIncrementForUniqueSolutionV8 {

    public static void main(String[] args) {
        MinIncrementForUniqueSolutionV8 solution = new MinIncrementForUniqueSolutionV8();

        int[] nums = new int[]{3,2,1,2,1,7};
//        int[] nums = new int[]{0,1,2,2,2};
//        int[] nums = new int[]{1,2,2};
//        int[] nums = new int[]{0,2,0};
        int result = solution.minIncrementForUnique(nums);
        System.out.println(result);
    }



    public int minIncrementForUnique(int[] nums) {

        int len = nums.length;
        if (len == 0 || len == 1) {
            return 0;
        }
        if (len == 2) {
            return nums[0] == nums[1]?1:0;
        }

        int[] sortArr = new int[len];
        for (int i=0; i<len; i++) {
            sortArr[i] =-1;
        }
        int count = 0;
        for (int i=0; i<len; i++) {
            int num = nums[i];
            if (i==0) {
                sortArr[i] = num;
                continue;
            }
            count = put(sortArr, 0, num, count);
        }

        return count;
    }

    private int put(int[] posNumArr, int index, int currNum, int count){
        if (index >posNumArr.length-1) {
            return count;
        }
        int value = posNumArr[index];
        if (value != -1 && currNum>value) {
            return put(posNumArr, index+1, currNum, count);
        }
        if (currNum==value) {
            count++;
            currNum++;
            return put(posNumArr, index+1, currNum, count);
        }
        // 放入
        putInto(posNumArr, index, currNum);
        return count;

    }

    // 放入
    private void putInto(int[] posNumArr, int index, int currNum){
        if (index >posNumArr.length-1) {
            return ;
        }

        int value = posNumArr[index];
        if (value!=-1) {
            putInto(posNumArr, index+1, posNumArr[index]);
        }
        posNumArr[index] = currNum;
    }


}
