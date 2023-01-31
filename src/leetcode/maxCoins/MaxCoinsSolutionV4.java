package leetcode.maxCoins;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author: huangbingjing
 * @DATE: 12/29/21
 */
public class MaxCoinsSolutionV4 {
    public static void main(String[] args) {
        MaxCoinsSolutionV4 solution = new MaxCoinsSolutionV4();
        int[] nums = new int[]{7,9,8,0,7,1,3,5,5};
//        int[] nums = new int[]{35,16,83,87,84,59,48,41,20,54,11};
//        int[] nums = new int[]{2,3,7,9,1};
//        int[] nums = new int[]{9,76,64,21,97,60,5};
//        int[] nums = new int[]{1,5};
//        int[] nums = new int[]{9,76,64,21,97,60};
        int result = solution.maxCoins(nums);
        System.out.println(result);
    }

    public int maxCoins(int[] nums) {

        int len = nums.length;
        if (len == 1) {
            return nums[0];
        }
        if (len == 2) {
            return caculateHT(len, nums);
        }

        List<Integer> list = new ArrayList<>(len);
        for (int i:nums) {
            list.add(i);
        }


        return eachArr(list,  0, len);

    }

    /**
     * 遍历
     */
    private int eachArr(List<Integer> nums,  int sum, int leftCount){
        if (leftCount == 0) {
            return sum;
        }
        if (leftCount == 2) {
            int end = nums.get(0);
            if (nums.get(0)<nums.get(1)) {
                end = nums.get(1);
            }
            return sum+nums.get(0)*nums.get(1) +end;
        }

        int maxSum = 0;
        for (int i=0; i<nums.size(); i++) {
            int num = nums.get(i);
            if (i == nums.size()-1) {
                // 选
                int left = i==0? 1: nums.get(i-1);
                int right = i == nums.size()-1? 1: nums.get(i+1);
                nums.remove(i);
                int select = eachArr(nums, left*num*right, leftCount-1);
                if (select > maxSum) {
                    maxSum = select;
                }
                break;
            }

            List<Integer> copyNums = new ArrayList<>(nums);

            // 选
            int left = i==0? 1: nums.get(i-1);
            int right = i == nums.size()-1? 1: nums.get(i+1);
            nums.remove(i);
            int select = eachArr(nums, left*num*right, leftCount-1);
            if (select > maxSum) {
                maxSum = select;
            }

            nums = copyNums;
        }
        return sum + maxSum;
    }

    private int caculateHT(int len, int[] nums){
        int end = nums[0];
        if (nums[0]<nums[len-1]) {
            end = nums[len-1];
        }
        return nums[0]*nums[len-1] +end;
    }
}
