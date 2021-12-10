package leetcode.minIncrementForUnique;


import java.util.Arrays;

/**
 * 排序草稿xxxx
 * @Author: huangbingjing
 * @DATE: 12/3/21
 */
public class MinIncrementForUniqueSolutionV5 {

    public static void main(String[] args) {
        MinIncrementForUniqueSolutionV5 solution = new MinIncrementForUniqueSolutionV5();

//        int[] nums = new int[]{3,2,1,2,1,7};
        int[] nums = new int[]{0,1,2,2,2};
//        int[] nums = new int[]{1,2,2};
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

        Arrays.sort(nums);
        int minNum = nums[0];
        int minCount = 0;
        int moveCount = 0;
        for (int num : nums) {
            if (num == minNum) {
                minCount++;
            } else if (num < minNum) {
                moveCount = moveCount + minNum - num;
                minCount++;
            } else {
                if (minCount > 1) {
                    moveCount = moveCount + minCount * (minCount - 1) / 2;
                }
                int nextMinNum = minCount + minNum;

                minNum = nextMinNum > num ? nextMinNum : num;
                minCount = 1;
                if (num < minNum) {
                    moveCount = moveCount + minNum - num;
                }
            }
        }
        if (minCount > 1) {
            moveCount = moveCount + minCount*(minCount-1)/2;
        }

        return moveCount;
    }


}
