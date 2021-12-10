package leetcode.minIncrementForUnique;


import java.util.Arrays;

/**
 * 排序-最终版: https://leetcode-cn.com/problems/minimum-increment-to-make-array-unique/
 * @Author: huangbingjing
 * @DATE: 12/3/21
 */
public class MinIncrementForUniqueSolutionV6 {

    public static void main(String[] args) {
        MinIncrementForUniqueSolutionV6 solution = new MinIncrementForUniqueSolutionV6();

//        int[] nums = new int[]{3,2,1,2,1,7};
//        int[] nums = new int[]{0,1,2,2,2};
        int[] nums = new int[]{1,2,2};
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
        int minNum = nums[0]+1;
        int moveCount = 0;
        for (int i=1; i<nums.length; i++) {
            int num = nums[i];
            if (num<minNum){
                moveCount = moveCount + minNum - num;
            }else {
                minNum=num;
            }
            minNum++;
        }

        return moveCount;
    }


}
