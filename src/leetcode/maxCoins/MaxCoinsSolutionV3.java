package leetcode.maxCoins;

import java.util.Arrays;

/**
 * 优化时间问题
 * @Author: huangbingjing
 * @DATE: 12/29/21
 */
public class MaxCoinsSolutionV3 {
    public static void main(String[] args) {
        MaxCoinsSolutionV3 solution = new MaxCoinsSolutionV3();
        int[] nums = new int[]{35,16,83,87,84,59,48,41,20,54};
//        int[] nums = new int[]{3,1,5,8};
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
        int[] leftIndexArr = new int[len]; //[1,3,1,5]
        int[] rightIndexArr = new int[len];//[1,5,8,1]
        int[] innerArr = new int[len-2];
        for (int i=0; i<len; i++) {
            if (i==0){
                leftIndexArr[i] = -1;
            }else {
                leftIndexArr[i] = i-1;
            }
            if (i==len-1) {
                rightIndexArr[i] = -1;
            }else {
                rightIndexArr[i] = i+1;
            }
            if (i>0 && i<len-1 ){
                innerArr[i-1] = nums[i];
            }
        }
        Arrays.sort(innerArr);
        int maxCoins = 0;
        int leftCount = len;
        // 计算中间的
        for (int j=0; j<innerArr.length-5; j++) {
            for (int i=1; i<len-2; i++) {
                if (nums[i] == innerArr[j]) {
                    maxCoins = maxCoins + nums[leftIndexArr[i]]*nums[i]*nums[rightIndexArr[i]];
                    removeOne(i, leftIndexArr, nums, rightIndexArr);
                    leftCount--;
                    break;
                }
            }
        }

        return maxCoins+eachArr(nums, leftIndexArr, rightIndexArr, 0, leftCount);

    }

    /**
     * 遍历
     */
    private int eachArr(int[] nums, int[] leftIndexArr, int[] rightIndexArr, int sum, int leftCount){
        if (leftCount == 0) {
            return sum;
        }

        int maxSum = 0;
        for (int i=0; i<nums.length; i++) {
            int num = nums[i];
            if (num==-1) {
                continue;
            }

            if (i == nums.length-1) {
                // 选
                int left = leftIndexArr[i]<0? 1: nums[leftIndexArr[i]];
                int right = rightIndexArr[i] <0? 1: nums[rightIndexArr[i]];
                removeOne(i, leftIndexArr, nums, rightIndexArr);
                int select = eachArr(nums, leftIndexArr, rightIndexArr, left*num*right, leftCount-1);
                if (select > maxSum) {
                    maxSum = select;
                }
                break;
            }

            int[] copyNums = Arrays.copyOf(nums, nums.length);
            int[] copyLeft = Arrays.copyOf(leftIndexArr, leftIndexArr.length);
            int[] copyRight = Arrays.copyOf(rightIndexArr, rightIndexArr.length);

            // 选
            int left = leftIndexArr[i]<0? 1: nums[leftIndexArr[i]];
            int right = rightIndexArr[i] <0? 1: nums[rightIndexArr[i]];
            removeOne(i, leftIndexArr, nums, rightIndexArr);
            int select = eachArr(nums, leftIndexArr, rightIndexArr, left*num*right, leftCount-1);
            if (select > maxSum) {
                maxSum = select;
            }

            nums = copyNums;
            leftIndexArr = copyLeft;
            rightIndexArr = copyRight;
        }
        return sum + maxSum;
    }

    private void removeOne(int index, int[] leftIndexArr, int[] nums, int[] rightIndexArr){
        nums[index] = -1;

        // 左边index-1的位置的右边是它的右边
        if (leftIndexArr[index] >=0) {
            rightIndexArr[leftIndexArr[index]] = rightIndexArr[index];
        }

        // 右边index+1的位置的左边是它的左边
        if (rightIndexArr[index] >= 0) {
            leftIndexArr[rightIndexArr[index]] = leftIndexArr[index];
        }

        rightIndexArr[index] = -1;
        leftIndexArr[index] = -1;
    }
    private int caculateHT(int len, int[] nums){
        int end = nums[0];
        if (nums[0]<nums[len-1]) {
            end = nums[len-1];
        }
        return nums[0]*nums[len-1] +end;
    }
}
